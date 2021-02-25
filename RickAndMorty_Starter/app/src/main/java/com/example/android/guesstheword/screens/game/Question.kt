package com.example.android.guesstheword.screens.game

data class Question(
        val questionID: Int,
        val answer: Boolean,
        var attempted:Boolean = false
)