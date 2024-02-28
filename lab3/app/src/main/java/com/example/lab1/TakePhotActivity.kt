package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.PackageManager
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.os.Environment
import java.io.File
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date
import androidx.core.content.ContextCompat
import android.Manifest.permission.CAMERA
import android.content.Context
import android.content.SharedPreferences
import androidx.core.app.ActivityCompat




class TakePhotActivity : AppCompatActivity() {
    private val preferences:SharedPreferences=this.getSharedPreferences("user", Context.MODE_PRIVATE)


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_phot)
        preferences.edit().putString("name","kolya").apply()
       textView.text=preferences.getString("name","noName")

    }
}