/*
Alena Selezneva
Rick and Morty Quiz Assignment
 */

package com.example.android.rickandmorty.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.rickandmorty.R

data class Question(
        val questionID: Int,
        val answer: Boolean,
        var attempted:Boolean = false,
        var answered: Boolean = false
)

class GameViewModel : ViewModel() {
    private val _question = MutableLiveData<Question>()
    val question: LiveData<Question>
        get() = _question

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    private lateinit var questionBank: MutableList<Question>

    private var currentQuestionIndex:Int = 0;
    private var questionsAnswered: Int = 0;

    private fun initializeList() {
        questionBank = mutableListOf(
                Question(R.string.question_1, false),
                Question(R.string.question_2, true),
                Question(R.string.question_3, true),
                Question(R.string.question_4, false),
                Question(R.string.question_5, false),
                Question(R.string.question_6, true),
                Question(R.string.question_7, false),
                Question(R.string.question_8, true),
                Question(R.string.question_9, false),
                Question(R.string.question_10, false),
                Question(R.string.question_11, false),
                Question(R.string.question_12, true),
                Question(R.string.question_13, false),
                Question(R.string.question_14, true),
                Question(R.string.question_15, false),
                Question(R.string.question_16, false),
                Question(R.string.question_17, true),
                Question(R.string.question_18, false),
                Question(R.string.question_19, false),
                Question(R.string.question_20, true)
        )
        questionBank.shuffle()
    }

    init {
        currentQuestionIndex = 0;
        questionsAnswered = 0;
        _score.value = 0
        initializeList()

        updateCurrentQuestion()

        Log.i("GameViewModel", "GameViewModel created!")
    }

    public fun onNext() {
        currentQuestionIndex += 1;
        if (currentQuestionIndex >= questionBank.size)
            currentQuestionIndex = 0;
        updateCurrentQuestion()
    }

    public fun onPrevious() {
        currentQuestionIndex -= 1;
        if (currentQuestionIndex < 0)
            currentQuestionIndex = questionBank.size - 1;
        updateCurrentQuestion()
    }

    public fun onAnswer( ans:Boolean){
        if (_question.value?.answer == ans)
            onCorrect()
        else
            onWrong()

        questionsAnswered++;
        updateCurrentQuestion()

        if (questionsAnswered >= questionBank.size)
            onGameFinish()
    }

    public fun onCorrect() {
        _score.value = (score.value)?.plus(1)
        questionBank[currentQuestionIndex].attempted=true
        questionBank[currentQuestionIndex].answered=true
    }

    public fun onWrong() {
        questionBank[currentQuestionIndex].attempted=true
        questionBank[currentQuestionIndex].answered=false
    }

    private fun updateCurrentQuestion(){
        _question.value = questionBank[currentQuestionIndex];
    }

    fun onGameFinish() {
        _eventGameFinish.value = true
    }

    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }

    fun getNumberOfQuestions():Int{
        return questionBank.size;
    }
}