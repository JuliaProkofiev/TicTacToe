package com.tictactoe.app

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.TextView

class WinnerActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)

        val winnerText = findViewById<TextView>(R.id.winnerText)
        val player1Points = findViewById<TextView>(R.id.player1Points)
        val player2Points = findViewById<TextView>(R.id.player2Points)

        val vencedor = intent.getStringExtra("winner") ?: "Desconhecido"
        winnerText.text = "Parabéns, $vencedor!"

        // SharedPreferences para carregar os pontos salvos
        val prefs = getSharedPreferences("PlacarPrefs", Context.MODE_PRIVATE)
        val pontosP1 = prefs.getInt("player1", 0)
        val pontosP2 = prefs.getInt("player2", 0)

        player1Points.text = "Player 1: $pontosP1 PTS"
        player2Points.text = "Player 2: $pontosP2 PTS"
    }
}
