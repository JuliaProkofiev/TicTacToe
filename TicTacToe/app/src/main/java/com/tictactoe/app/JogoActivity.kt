package com.tictactoe.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class JogoActivity : AppCompatActivity() {

    private lateinit var grid: GridLayout
    private lateinit var turnoText: TextView
    private var jogadorAtual = "X"
    private val tabuleiro = Array(3) { arrayOfNulls<TextView>(3) }
    private var jogadas = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        grid = findViewById(R.id.gameGrid)
        turnoText = findViewById(R.id.textTurno)

        for (linha in 0 until 3) {
            for (coluna in 0 until 3) {
                val cell = TextView(this)
                cell.setBackgroundResource(R.drawable.borda_preta)
                cell.gravity = Gravity.CENTER
                cell.textSize = 32f
                cell.setTextColor(ContextCompat.getColor(this, android.R.color.black))

                val params = GridLayout.LayoutParams()
                params.width = 200
                params.height = 200
                params.setMargins(4, 4, 4, 4)
                cell.layoutParams = params

                grid.addView(cell)
                tabuleiro[linha][coluna] = cell

                cell.setOnClickListener {
                    if (cell.text.isEmpty()) {
                        cell.text = jogadorAtual
                        jogadas++

                        if (verificarVitoria()) {
                            Toast.makeText(this, "Jogador $jogadorAtual venceu!", Toast.LENGTH_LONG).show()
                            desabilitarTabuleiro()
                        } else if (jogadas == 9) {
                            Toast.makeText(this, "Empate!", Toast.LENGTH_LONG).show()
                        } else {
                            jogadorAtual = if (jogadorAtual == "X") "O" else "X"
                            turnoText.text = "Turno: Jogador ${if (jogadorAtual == "X") "1 (X)" else "2 (O)"}"
                        }
                    }
                }
            }
        }
    }

    private fun verificarVitoria(): Boolean {
        for (i in 0..2) {
            if (tabuleiro[i][0]?.text == jogadorAtual &&
                tabuleiro[i][1]?.text == jogadorAtual &&
                tabuleiro[i][2]?.text == jogadorAtual
            ) return true

            if (tabuleiro[0][i]?.text == jogadorAtual &&
                tabuleiro[1][i]?.text == jogadorAtual &&
                tabuleiro[2][i]?.text == jogadorAtual
            ) return true
        }

        if (tabuleiro[0][0]?.text == jogadorAtual &&
            tabuleiro[1][1]?.text == jogadorAtual &&
            tabuleiro[2][2]?.text == jogadorAtual
        ) return true

        if (tabuleiro[0][2]?.text == jogadorAtual &&
            tabuleiro[1][1]?.text == jogadorAtual &&
            tabuleiro[2][0]?.text == jogadorAtual
        ) return true

        return false
    }

    private fun desabilitarTabuleiro() {
        for (linha in tabuleiro) {
            for (cell in linha) {
                cell?.isEnabled = false
            }
        }
    }
}
