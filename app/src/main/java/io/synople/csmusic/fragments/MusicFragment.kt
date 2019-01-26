package io.synople.csmusic.fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.synople.csmusic.MainActivity
import io.synople.csmusic.MusicPlayer

import io.synople.csmusic.R
import io.synople.csmusic.model.Block
import io.synople.csmusic.model.IfBlock
import io.synople.csmusic.model.MethodBlock
import io.synople.csmusic.model.NoteBlock
import kotlinx.android.synthetic.main.fragment_music.*
import java.lang.Exception
import java.util.*


class MusicFragment : Fragment() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_music, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playAudio.setOnClickListener {
            val noteBlockList = Arrays.asList(
                NoteBlock(0, 4, 0, 0),
                NoteBlock(0, 1, 1, 0),
                NoteBlock(3,0),
                NoteBlock(0, 6, 1, 0),
                NoteBlock(0, 5, 1, 0),
                NoteBlock(3,1),
                NoteBlock(0, 6, 1, 0),
                NoteBlock(0, 1, 1, 0),
                NoteBlock(3,2),
                NoteBlock(0, 6, 1, 0),
                NoteBlock(0, 1, 1, 0),
                NoteBlock(3,3)
            )

            val player = MusicPlayer(context!!)
            player.play(noteBlockList)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MusicFragment()
    }
}