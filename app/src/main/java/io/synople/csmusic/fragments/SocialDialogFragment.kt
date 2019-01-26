package io.synople.csmusic.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView

import io.synople.csmusic.R
import kotlinx.android.synthetic.main.fragment_social_dialog.*

class PioneersFragment : DialogFragment()
class SocialDialogFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_social_dialog, container, false)!!
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//    val rootView = inflater.inflate(R.layout.fragment_social_dialog, container)
//    var students= arrayOf("Carl", "Jason","Harnoor","Naman")
//    val myListView = rootView.findViewById(R.id.rvBlocks) as RecyclerView

//    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context, "Hello World", Toast.LENGTH_LONG).show()
//        btnSocial.setOnClickListener { display() }
    }

    fun display(){

    }
    companion object {
        @JvmStatic
        fun newInstance() = PlusOneFragment()
    }
}
