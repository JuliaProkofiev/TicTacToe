package com.tictactoe.app

import android.content.Context

object SharedPrefsManager {
    private const val PREF_NAME = "TicTacToePrefs"
    private const val PLAYER1_SCORE_KEY = "player1_score"
    private const val PLAYER2_SCORE_KEY = "player2_score"

    fun saveScore(context: Context, player1Score: Int, player2Score: Int) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit().apply {
            putInt(PLAYER1_SCORE_KEY, player1Score)
            putInt(PLAYER2_SCORE_KEY, player2Score)
            apply()
        }
    }

    fun getScores(context: Context): Pair<Int, Int> {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val player1Score = prefs.getInt(PLAYER1_SCORE_KEY, 0)
        val player2Score = prefs.getInt(PLAYER2_SCORE_KEY, 0)
        return Pair(player1Score, player2Score)
    }
}