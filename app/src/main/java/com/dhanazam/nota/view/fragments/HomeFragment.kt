package com.dhanazam.nota.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dhanazam.nota.R
import com.dhanazam.nota.databinding.FragmentHomeBinding
import com.dhanazam.nota.model.NotesEntity
import com.dhanazam.nota.view.adapter.MyNotesAdapter
import com.dhanazam.nota.viewmodel.MainViewModel

class homeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val mainViewModel: MainViewModel by viewModels()
    private var oldMyNotes = arrayListOf<NotesEntity>()
    private lateinit var adapter: MyNotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}