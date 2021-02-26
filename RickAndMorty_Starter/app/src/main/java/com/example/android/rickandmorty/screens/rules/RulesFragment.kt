package com.example.android.rickandmorty.screens.rules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.rickandmorty.R
import com.example.android.rickandmorty.databinding.RulesFragmentBinding
import com.example.android.rickandmorty.databinding.ScoreFragmentBinding
import com.example.android.rickandmorty.databinding.TitleFragmentBinding
import com.example.android.rickandmorty.screens.title.TitleFragmentDirections


class RulesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: RulesFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.rules_fragment,
                container,
                false
        )

        return binding.root
    }
}
