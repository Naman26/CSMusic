package io.synople.csmusic.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import io.synople.csmusic.MusicPlayer

import io.synople.csmusic.R
import io.synople.csmusic.fragments.pickerdialogfragments.NotePickerDialogFragment
import io.synople.csmusic.model.NoteBlock
import kotlinx.android.synthetic.main.dialog_fragment_note_picker.*
import kotlinx.android.synthetic.main.fragment_music.*
import java.util.*


class MusicFragment : Fragment() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_music, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fm = fragmentManager
        val notePickerDialog = NotePickerDialogFragment()

        notePickerDialog.show(fm!!) {

        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = MusicFragment()
    }
}