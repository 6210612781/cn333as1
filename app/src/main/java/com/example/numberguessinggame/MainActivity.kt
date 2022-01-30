package com.example.numberguessinggame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import java.lang.NumberFormatException
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var  textView: TextView
    lateinit var  editText: EditText
    lateinit var  ButtonReset: Button
    lateinit var  ButtonCheck: Button
    lateinit var  textView3: TextView



    var random: Int = nextInt(1,1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        ButtonReset = findViewById(R.id.ButtonReset)
        ButtonCheck = findViewById(R.id.ButtonCheck)
        textView3 = findViewById(R.id.textView3)
        textView.text = "Enter your number"
        var count:Int = 0
        textView3.text = "Wrong Counter : $count"
        ButtonCheck.setOnClickListener {
            count = count + 1
            var number: Int = 0

            try {
                number = editText.text.toString().toInt()
            }
            catch (e: NumberFormatException){

            }
            if ((number <= 0) or (number > 1000)) {
                textView.text = "Please input 1-1000!"
                editText.text.clear()

            }  else if (number < random) {

                textView.text = "Wrong, too low!"
                editText.text.clear()
                textView3.text = "Wrong Counter : $count"
            }  else if (number > random) {

                textView.text = "Wrong, too high!"
                editText.text.clear()
                textView3.text = "Wrong Counter : $count"
            }  else {

                textView.text = "OK, It's right!!"
                editText.text.clear()
                textView3.text = "Wrong Counter : $count"
            }

        }

        ButtonReset.setOnClickListener {
            reset()
            var count:Int = 0
            textView3.text = "Wrong Counter : $count"
        }

    }

    fun reset() {
        random = nextInt(1, 1000)
        textView.text = "Enter your number"
        editText.text.clear()

    }
}