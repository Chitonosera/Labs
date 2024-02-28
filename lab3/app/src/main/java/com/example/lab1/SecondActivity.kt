package com.example.lab1

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class SecondActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val inputEditText = findViewById<EditText>(R.id.inputText)
        val btnText: Button = findViewById(R.id.enter)



        btnText.setOnClickListener {
            val inputText = inputEditText.text.toString().trim()
            if (inputText.equals("calc", ignoreCase = true)) {
                val intent = Intent(this, CalculatorActivity::class.java)
                startActivity(intent)

            }
            else{
                showAlertDialog()
            }
        }

    } private fun showAlertDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Помилка")
        alertDialogBuilder.setMessage("Введені дані некоректні. Будь ласка, введіть слово 'calc'.")
        alertDialogBuilder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}