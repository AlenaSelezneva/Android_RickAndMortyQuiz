package com.example.android.rickandmorty.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int, numberOfQuestions: Int) : ViewModel() {
    // The final score
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _numberOfQuestions = MutableLiveData<Int>()
    val numberOfQuestions: LiveData<Int>
        get() = _numberOfQuestions

    init {
        Log.i("ScoreViewModel", "Final score is $finalScore")
        _score.value = finalScore
        _numberOfQuestions.value = numberOfQuestions
    }

}