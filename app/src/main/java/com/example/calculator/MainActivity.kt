package com.example.calculator

import android.graphics.Color
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    lateinit var button0 : android.widget.Button
    lateinit var button1 : android.widget.Button
    lateinit var button2 : android.widget.Button
    lateinit var button3 : android.widget.Button
    lateinit var button4 : android.widget.Button
    lateinit var button5 : android.widget.Button
    lateinit var button6 : android.widget.Button
    lateinit var button7 : android.widget.Button
    lateinit var button8 : android.widget.Button
    lateinit var button9 : android.widget.Button
    lateinit var button00 : android.widget.Button
    lateinit var buttonclear : android.widget.Button
    lateinit var buttonpercent : android.widget.Button
    lateinit var buttonbackspace : android.widget.Button
    lateinit var buttondivide : android.widget.Button
    lateinit var buttonmultiply : android.widget.Button
    lateinit var buttonminus : android.widget.Button
    lateinit var buttonplus : android.widget.Button
    lateinit var buttonequal : android.widget.Button
    lateinit var buttondot : android.widget.Button
    lateinit var inputtext : EditText
    lateinit var resulttext : EditText
    var check = 0




    override fun onCreate(savedInstanceState: Bundle?) {



        setTheme(R.style.mytheme)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        WindowCompat.setDecorFitsSystemWindows(window, true)
        window.statusBarColor = Color.parseColor("#454c53")
        window.navigationBarColor = Color.parseColor("#000000")



        button0 = findViewById(R.id.btnzero)
        button1 = findViewById(R.id.btnone)
        button2 = findViewById(R.id.btntwo)
        button3 = findViewById(R.id.btnthree)
        button4 = findViewById(R.id.btnfour)
        button5 = findViewById(R.id.btnfive)
        button6 = findViewById(R.id.btnsix)
        button7 = findViewById(R.id.btnseven)
        button8 = findViewById(R.id.btneight)
        button9 = findViewById(R.id.btnnine)
        button00 = findViewById(R.id.btndoublezero)
        buttondot = findViewById(R.id.btndot)
        buttonclear = findViewById(R.id.btnclear)
        buttonpercent = findViewById(R.id.btnpercent)
        buttonbackspace = findViewById(R.id.btnbackspace)
        buttondivide = findViewById(R.id.btndivide)
        buttonmultiply = findViewById(R.id.btnmultiply)
        buttonminus = findViewById(R.id.btnminus)
        buttonplus = findViewById(R.id.btnplus)
        buttonequal = findViewById(R.id.btnequal)
        inputtext = findViewById(R.id.btninput)
        resulttext = findViewById(R.id.btnresult)

        inputtext.movementMethod = ScrollingMovementMethod()


        var text : String


        button0.setOnClickListener {
            val current = inputtext.text.toString()
            if (inputtext.text.toString() == "0") {
                inputtext.setText("") // Clear the default "0"
            }
            if (isLastCharOperator(current)){
                return@setOnClickListener
            }
            text = inputtext.text.toString()+"0"
            inputtext.setText(text)
            result(text)
        }

        button1.setOnClickListener {
            if (inputtext.text.toString() == "0") {
                inputtext.setText("") // Clear the default "0"
            }
            text = inputtext.text.toString()+"1"
            inputtext.setText(text)
            result(text)
        }

        button2.setOnClickListener {
            if (inputtext.text.toString() == "0") {
                inputtext.setText("") // Clear the default "0"
            }
            text = inputtext.text.toString()+"2"
            inputtext.setText(text)
            result(text)
        }

        button3.setOnClickListener {
            if (inputtext.text.toString() == "0") {
                inputtext.setText("") // Clear the default "0"
            }
            text = inputtext.text.toString()+"3"
            inputtext.setText(text)
            result(text)
        }

        button4.setOnClickListener {
            if (inputtext.text.toString() == "0") {
                inputtext.setText("") // Clear the default "0"
            }
            text = inputtext.text.toString()+"4"
            inputtext.setText(text)
            result(text)
        }

        button5.setOnClickListener {
            if (inputtext.text.toString() == "0") {
                inputtext.setText("") // Clear the default "0"
            }
            text = inputtext.text.toString()+"5"
            inputtext.setText(text)
            result(text)
        }

        button6.setOnClickListener {
            if (inputtext.text.toString() == "0") {
                inputtext.setText("") // Clear the default "0"
            }
            text = inputtext.text.toString()+"6"
            inputtext.setText(text)
            result(text)
        }

        button7.setOnClickListener {
            if (inputtext.text.toString() == "0") {
                inputtext.setText("") // Clear the default "0"
            }
            text = inputtext.text.toString()+"7"
            inputtext.setText(text)
            result(text)
        }

        button8.setOnClickListener {
            if (inputtext.text.toString() == "0") {
                inputtext.setText("") // Clear the default "0"
            }
            text = inputtext.text.toString()+"8"
            inputtext.setText(text)
            result(text)
        }

        button9.setOnClickListener {
            if (inputtext.text.toString() == "0") {
                inputtext.setText("") // Clear the default "0"
            }
            text = inputtext.text.toString()+"9"
            inputtext.setText(text)
            result(text)
        }

        button00.setOnClickListener {
            val current = inputtext.text.toString()

            if (current == "0" || current.isEmpty()) {
                return@setOnClickListener
                inputtext.setText("")
            }
            if (isLastCharOperator(current)){
                return@setOnClickListener
            }

            text = inputtext.text.toString()+"00"
            inputtext.setText(text)
            result(text)
        }

        buttondot.setOnClickListener {
            if (inputtext.text.toString() == "0") {
                inputtext.setText("0.") // Clear the default "0"
            }
            val current = inputtext.text.toString()
            if (isLastCharOperator(current)) return@setOnClickListener
            val lastNumber = current.takeLastWhile { it.isDigit() || it == '.' }
            if ('.' in lastNumber) return@setOnClickListener
            text = inputtext.text.toString()+"."
            inputtext.setText(text)
            result(text)
        }

        buttonpercent.setOnClickListener {
            val current = inputtext.text.toString()
            if (current.isEmpty() || current == "0") return@setOnClickListener // prevent starting with operator
            if (isLastCharOperator(current)) return@setOnClickListener
            text = current + "%"
            inputtext.setText(text)
            result(text)
            check = check+1
        }

        buttondivide.setOnClickListener {
            val current = inputtext.text.toString()
            if (current.isEmpty() || current == "0") return@setOnClickListener // prevent starting with operator
            if (isLastCharOperator(current)) return@setOnClickListener
            text = current + "÷"
            inputtext.setText(text)
            result(text)
            check = check+1
        }

        buttonmultiply.setOnClickListener {
            val current = inputtext.text.toString()
            if (current.isEmpty() || current == "0") return@setOnClickListener // prevent starting with operator
            if (isLastCharOperator(current)) return@setOnClickListener
            text = current + "×"
            inputtext.setText(text)
            result(text)
            check = check+1
        }

        buttonminus.setOnClickListener {
            val current = inputtext.text.toString()
            if (current.isEmpty() || current == "0") return@setOnClickListener // prevent starting with operator
            if (isLastCharOperator(current)) return@setOnClickListener
            text = current + "−"
            inputtext.setText(text)
            result(text)
            check = check+1
        }

        buttonplus.setOnClickListener {
            val current = inputtext.text.toString()
            if (current.isEmpty() || current == "0") return@setOnClickListener // prevent starting with operator
            if (isLastCharOperator(current)) return@setOnClickListener
            text = current + "+"
            inputtext.setText(text)
            result(text)
            check = check+1
        }

        buttonclear.setOnClickListener {
            inputtext.setText("0")
            resulttext.setText("0")
        }

        buttonbackspace.setOnClickListener {
            var current = inputtext.text.toString()

            if (inputtext.text.isNotEmpty()) {
                val find = inputtext.text.toString()
                val find2 = find.last()

                if (find2.equals('+') || find2.equals('−') || find2.equals('×') || find2.equals('%') || find2.equals('÷')) {
                    check -= 1
                }

                val updateted = current.dropLast(1)
                inputtext.setText(updateted)

                if (updateted.isNotEmpty()){
                    result(updateted)
                }else{
                    inputtext.setText("0")
                    resulttext.setText("0")
                    check=0
                }


            }
        }

        buttonequal.setOnClickListener{
            text = resulttext.text.toString()
            inputtext.setText(text)
            resulttext.text = null
        }

    }

    private fun result(text: String) {

        val engine :ScriptEngine = ScriptEngineManager().getEngineByName("rhino")

        try {

            val cleantext = text
                .replace("%","/100")
                .replace("÷","/")
                .replace("×","*")
                .replace("−","-")
                .replace("+","+")


            val resultc = engine.eval(cleantext)
            val myresult = when(resultc){
                is Double -> {

                    if (resultc % 1 ==0.0){
                        resultc.toInt().toString()
                    }
                    else{
                        resultc.toString()
                    }
                }

                is Int -> resultc.toInt().toString()

                else -> resultc.toString()
            }




            if (check==0){
                resulttext.text = null
            }
            else{
                resulttext.setText(myresult)
            }



        }catch (e : ScriptException){
            Log.d("TAG", "result: ERROR")
        }

    }

    private fun isLastCharOperator(text : String) : Boolean{
        return text.isNotEmpty() && text.last() in listOf('+', '−', '×', '÷', '%','.')
    }


}