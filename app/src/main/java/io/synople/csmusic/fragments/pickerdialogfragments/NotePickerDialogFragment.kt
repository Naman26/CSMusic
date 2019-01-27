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
            when (tvKeyValue.text) {
                "C" -> tvKeyValue.text = "D"
                "D" -> tvKeyValue.text = "G"
                "G" -> tvKeyValue.text = "C"
            }
        }
        tvKeyMinus.setOnClickListener {
            when (tvKeyValue.text) {
                "C" -> tvKeyValue.text = "G"
                "D" -> tvKeyValue.text = "C"
                "G" -> tvKeyValue.text = "D"
            }
        }

        tvNotePlus.setOnClickListener {
            when (tvKeyValue.text) {
                "C" -> {
                    var indexOf = NoteBlock.keyC.indexOf(tvKeyValue.text)
                    indexOf++
                    if (indexOf > NoteBlock.keyC.size) indexOf = 0

                    tvKeyValue.text = NoteBlock.keyC[indexOf]
                }
                "D" -> {
                    var indexOf = NoteBlock.keyD.indexOf(tvKeyValue.text)
                    indexOf++
                    if (indexOf > NoteBlock.keyD.size) indexOf = 0

                    tvKeyValue.text = NoteBlock.keyD[indexOf]
                }
                "G" -> {
                    var indexOf = NoteBlock.keyG.indexOf(tvKeyValue.text)
                    indexOf++
                    if (indexOf > NoteBlock.keyG.size) indexOf = 0

                    tvKeyValue.text = NoteBlock.keyG[indexOf]
                }
            }
        }
        tvNoteMinus.setOnClickListener {
            when (tvKeyValue.text) {
                "C" -> {
                    var indexOf = NoteBlock.keyC.indexOf(tvKeyValue.text)
                    indexOf--
                    if (indexOf > NoteBlock.keyC.size) indexOf = 0

                    tvKeyValue.text = NoteBlock.keyC[indexOf]
                }
                "D" -> {
                    var indexOf = NoteBlock.keyD.indexOf(tvKeyValue.text)
                    indexOf--
                    if (indexOf > NoteBlock.keyD.size) indexOf = 0

                    tvKeyValue.text = NoteBlock.keyD[indexOf]
                }
                "G" -> {
                    var indexOf = NoteBlock.keyG.indexOf(tvKeyValue.text)
                    indexOf--
                    if (indexOf > NoteBlock.keyG.size) indexOf = 0

                    tvKeyValue.text = NoteBlock.keyG[indexOf]
                }
            }
        }

        tvOctavePlus.setOnClickListener {
            var num = tvOctaveValue.text.toString().toInt()
            num++
            if (num > 5) tvOctaveValue.text = "3"
        }
        tvOctaveMinus.setOnClickListener {
            var num = tvOctaveValue.text.toString().toInt()
            num--
            if (num < 0) tvOctaveValue.text = "5"
        }

        tvLengthPlus.setOnClickListener {
            var indexOf = NoteBlock.countStrings.indexOf(tvLengthValue.text.toString())
            indexOf++
            if (indexOf >= NoteBlock.countStrings.size) indexOf = 0

            tvLengthValue.text = NoteBlock.countStrings[indexOf]
        }
        tvLengthMinus.setOnClickListener {
            var indexOf = NoteBlock.countStrings.indexOf(tvLengthValue.text.toString())
            indexOf--
            if (indexOf >= NoteBlock.countStrings.size) indexOf = NoteBlock.countStrings.size - 1

            tvLengthValue.text = NoteBlock.countStrings[indexOf]
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
