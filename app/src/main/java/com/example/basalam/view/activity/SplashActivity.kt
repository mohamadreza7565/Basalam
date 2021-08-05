package com.example.basalam.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.basalam.R
import com.example.basalam.room.ProductsDao
import com.example.basalam.room.AppDatabase

class SplashActivity : AppCompatActivity() {

    var context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        object : CountDownTimer(3000, 3000) {
            override fun onTick(millisUntilFinished: Long) {
                // Noting to do
            }

            override fun onFinish() {
                startActivity(Intent(context, MainActivity::class.java))
                finish()
            }

        }.start()


    }
}