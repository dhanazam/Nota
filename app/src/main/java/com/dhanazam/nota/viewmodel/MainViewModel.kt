package com.dhanazam.nota.viewmodel

import  android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dhanazam.nota.model.NotesDatabase
import com.dhanazam.nota.model.NotesEntity
import com.dhanazam.nota.repository.MainRepository

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository:MainRepository

    init{
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = MainRepository(dao)

    }

    fun getNote(): LiveData<List<NotesEntity>> {
        return repository.getNote()
    }

    fun insertNotes(notes: NotesEntity){
        repository.insertNotes(notes)
    }

    fun deleteNotes(id: Int){
        repository.deleteNotes(id)
    }

    fun updateNotes(notes: NotesEntity){
        repository.updateNotes(notes)
    }


}