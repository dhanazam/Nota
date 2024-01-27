package com.dhanazam.nota.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dhanazam.nota.R
import com.dhanazam.nota.databinding.LargeCardViewBinding
import com.dhanazam.nota.model.NotesEntity

class MyNotesAdapter(private val requireContext: Context, private var noteList: List<NotesEntity>) : RecyclerView.Adapter<MyNotesAdapter.MyNotesViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * custom ViewHolder
     */
    class MyNotesViewHolder(val binding: LargeCardViewBinding): RecyclerView.ViewHolder(binding.root)

    // Create new views (invoke by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyNotesViewHolder {
        return MyNotesViewHolder(LargeCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    // Return the size of your dateset that was by the layout manager
    override fun getItemCount(): Int {
        return noteList.size
    }

    // Replace the contents of view (invoke by the layout manager)
    override fun onBindViewHolder(holder: MyNotesViewHolder, position: Int) {
        val data = noteList[position]

        if (data.title.isEmpty()) {
            holder.binding.largeCardTitle.text = data.content
            holder.binding.largeCardContent.text = data.content
        } else {
            holder.binding.largeCardTitle.text = data.title
            holder.binding.largeCardContent.text = data.content
        }

        //Sets up card date and month
        holder.binding.largeCardLastEditedDateAndMonth.text = requireContext.resources.getString(R.string.label_card_dateAndMonth, data.lastEditedDate, data.lastEditedMonth)

        //Card click-listener
//        holder.binding.root.setOnClickListener {  }
    }
}