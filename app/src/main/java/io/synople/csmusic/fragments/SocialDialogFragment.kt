package io.synople.csmusic.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import io.synople.csmusic.R
import io.synople.csmusic.adapters.ProfileViewAdapter
import kotlinx.android.synthetic.main.fragment_social_dialog.*


class SocialDialogFragment : DialogFragment() {

    private lateinit var profileList: MutableList<Profile>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_social_dialog, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileList = mutableListOf()
        prepareData()

        val adapter = ProfileViewAdapter(profileList)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        Toast.makeText(context, "Hello World", Toast.LENGTH_LONG).show()

    }

    fun prepareData() {
        var item = Profile("Harnoor")
        profileList.add(item)
        item = Profile("Jason")
        profileList.add(item)
        item = Profile("Carl")
        profileList.add(item)
        item = Profile("Naman")
        profileList.add(item)
    }


    companion object {
        @JvmStatic
        fun newInstance() = PlusOneFragment()
    }
}

data class Profile(var studentName: String)