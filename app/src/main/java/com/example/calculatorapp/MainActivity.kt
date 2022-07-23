package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ScrollView
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {
 lateinit var button1:androidx.appcompat.widget.AppCompatButton
 lateinit var button2:androidx.appcompat.widget.AppCompatButton
 lateinit var button3:androidx.appcompat.widget.AppCompatButton
 lateinit var button4:androidx.appcompat.widget.AppCompatButton
 lateinit var button5:androidx.appcompat.widget.AppCompatButton
 lateinit var button6:androidx.appcompat.widget.AppCompatButton
 lateinit var button7:androidx.appcompat.widget.AppCompatButton
 lateinit var button8:androidx.appcompat.widget.AppCompatButton
 lateinit var button9:androidx.appcompat.widget.AppCompatButton

 lateinit var buttonadd:androidx.appcompat.widget.AppCompatButton
 lateinit var buttonsubtraction:androidx.appcompat.widget.AppCompatButton
 lateinit var buttonmultiplication:androidx.appcompat.widget.AppCompatButton
 lateinit var buttondivision:androidx.appcompat.widget.AppCompatButton
 lateinit var buttonbackspace:androidx.appcompat.widget.AppCompatButton
 lateinit var buttonequal:androidx.appcompat.widget.AppCompatButton
 lateinit var buttonclear:androidx.appcompat.widget.AppCompatButton
 lateinit var buttondecimal:androidx.appcompat.widget.AppCompatButton
 lateinit var buttonpercent:androidx.appcompat.widget.AppCompatButton
 lateinit var inputtext:EditText
 lateinit var resulttext: EditText
 var check=0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1=findViewById(R.id.button1)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button4)
        button5=findViewById(R.id.button5)
        button6=findViewById(R.id.button6)
        button7=findViewById(R.id.button7)
        button8=findViewById(R.id.button8)
        button9=findViewById(R.id.button9)
        buttonadd=findViewById(R.id.buttonadd)
        buttondecimal=findViewById(R.id.buttodecimal)
        buttondivision=findViewById(R.id.Division)
        buttonbackspace=findViewById(R.id.Backspace)
        buttonsubtraction=findViewById(R.id.buttonsubtract)
        buttonmultiplication=findViewById(R.id.buttonmultiplication)
        buttonclear=findViewById(R.id.clear)
        buttonpercent=findViewById(R.id.percent)
        buttonequal=findViewById(R.id.buttonequal)
        inputtext=findViewById(R.id.edt_inputnum1)
        resulttext=findViewById(R.id.edt_results)

        inputtext.run { movementMethod }
        inputtext.run { isActivated }
        inputtext.run { isPressed }

        var text:String


        button1.setOnClickListener {
            text=inputtext.text.toString()+"1"
            inputtext.setText(text)
            result(text)
        }
        button2.setOnClickListener {
            text=inputtext.text.toString()+"2"
            inputtext.setText(text)
            result(text)
        }
        button3.setOnClickListener {
            text=inputtext.text.toString()+"3"
            inputtext.setText(text)
            result(text)
        }
        button4.setOnClickListener {
            text=inputtext.text.toString()+"4"
            inputtext.setText(text)
            result(text)
        }
        button5.setOnClickListener {
            text=inputtext.text.toString()+"5"
            inputtext.setText(text)
         result(text)
        }
        button6.setOnClickListener {
            text=inputtext.text.toString()+"6"
            inputtext.setText(text)
           result(text)
        }
        button7.setOnClickListener {
            text=inputtext.text.toString()+"7"
            inputtext.setText(text)
            result(text)
        }
        button8.setOnClickListener {
            text=inputtext.text.toString()+"8"
            inputtext.setText(text)
           result(text)
        }
        button9.setOnClickListener {
            text=inputtext.text.toString()+"9"
            inputtext.setText(text)
            result(text)
        }



        buttonadd.setOnClickListener {
            text=inputtext.text.toString()+"+"
            inputtext.setText(text)
            check=check+1
        }
        buttonsubtraction.setOnClickListener {
            text=inputtext.text.toString()+"-"
            inputtext.setText(text)
            check=check+1
        }
        buttonmultiplication.setOnClickListener {
            text=inputtext.text.toString()+"*"
            inputtext.setText(text)
            check=check+1
        }
        buttondivision.setOnClickListener {
            text=inputtext.text.toString()+"/"
            inputtext.setText(text)
            check=check+1
        }
        buttonpercent.setOnClickListener {
            text=inputtext.text.toString()+"%"
            inputtext.setText(text)
            check=check+1
        }
        buttonequal.setOnClickListener {
            text=resulttext.text.toString()
            inputtext.setText(text)
            resulttext.setText(null)
        }
        buttonclear.setOnClickListener {
            inputtext.setText(null)
            resulttext.setText(null)

        }
        buttonbackspace.setOnClickListener {
            var backspace: String ?=null
            if(inputtext.text.length>0){

                val stringbuilder: StringBuilder= StringBuilder(inputtext.text)
                val find=inputtext.text.toString()
                val find2=find.last()

                if(find2.equals('+')||find2.equals('-')||find2.equals('*')||find2.equals('/')||find2.equals('%')){
                    check=check-1
                }
                stringbuilder.deleteCharAt(inputtext.text.length-1)
                backspace=stringbuilder.toString()
                inputtext.setText(backspace)
                result(backspace)
            }
        }


    }



    private fun result(text: String) {

        val engine : ScriptEngine= ScriptEngineManager().getEngineByName("rhino")
        try {
            val result:Any=engine.eval(text)
            val main=result.toString()
            if (check==0){
                resulttext.setText(null)

            }
            else{
                resulttext.setText(main)
            }
        }
        catch (e: ScriptException){
            Log.d("error", error("sytax error"))
        }


    }
}