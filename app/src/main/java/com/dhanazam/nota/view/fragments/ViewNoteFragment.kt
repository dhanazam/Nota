package com.dhanazam.nota.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dhanazam.nota.databinding.FragmentViewNoteBinding

class ViewNoteFragment : Fragment() {
    private lateinit var binding: FragmentViewNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentViewNoteBinding.inflate(layoutInflater, container, false)

        // binding

        return binding.root
    }

}