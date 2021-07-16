package com.example.basalam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.basalam.dao.UserDao
import com.example.basalam.database.AppDatabase
import com.example.basalam.model.User
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    lateinit var db : AppDatabase
    lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        db = AppDatabase.getAppDatabase(this)
        userDao = db.getUserDao()

        btn_submit.setOnClickListener {
            if (et_name.text.toString().isEmpty()){
                Toast.makeText(this,"نام خود را وارد کنید",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (et_family.text.toString().isEmpty()){
                Toast.makeText(this,"نام خانوادگی خود را وارد کنید",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var user = User()
            user.firstName = et_name.text.toString()
            user.lastName = et_family.text.toString()
            userDao.insert(user)

            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}