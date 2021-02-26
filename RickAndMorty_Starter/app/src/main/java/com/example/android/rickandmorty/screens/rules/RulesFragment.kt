package com.example.android.rickandmorty.screens.rules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.rickandmorty.R
import com.example.android.rickandmorty.databinding.ScoreFragmentBinding
import com.example.android.rickandmorty.screens.score.ScoreFragmentArgs
import com.example.android.rickandmorty.screens.score.ScoreViewModel
import com.example.android.rickandmorty.screens.score.ScoreViewModelFactory

class RulesFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        Toast.makeText(activity, "Rules onCreateView", Toast.LENGTH_SHORT).show()

        // Inflate view and obtain an instance of the binding class.
        val binding: ScoreFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.rules_fragment,
                container,
                false
        )

        return binding.root
    }

}
