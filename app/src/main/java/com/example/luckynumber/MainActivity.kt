package com.example.luckynumber

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
        val userName : EditText = findViewById(R.id.name)
        val button : Button = findViewById(R.id.btn1)

        button.setOnClickListener {
            val userName = userName.text.toString()
            if (userName.isNotEmpty()) {
                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("USER_NAME", userName)
                }
                startActivity(intent)
            }
        }
    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_layout, menu)
//        return true
//    }
}