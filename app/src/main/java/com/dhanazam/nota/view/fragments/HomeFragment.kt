package com.dhanazam.nota.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dhanazam.nota.R
import com.dhanazam.nota.databinding.FragmentHomeBinding
import com.dhanazam.nota.model.NotesEntity
import com.dhanazam.nota.view.adapter.MyNotesAdapter
import com.dhanazam.nota.viewmodel.MainViewModel

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

        return binding.root
    }
}