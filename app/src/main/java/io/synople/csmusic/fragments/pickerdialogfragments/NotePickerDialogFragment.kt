package io.synople.csmusic.fragments.pickerdialogfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import io.synople.csmusic.R
import io.synople.csmusic.model.NoteBlock
import kotlinx.android.synthetic.main.dialog_fragment_note_picker.*


class NotePickerDialogFragment : DialogFragment() {

    private lateinit var onFinish: (NoteBlock) -> Unit

    fun show(fm: FragmentManager, onFinish: (NoteBlock) -> Unit) {
        this.onFinish = onFinish
        show(fm, "NotePickerDialogFragment")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.dialog_fragment_note_picker, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvKeyValue.text = "C"
        tvNoteValue.text = "C"
        tvOctaveValue.text = "3"
        tvLengthValue.text = "q"

        tvKeyPlus.setOnClickListener {

        }
        tvKeyMinus.setOnClickListener {

        }

        tvNotePlus.setOnClickListener {

        }
        tvNoteMinus.setOnClickListener {

        }

        tvOctavePlus.setOnClickListener {

        }
        tvOctaveMinus.setOnClickListener {

        }

        tvLengthPlus.setOnClickListener {

        }
        tvLengthMinus.setOnClickListener {

        }

        btnAdd.setOnClickListener {
            onFinish(
                NoteBlock(
                    tvKeyValue.text.toString().toInt(),
                    tvNoteValue.text.toString().toInt(),
                    tvOctaveValue.text.toString().toInt(),
                    tvLengthValue.text.toString().toInt()
                )
            )
            dismiss()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = NotePickerDialogFragment()
    }
}
