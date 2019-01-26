package io.synople.csmusic.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ViewRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import io.synople.csmusic.MusicCompiler
import io.synople.csmusic.MusicPlayer

import io.synople.csmusic.R
import io.synople.csmusic.adapters.BlockAdapter
import io.synople.csmusic.model.Block
import io.synople.csmusic.model.ForBlock
import io.synople.csmusic.model.IfBlock
import io.synople.csmusic.model.NoteBlock
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var arFragment: ArFragment
    private lateinit var adapters: MutableList<BlockAdapter>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_main, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapters = mutableListOf()

        arFragment = (childFragmentManager.findFragmentById(R.id.uxFragment) as ArFragment)
        arFragment.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            val anchor = hitResult.createAnchor()
            val anchorNode = AnchorNode(anchor)
            anchorNode.setParent(arFragment.arSceneView.scene)

            ViewRenderable.builder()
                .setView(context, R.layout.renderable_block)
                .build()
                .thenAccept { renderable ->


                    val transformableNode = TransformableNode(arFragment.transformationSystem)
                    transformableNode.setParent(anchorNode)
                    transformableNode.renderable = renderable

                    val rvBlocks = renderable?.view?.findViewById<RecyclerView>(R.id.rvBlocks)
                    val notes = mutableListOf<Block>()
                    notes.add(NoteBlock())
                    val adapter = BlockAdapter(notes) {
                        print(it.toString())
                    }
                    adapters.add(adapter)
                    rvBlocks?.adapter = adapter
                    rvBlocks?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

                    renderable?.view?.findViewById<Button>(R.id.btnAddNote)?.setOnClickListener {
                        notes.add(NoteBlock())
                        adapter.notifyDataSetChanged()
                    }

                    renderable?.view?.findViewById<Button>(R.id.btnAddFor)?.setOnClickListener {
                        notes.add(ForBlock())
                        adapter.notifyDataSetChanged()
                    }
                    renderable?.view?.findViewById<Button>(R.id.btnAddIf)?.setOnClickListener {
                        notes.add(IfBlock())
                        adapter.notifyDataSetChanged()
                    }
                }
        }

        ivPlay.setOnClickListener {
            val musicPlayer = MusicPlayer(context!!)
            val p = MusicCompiler(adapters[0].blocks).compile()
            musicPlayer.play(p)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
