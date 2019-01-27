package io.synople.csmusic.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.synople.csmusic.R
import io.synople.csmusic.model.*
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.block_note.*
import kotlinx.android.synthetic.main.block_for.*
import kotlinx.android.synthetic.main.block_if.*
import kotlinx.android.synthetic.main.block_method.*

private const val FOR_BLOCK = 0
private const val IF_BLOCK = 1
private const val METHOD_BLOCK = 2
private const val NOTE_BLOCK = 3

class BlockAdapter(val blocks: List<Block>, private val itemClick: (Block) -> Unit) :
    RecyclerView.Adapter<BlockAdapter.ViewHolder>() {

    class ViewHolder(override val containerView: View, private val itemClick: (Block) -> Unit) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindNote(noteBlock: NoteBlock) {
            tvBlockNote.text = noteBlock.fileName
        }

        fun bindFor(forBlock: ForBlock) {
            btnLoops.text = "x" + forBlock.loops
            btnLoops.setOnClickListener {
                // TODO: Show dialog that lets users change loop count
            }

            val adapter = NoteBlockAdapter(forBlock.noteBlocks[0]) {}
            rvForBlocks.adapter = adapter
            rvForBlocks.layoutManager =
                LinearLayoutManager(containerView.context, LinearLayoutManager.HORIZONTAL, false)

            btnForBlockAdd.setOnClickListener {
                // TODO: Show dialog that adds a note block to forBlock
            }
        }

        fun bindIf(ifBlock: IfBlock) {

        }

        fun bindMethod(methodBlock: MethodBlock) {
            tvBlockMethod.text = "M${methodBlock.methodNum}"
        }
    }

    override fun getItemViewType(position: Int) =
        when {
            blocks[position] is ForBlock -> FOR_BLOCK
            blocks[position] is IfBlock -> IF_BLOCK
            blocks[position] is MethodBlock -> METHOD_BLOCK
            blocks[position] is NoteBlock -> NOTE_BLOCK
            else -> super.getItemViewType(position)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                when (viewType) {
                    FOR_BLOCK -> R.layout.block_for
                    IF_BLOCK -> R.layout.block_if
                    METHOD_BLOCK -> R.layout.block_method
                    else -> R.layout.block_note
                },
                parent, false
            ), itemClick
        )
    }

    override fun onBindViewHolder(holder: BlockAdapter.ViewHolder, position: Int) {
        val block = blocks[position]

        with(holder) {
            when (getItemViewType(position)) {
                FOR_BLOCK -> bindFor(block as ForBlock)
                IF_BLOCK -> bindIf(block as IfBlock)
                METHOD_BLOCK -> bindMethod(block as MethodBlock)
                NOTE_BLOCK -> bindNote(block as NoteBlock)
            }
        }
    }

    override fun getItemCount() = blocks.size
}