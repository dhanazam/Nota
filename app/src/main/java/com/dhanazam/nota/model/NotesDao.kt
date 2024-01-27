package com.dhanazam.nota.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {

    @Query("SELECT * FROM Notes")
    fun getNote(): LiveData<List<NotesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: NotesEntity)

    @Query("DELETE FROM Notes WHERE notes_id=:id")
    fun deleteNotes(id: Int)

    @Update
    fun updateNotes(notes: NotesEntity)

}