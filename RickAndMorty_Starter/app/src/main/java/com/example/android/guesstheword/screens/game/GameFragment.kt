package com.example.android.guesstheword.screens.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.GameFragmentBinding
import androidx.navigation.fragment.NavHostFragment.findNavController

/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {
    private lateinit var viewModel: GameViewModel

    private lateinit var binding: GameFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.game_fragment,
                container,
                false
        )

        Log.i("GameFragment", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        binding.gameViewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        /** Setting up LiveData observation relationship **/
//        viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
//            binding.scoreText.text = newScore.toString()
//        })

//        viewModel.word.observe(viewLifecycleOwner, Observer { newWord ->
//            binding.wordText.text = newWord
//        })

        // Observer for the Game finished event
        viewModel.eventGameFinish.observe(viewLifecycleOwner, Observer<Boolean> { hasFinished ->
            if (hasFinished) gameFinished()
        })

//        binding.correctButton.setOnClickListener { onCorrect() }
//        binding.skipButton.setOnClickListener { onSkip() }
//        binding.endGameButton.setOnClickListener { onEndGame() }

        return binding.root

    }


    /** Methods for button click handlers **/

//    private fun onSkip() {
//        viewModel.onSkip()
//    }
//    private fun onCorrect() {
//        viewModel.onCorrect()
//    }
//    private fun onEndGame() {
//        gameFinished()
//    }


    private fun gameFinished() {
        Toast.makeText(activity, "Game has just finished", Toast.LENGTH_SHORT).show()
        val action = GameFragmentDirections.actionGameToScore()
        action.score = viewModel.score.value?:0
        findNavController(this).navigate(action)
        viewModel.onGameFinishComplete()
    }
}