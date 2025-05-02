package com.tictactoe.app

import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity

class JogoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle ?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        val grid = findViewById<GridLayout>(R.id.gameGrid)

        for (i in 0 until 9) {
            val cell = View(this)
            cell.setBackgroundResource(R.drawable.borda_preta)

            val params = GridLayout.LayoutParams()
            params.width = 100
            params.height = 100
            params.setMargins(4, 4, 4, 4)

            cell.layoutParams = params
            grid.addView(cell)
        }
    }
}
