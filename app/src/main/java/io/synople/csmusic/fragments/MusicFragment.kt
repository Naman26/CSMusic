package io.synople.csmusic.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.synople.csmusic.R
import io.synople.csmusic.fragments.pickerdialogfragments.ForPickerDialogFragment
import io.synople.csmusic.fragments.pickerdialogfragments.IfPickerDialogFragment


class MusicFragment : Fragment() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_music, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val fm = fragmentManager
//        val ifPickerDialogFragment = IfPickerDialogFragment()
//
//        ifPickerDialogFragment.show(fm!!) {
//
//        }

        val fm = fragmentManager
        val ifPickerDialogFragment = ForPickerDialogFragment()

        ifPickerDialogFragment.show(fm!!) {

        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = MusicFragment()
    }
}