package com.pecpaker.androidgame.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.app.Person.fromBundle
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.pecpaker.androidgame.R
import com.pecpaker.androidgame.databinding.FragmentGamewonBinding

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
            R.layout.fragment_gamewon, container, false
        )
        binding.nextMatchButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(GamewonFragmentDirections.actionGamewonFragmentToGameFragment())
        }
//        val args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)
        //check if the intent resolve the activity
        if (null == getShareIntent()?.resolveActivity(requireActivity().packageManager)) {
            //hide the menu item
            menu.findItem(R.id.share).isVisible = false
        }
    }

    private fun getShareIntent(): Intent? {
        val args = arguments?.let { GamewonFragmentArgs.fromBundle(it) }
        return activity?.let {
            ShareCompat.IntentBuilder.from(it)
                .setText(
                    getString(
                        R.string.share_success_text,
                        args?.numCorrect,
                        args?.numQuestions
                    )
                )
                .setType("text/plain")
                .intent
        }
//        val shareIntent = Intent(Intent.ACTION_SEND)
//        if (args != null) {
//            shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text,
//                args.numCorrect, args.numQuestions))
//        }
//        return shareIntent
    }

    private fun shareSucceess() {
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSucceess()
        }
        return super.onOptionsItemSelected(item)
    }
}


