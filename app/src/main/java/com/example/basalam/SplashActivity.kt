package com.example.basalam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.basalam.dao.UserDao
import com.example.basalam.database.AppDatabase

class SplashActivity : AppCompatActivity() {

    var context = this
    lateinit var db: AppDatabase
    lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        db = AppDatabase.getAppDatabase(context)
        // Get userDao
        userDao = db.getUserDao()

        object : CountDownTimer(3000, 3000) {
            override fun onTick(millisUntilFinished: Long) {
                // Noting to do
            }

            override fun onFinish() {
                if (userDao.get() == null) {
                    startActivity(Intent(context, SignUpActivity::class.java))
                    finish()
                } else {
                    startActivity(Intent(context, MainActivity::class.java))
                    finish()
                }
            }

        }.start()


    }
}