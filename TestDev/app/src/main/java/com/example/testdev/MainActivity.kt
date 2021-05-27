package com.example.testdev

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.*

import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.rv_item.*

import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var myAdapter: MyAdapter
    private lateinit var massageList: MutableList<MassageModel>
    private val time: String = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
    private val date: String = SimpleDateFormat("dd-MM-yy", Locale.getDefault()).format(Date())
    private var massage: String = "George: Hi"
    private val appName: String = "Facebook"
    private var userName: String=""
    private lateinit var callbackManager:CallbackManager
    lateinit var  loginButton:LoginButton


    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val accessToken = AccessToken.getCurrentAccessToken()


        loginButton=fc_login_btn
        callbackManager = CallbackManager.Factory.create()
       loginButton.registerCallback(callbackManager,
            object : FacebookCallback<LoginResult?> {
                override fun onSuccess(loginResult: LoginResult?) {

                }

                override fun onCancel() {
                    // App code
                }

                override fun onError(exception: FacebookException) {
                    Toast.makeText(this@MainActivity,"No internet connection ",Toast.LENGTH_LONG).show()
                }
            })






        myAdapter = MyAdapter(
            mutableListOf(MassageModel(
                R.drawable.ic_facbook,appName, massage, time, date,
            ))


        )
        btn_start_show_msg.setOnClickListener {
            imageView.visibility = View.INVISIBLE
            rv_all_msg.visibility = View.VISIBLE
            btn_start_show_msg.visibility = View.INVISIBLE
            btn_stop_massage.visibility = View.VISIBLE
            textView.visibility = View.INVISIBLE
        }
        btn_stop_massage.setOnClickListener {
            imageView.visibility = View.VISIBLE
            rv_all_msg.visibility = View.INVISIBLE
            btn_start_show_msg.visibility = View.VISIBLE
            btn_stop_massage.visibility = View.INVISIBLE
            textView.visibility = View.VISIBLE
        }


        rv_all_msg.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }


}





