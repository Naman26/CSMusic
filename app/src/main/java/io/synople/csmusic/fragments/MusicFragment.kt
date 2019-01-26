package io.synople.csmusic.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import io.synople.csmusic.R
import kotlinx.android.synthetic.main.fragment_music.*


class MusicFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_music, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playAudio.setOnClickListener {

            Toast.makeText(context, "Hello World", Toast.LENGTH_LONG).show()
            play()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MusicFragment()
    }

    fun play() {


        val mpintro = MediaPlayer.create(context, R.raw.c3i)
        mpintro.isLooping = false
        mpintro.start()


//        val f = File("/Users/harnoor/Downloads/pianonotes/c3i.wav")
//
//        val myUri: Uri = Uri.fromFile(f) // initialize Uri here
//        val mediaPlayer: MediaPlayer? = MediaPlayer().apply {
////            setAudioStreamType(AudioManager.STREAM_MUSIC)
//            setAudioStreamType(AudioManager.STREAM_MUSIC)
//            var attributes = newInstance().set
//            setAudioAttributes(Attributes())
//            prepare()
//            start()
//        }
    }
}
