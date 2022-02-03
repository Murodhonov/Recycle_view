package com.example.recycleview

import Models.User
import Utils.MyData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_main.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        var pos = intent.getIntExtra("key",-1)

        nameEdt.setText(MyData.arrayList[pos].name)
        nameNumber.setText(MyData.arrayList[pos].number)

        btn_saver.setOnClickListener {
            val name = nameEdt.text.toString()
            val number = nameNumber.text.toString()

            val user = User(name,number)
            MyData.arrayList[pos] = user
            Toast.makeText(this, "changed", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}