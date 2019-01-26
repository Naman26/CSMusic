package io.synople.csmusic.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.synople.csmusic.R
import io.synople.csmusic.fragments.Profile
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.profile_display.*

class ProfileViewAdapter(val studentList: List<Profile>) : RecyclerView.Adapter<ProfileViewAdapter.ViewHolder>() {

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItems(item: Profile) {
            tvName.text = item.studentName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.profile_display, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(studentList[position])
    }

    override fun getItemCount() = studentList.size
}