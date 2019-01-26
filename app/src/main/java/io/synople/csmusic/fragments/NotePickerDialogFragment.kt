package io.synople.csmusic.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import io.synople.csmusic.R
import kotlinx.android.synthetic.main.fragment_note_picker_dialog.*


class NotePickerDialogFragment : DialogFragment() {

    private lateinit var onFinish: (String) -> Unit

    private lateinit var data: String

    fun show(fm: FragmentManager, tag: String, data: String, onFinish: (String) -> Unit) {
        this.onFinish = onFinish
        this.data = data
        show(fm, tag)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_note_picker_dialog, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvNote.text = data

        btnAdd.setOnClickListener {
            data += "world"
            tvNote.text = data
            Thread.sleep(1000)
            onFinish(data)
            dismiss()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = NotePickerDialogFragment()
    }
}
