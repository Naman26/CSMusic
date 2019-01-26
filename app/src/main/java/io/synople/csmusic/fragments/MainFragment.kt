package io.synople.csmusic.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.math.Quaternion
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.rendering.ViewRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

import io.synople.csmusic.R
import io.synople.csmusic.adapters.BlockAdapter
import io.synople.csmusic.utilities.Note
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var arFragment: ArFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_main, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
                    val notes = mutableListOf<Note>()
                    notes.add(Note())
                    val adapter = BlockAdapter(notes) {

                    }
                    rvBlocks?.adapter = adapter
                    rvBlocks?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

                    renderable?.view?.findViewById<Button>(R.id.btnAddNote)?.setOnClickListener {
                        // TODO: Add another block
                        notes.add(Note())
                        adapter.notifyDataSetChanged()
                    }
                }
        }

        btnPlay.setOnClickListener {
            // TODO: Harnoor
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
