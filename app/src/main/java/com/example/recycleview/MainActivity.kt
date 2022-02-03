package com.example.recycleview

import Adapter.UserAdapter
import Models.User
import Utils.MyData
import Utils.MyData.arrayList
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var userlist:ArrayList<User>
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        userAdapter = UserAdapter(object : UserAdapter.MyClick{
            override fun click(pos:Int) {
                startActivity(Intent(this@MainActivity,AboutActivity::class.java).putExtra("key",pos))
            }

            override fun delete(pos: Int) {
                arrayList.removeAt(pos)
                onStart()
            }
        },this, arrayList)

        recycleView.adapter = userAdapter


        btn_save.setOnClickListener {
            val name = edt_name.text.toString().trim()
            val number = edt_number.text.toString().trim()

            edt_name.text.clear()
            edt_number.text.clear()

            val user = User(name,number)
            arrayList.add(user)
            //userAdapter.notifyDataSetChanged()
            userAdapter.notifyItemInserted(arrayList.size)
        }



    }

    override fun onStart() {
        super.onStart()
        userAdapter.notifyDataSetChanged()
    }
}