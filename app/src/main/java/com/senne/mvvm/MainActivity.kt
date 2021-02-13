package com.senne.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val title: TextView = findViewById(R.id.title)
        val btn: Button = findViewById(R.id.btn)
        viewModel.textTitle.observe(this, Observer {
            title.text = it
        })

        viewModel.login.observe(this, Observer {
            if(it) {
                Toast.makeText(this, viewModel.textTitle.value, Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this, "Falha", Toast.LENGTH_LONG).show()
            }
        })

        btn.setOnClickListener {
            val edit : EditText = findViewById(R.id.edit)
            val login = edit.text.toString()
            viewModel.login(login)
        }

    }


}