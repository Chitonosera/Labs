package com.example.lab1

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged

class SecondActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seclay)
        val countDownText: TextView = findViewById(R.id.textView2)
        val countEditText: EditText = findViewById(R.id.inputText)
        val btnText: Button = findViewById(R.id.button)
        val btnText2: Button = findViewById(R.id.button2)
        val btnText3: Button = findViewById(R.id.button3)
        val btnText4: Button = findViewById(R.id.button4)

        btnText.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                countEditText.setText("${countEditText.text}1")
            }
        })

        btnText2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                countEditText.setText("${countEditText.text}2")
            }
        })

        btnText3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                countEditText.setText("${countEditText.text}3")
            }
        })

        btnText4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                countEditText.setText("${countEditText.text}4")
            }
        })

        // Створюємо об'єкт CountDownTimer і задаємо час в мілісекундах
        val countDownTimer = object : CountDownTimer(4000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Викликається при кожному тіку таймера
                val secondsRemaining = millisUntilFinished / 1000
                countDownText.text = secondsRemaining.toString()
            }
            override fun onFinish() {
                // Викликається після завершення таймера
                countDownText.text = "Мирного рішення не буде!"
            }
        }
        // Запускаємо таймер
        countDownTimer.start()

        countEditText.doOnTextChanged { text, start, before, count ->
            countDownText.text=text
        }
    }
}