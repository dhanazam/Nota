package com.dhanazam.nota.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dhanazam.nota.R
import com.dhanazam.nota.databinding.FragmentCreateNoteBinding
import com.dhanazam.nota.model.NotesEntity
import com.dhanazam.nota.utils.CalendarUtil
import com.dhanazam.nota.utils.KeyboardUtil
import com.dhanazam.nota.viewmodel.MainViewModel


class CreateNoteFragment : Fragment() {
    private lateinit var binding: FragmentCreateNoteBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCreateNoteBinding.inflate(layoutInflater, container, false)

        binding.toolbarCreateNote.setOnMenuItemClickListener {
            when (it.itemId) {

                //Confirm Button
                R.id.create_note_toolbar_options_confirm -> {
                    saveNewNote()
                    true
                }

                else -> { true}
            }
        }

        //Navigation Button(back button)
        binding.toolbarCreateNote.setNavigationOnClickListener{
            findNavController().popBackStack()
        }

        binding.textViewDateAndTime.text = getString(R.string.label_textView_dateAndTime, CalendarUtil.getCurrentDay(), CalendarUtil.getCurrentTime() )

        return binding.root
    }


    private fun saveNewNote() {
        if(binding.editTextContent.text.toString().isEmpty()) {
            Toast.makeText(activity, "Note content is empty", Toast.LENGTH_SHORT).show()

        } else {
            val title = binding.editTextHeading.text.toString()
            val content = binding.editTextContent.text.toString()
            val lastEditedDate = CalendarUtil.getCurrentDate()
            val lastEditedDay = CalendarUtil.getCurrentDay()
            val lastEditedTime = CalendarUtil.getCurrentTime()
            val lastEditedMonth = CalendarUtil.getCurrentMonth()
            val data = NotesEntity(null, title, content, lastEditedDate, lastEditedDay, lastEditedTime, lastEditedMonth)
            mainViewModel.insertNotes(data)
            findNavController().popBackStack()
        }
    }

    override fun onStart() {
        super.onStart()
        KeyboardUtil.showSoftKeyboard(binding.editTextHeading)
    }

}