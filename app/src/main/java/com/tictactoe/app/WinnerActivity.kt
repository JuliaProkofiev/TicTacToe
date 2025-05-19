package com.tictactoe.app

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView

class WinnerActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)

        val winner = intent.getStringExtra("WINNER") ?: "EMPATE"
        val winnerText = findViewById<TextView>(R.id.winnerText)
        val scoreText = findViewById<TextView>(R.id.scoreText)
        val winnerCircle = findViewById<View>(R.id.winnerCircle)
        val winnerIcon = findViewById<TextView>(R.id.winnerIcon)
        val player1Points = findViewById<TextView>(R.id.player1Points)
        val player2Points = findViewById<TextView>(R.id.player2Points)

        if (winner == "EMPATE") {
            winnerText.text = "EMPATE!"
            scoreText.text = "Ninguém venceu\nO jogo"
            winnerIcon.text = "Velha!"
            winnerCircle.setBackgroundResource(R.drawable.circle_gray)
        }  else if (winner == "Player 1") {
            winnerText.text = "Parabéns, $winner!"
            scoreText.text = "Você ganhou!\nO jogo"
            winnerIcon.text = "$winner"
            winnerCircle.setBackgroundResource(R.drawable.circle_red)
        } else if (winner == "Player 2") {
            winnerText.text = "Parabéns, $winner!"
            scoreText.text = "Você ganhou!\nO jogo"
            winnerIcon.text = "$winner"
            winnerCircle.setBackgroundResource(R.drawable.circle_blue)
        }

        // SharedPreferences para carregar os pontos salvos
        val prefs = getSharedPreferences("PlacarPrefs", Context.MODE_PRIVATE)
        val pontosP1 = prefs.getInt("player1", 0)
        val pontosP2 = prefs.getInt("player2", 0)

        player1Points.text = "Player 1: $pontosP1 PTS"
        player2Points.text = "Player 2: $pontosP2 PTS"
    }

    fun voltarParaInicio(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}
