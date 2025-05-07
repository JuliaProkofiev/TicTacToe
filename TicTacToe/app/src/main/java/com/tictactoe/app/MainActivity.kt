package com.tictactoe.app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnComAmigos = findViewById<Button>(R.id.btnComAmigos)

        btnComAmigos.setOnClickListener {
            val intent = Intent(this, JogoActivity::class.java)
            startActivity(intent)
        }
    }
}


