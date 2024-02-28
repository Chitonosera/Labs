package com.example.lab1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)
        val myImageView: ImageView = findViewById(R.id.imageView)
        val textV: TextView = findViewById((R.id.textView))
        val intent = Intent(this,SecondActivity::class.java)
        val message = "Нажміть на Порошенка"
        val duration = Toast.LENGTH_SHORT // або Toast.LENGTH_LONG
        val toast = Toast.makeText(applicationContext, message, duration)
        myImageView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                textV.setText("Рошен")
            }
        })
        textV.setOnClickListener {
            if (textV.text == "Рошен")
                startActivity(intent)
            else
                toast.show()
        }
    }

}