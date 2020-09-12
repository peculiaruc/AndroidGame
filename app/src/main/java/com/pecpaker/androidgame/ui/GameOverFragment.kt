package com.pecpaker.androidgame.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.pecpaker.androidgame.R
import com.pecpaker.androidgame.databinding.ActivityMainBinding.inflate
import com.pecpaker.androidgame.databinding.FragmentGameOverBinding

/**
 * A simple [Fragment] subclass.
 * Use the [GameOverFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameOverFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_game_over, container, false)

        binding.tryAgainButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(GameOverFragmentDirections.actionGameOverFragment2ToGameFragment())
        }
        return binding.root
    }


}