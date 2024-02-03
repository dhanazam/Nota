package com.dhanazam.nota.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dhanazam.nota.R
import com.dhanazam.nota.databinding.FragmentViewNoteBinding
import com.dhanazam.nota.view.custom.NotaAlertDialog
import com.dhanazam.nota.viewmodel.MainViewModel

class ViewNoteFragment : Fragment() {
    private lateinit var binding: FragmentViewNoteBinding
    private val notes by navArgs<ViewNoteFragmentArgs>()
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentViewNoteBinding.inflate(layoutInflater, container, false)

        // textviews
        binding.editTextHeading.text = notes.data.title
        binding.editTextContent.text = notes.data.content
        binding.textViewDateandtime.text = getString(R.string.label_textView_dateAndTime, notes.data.lastEditedDay, notes.data.lastEditedTime)

        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {

                //Edit Button
                R.id.toolbar_options_edit -> {
//                    findNavController().navigate()
                    true
                }

                //Delete Button
                R.id.menu_options_delete -> {
                    showAlertDialog()
                    true
                }

                else -> { true }
            }
        }

        return binding.root
    }

    private fun showAlertDialog() {
        val dialog = NotaAlertDialog(requireContext())
        dialog.setTitle("Delete note ?")
        dialog.setMessage("Notes once deleted cant be recovered")
        dialog.setPositiveButton("confirm", View.OnClickListener {
            mainViewModel.deleteNotes(notes.data.id!!)
            findNavController().popBackStack()
        })
        dialog.setNegativeButton("Cancel", null)
        dialog.show()
    }

}