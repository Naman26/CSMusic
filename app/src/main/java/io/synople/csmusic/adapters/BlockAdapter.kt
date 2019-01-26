package io.synople.csmusic.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.synople.csmusic.R
import io.synople.csmusic.model.Block
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.block_note.*

class BlockAdapter(val blocks: List<Block>, private val itemClick: (Block) -> Unit) :
    RecyclerView.Adapter<BlockAdapter.ViewHolder>() {

    class ViewHolder(override val containerView: View, private val itemClick: (Block) -> Unit) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindNote(block: Block) {
            tvBlockNote.text = block.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.block_note, parent, false), itemClick)
    }

    override fun onBindViewHolder(holder: BlockAdapter.ViewHolder, position: Int) {
        holder.bindNote(blocks[position])
    }

    override fun getItemCount() = blocks.size
}