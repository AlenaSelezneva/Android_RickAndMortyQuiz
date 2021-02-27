/*
Alena Selezneva
Rick and Morty Quiz Assignment
 */

package com.example.android.rickandmorty.screens.rules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.android.rickandmorty.R
import com.example.android.rickandmorty.databinding.RulesFragmentBinding


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
