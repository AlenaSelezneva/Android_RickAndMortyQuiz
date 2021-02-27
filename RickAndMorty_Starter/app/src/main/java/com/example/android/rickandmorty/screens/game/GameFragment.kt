/*
Alena Selezneva
Rick and Morty Quiz Assignment
 */

package com.example.android.rickandmorty.screens.game

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
import com.example.android.rickandmorty.R
import com.example.android.rickandmorty.databinding.GameFragmentBinding
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.android.rickandmorty.screens.game.GameViewModel

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
        viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
            binding.scoreText.text = newScore.toString()
        })

        viewModel.question.observe(viewLifecycleOwner, Observer { newQuestion ->
            binding.questionText.text = context?.getText(newQuestion.questionID)

            if (newQuestion.attempted){
                binding.rightWrongImageView.visibility = View.VISIBLE;
                if (newQuestion.answered)
                    binding.rightWrongImageView.setImageResource(R.drawable.right_24)
                else
                    binding.rightWrongImageView.setImageResource(R.drawable.wrong_24)

                if (newQuestion.answer && newQuestion.answered || !newQuestion.answer && !newQuestion.answered){
                    binding.rbTrue.isChecked = true;
                    binding.rbFalse.isChecked = false;
                }else{
                    binding.rbFalse.isChecked = true;
                    binding.rbTrue.isChecked = false;
                }

            }else{
                binding.rbFalse.isChecked = false;
                binding.rbTrue.isChecked = false;

                binding.rightWrongImageView.visibility = View.GONE;
            }

        })


        // Observer for the Game finished event
        viewModel.eventGameFinish.observe(viewLifecycleOwner, Observer<Boolean> { hasFinished ->
            if (hasFinished) gameFinished()
        })

        return binding.root
    }


    private fun gameFinished() {
        //Toast.makeText(activity, "Game has just finished", Toast.LENGTH_SHORT).show()
        val action = GameFragmentDirections.actionGameToScore()
        action.score = viewModel.score.value?:0
        action.numberOfQuestions = viewModel.getNumberOfQuestions()?:0
        findNavController(this).navigate(action)
        viewModel.onGameFinishComplete()
    }
}
