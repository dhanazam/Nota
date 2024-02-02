package com.dhanazam.nota.view.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dhanazam.nota.R
import com.dhanazam.nota.databinding.FragmentHomeBinding
import com.dhanazam.nota.model.NotesEntity
import com.dhanazam.nota.view.adapter.MyNotesAdapter
import com.dhanazam.nota.viewmodel.MainViewModel
import java.lang.Exception

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val mainViewModel: MainViewModel by viewModels()
    private var oldMyNotes = arrayListOf<NotesEntity>()
    private lateinit var adapter: MyNotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        // FAB listener
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_createNoteFragment)
        }

        // Setting up Recycler View
        mainViewModel.getNote().observe(viewLifecycleOwner) { noteList ->

            // Showing illustration and instruction if user hasn't create any notes
            if(noteList.isEmpty()){
                binding.imageViewIllustration.visibility = View.VISIBLE
                binding.textViewInstructions.visibility = View.VISIBLE
            } else {
                oldMyNotes = noteList as ArrayList<NotesEntity>
                binding.myNotesRecyclerView.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
                adapter = MyNotesAdapter(requireContext(), noteList)
                binding.myNotesRecyclerView.adapter = adapter
            }
        }

        //Searchbar
        binding.editTextSearch.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                try {
                    notesFiltering(p0)
                } catch (e: Exception) {
                    Log.e("Error", e.toString())
                }
            }
        })

        // Handling searchbar focus
        binding.editTextSearch.setOnClickListener {
            if(it.isFocused) {
                it.clearFocus()
            }
        }

        return binding.root
    }

    private fun notesFiltering(s: CharSequence?) {
        val newFilteredList = arrayListOf<NotesEntity>()
        for (i in oldMyNotes) {
            if (i.title.contains(s.toString()) || i.content.contains(s.toString())) {
                newFilteredList.add(i)
            }
        }
        adapter.filtering(newFilteredList)
    }
}