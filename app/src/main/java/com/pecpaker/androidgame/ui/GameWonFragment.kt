package com.pecpaker.androidgame.ui

import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.Person.fromBundle
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
            view.findNavController()
                .navigate(GamewonFragmentDirections.actionGamewonFragmentToGameFragment())
        }
//        val args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
        return binding.root
    }


}