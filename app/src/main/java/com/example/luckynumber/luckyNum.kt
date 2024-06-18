package com.example.luckynumber

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random as Random

class SecondActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_num)

        val userName = intent.getStringExtra("USER_NAME")
        val tvWelcome : TextView = findViewById(R.id.tvWelcome)
        val welcome : TextView = findViewById(R.id.welcome)
        val tvrandomNumber : TextView = findViewById(R.id.tvRandomNumber)
        val sharebtn : Button = findViewById(R.id.sharebtn)

        //Display the Lucky Number
        var random_number = generateRandomNum()
        welcome.setText("Congrats, $userName 🎉")
        tvWelcome.setText("Your Lucky Number is:")
        tvrandomNumber.setText("$random_number")

        sharebtn.setOnClickListener{
            shareData(userName.toString(), random_number)
        }
    }

    //Random number generator
    fun generateRandomNum(): Int {
        val random = Random.nextInt(1000)
        return random
    }

    //Sharing the Username & Lucky Number
    fun shareData(userName: String, random_number: Int){

        //Implicit Intent here
        var i = Intent(Intent.ACTION_SEND).apply {
            setType("text/plain")
            putExtra(Intent.EXTRA_SUBJECT, "$userName is lucky today!")
            putExtra(Intent.EXTRA_TEXT, "Their Lucky number is $random_number")
        }
        startActivity(Intent.createChooser(i, "Share your Luck via"))
    }
}