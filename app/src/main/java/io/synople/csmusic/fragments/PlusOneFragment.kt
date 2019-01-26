package io.synople.csmusic.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_plus_one.*


class PlusOneFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(io.synople.csmusic.R.layout.fragment_plus_one, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSocial.setOnClickListener { display() }
    }

    fun display(){
        val pioneersFragment = SocialDialogFragment()
        fragmentManager?.let { pioneersFragment.show(it,"PioneersFragment_tag") }

    }
    companion object {
        @JvmStatic
        fun newInstance() = PlusOneFragment()
    }
}