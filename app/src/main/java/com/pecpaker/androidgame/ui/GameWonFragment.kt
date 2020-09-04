package com.pecpaker.androidgame.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.pecpaker.androidgame.R
import com.pecpaker.androidgame.databinding.FragmentGamewonBinding


/**
 * A simple [Fragment] subclass.
 * Use the [GamewonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GamewonFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGamewonBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_gamewon, container, false)
        binding.youWinImage.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_gamewonFragment_to_gameFragment)
        }
        return binding.root
    }


}