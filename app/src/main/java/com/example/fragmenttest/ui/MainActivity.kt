package com.example.fragmenttest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmenttest.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            val fragment = MainFragment()
            add(R.id.container, fragment)
            commit()
        }
    }
}