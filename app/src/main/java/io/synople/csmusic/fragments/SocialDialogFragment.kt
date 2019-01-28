package io.synople.csmusic.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.synople.csmusic.MusicPlayer

import io.synople.csmusic.R
import io.synople.csmusic.adapters.ProfileViewAdapter
import io.synople.csmusic.model.NoteBlock
import io.synople.csmusic.model.Profile
import kotlinx.android.synthetic.main.fragment_social_dialog.*
import java.util.*


class SocialDialogFragment : DialogFragment() {

    private lateinit var onFinish: (Profile) -> Unit
    private lateinit var profileList: MutableList<Profile>

    public fun show(fm: FragmentManager, onFinish: (Profile) -> Unit) {
        this.onFinish = onFinish
        show(fm, "SocialDialogFragment")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_social_dialog, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileList = mutableListOf()
        prepareData()

        val adapter = ProfileViewAdapter(profileList, onPlayClick = {
            val player = MusicPlayer(context!!) {

            }
            player.play(it.music)
        }, onDownloadClick = {
            onFinish(it)
            dismiss()
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun prepareData() {
        var item = Profile(
            "Harnoor", Arrays.asList(
                Arrays.asList(NoteBlock(0, 4, 0, 0)),
                Arrays.asList(NoteBlock(0, 1, 1, 0)),
                Arrays.asList(NoteBlock(3, 0)),
                Arrays.asList(NoteBlock(0, 6, 1, 0)),
                Arrays.asList(NoteBlock(0, 5, 1, 0)),
                Arrays.asList(NoteBlock(3, 1)),
                Arrays.asList(NoteBlock(0, 6, 1, 0)),
                Arrays.asList(NoteBlock(0, 1, 1, 0)),
                Arrays.asList(NoteBlock(3, 2)),
                Arrays.asList(NoteBlock(0, 6, 1, 0)),
                Arrays.asList(NoteBlock(0, 1, 1, 0)),
                Arrays.asList(NoteBlock(3, 3))
            )
        )
        profileList.add(item)
        item = Profile(
            "Jason", Arrays.asList(
                Arrays.asList(NoteBlock(0, 4, 0, 0)),
                Arrays.asList(NoteBlock(0, 1, 1, 0)),
                Arrays.asList(NoteBlock(3, 0)),
                Arrays.asList(NoteBlock(0, 6, 1, 0)),
                Arrays.asList(NoteBlock(0, 5, 1, 0)),
                Arrays.asList(NoteBlock(3, 1)),
                Arrays.asList(NoteBlock(0, 6, 1, 0)),
                Arrays.asList(NoteBlock(0, 1, 1, 0)),
                Arrays.asList(NoteBlock(3, 2)),
                Arrays.asList(NoteBlock(0, 6, 1, 0)),
                Arrays.asList(NoteBlock(0, 1, 1, 0)),
                Arrays.asList(NoteBlock(3, 3))
            )
        )
        profileList.add(item)
        item = Profile(
            "Carl", Arrays.asList(
                Arrays.asList(NoteBlock(0, 4, 0, 0)),
                Arrays.asList(NoteBlock(0, 1, 1, 0)),
                Arrays.asList(NoteBlock(3, 0)),
                Arrays.asList(NoteBlock(0, 6, 1, 0)),
                Arrays.asList(NoteBlock(0, 5, 1, 0)),
                Arrays.asList(NoteBlock(3, 1)),
                Arrays.asList(NoteBlock(0, 6, 1, 0)),
                Arrays.asList(NoteBlock(0, 1, 1, 0)),
                Arrays.asList(NoteBlock(3, 2)),
                Arrays.asList(NoteBlock(0, 6, 1, 0)),
                Arrays.asList(NoteBlock(0, 1, 1, 0)),
                Arrays.asList(NoteBlock(3, 3))
            )
        )
        profileList.add(item)
        item = Profile(
            "Naman", Arrays.asList(
                Arrays.asList(NoteBlock(0, 4, 0, 0)),
                Arrays.asList(NoteBlock(0, 1, 1, 0)),
                Arrays.asList(NoteBlock(3, 0)),
                Arrays.asList(NoteBlock(0, 6, 1, 0)),
                Arrays.asList(NoteBlock(0, 5, 1, 0)),
                Arrays.asList(NoteBlock(3, 1)),
                Arrays.asList(NoteBlock(0, 6, 1, 0)),
                Arrays.asList(NoteBlock(0, 1, 1, 0)),
                Arrays.asList(NoteBlock(3, 2)),
                Arrays.asList(NoteBlock(0, 6, 1, 0)),
                Arrays.asList(NoteBlock(0, 1, 1, 0)),
                Arrays.asList(NoteBlock(3, 3))
            )
        )
        profileList.add(item)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SocialDialogFragment()
    }
}

