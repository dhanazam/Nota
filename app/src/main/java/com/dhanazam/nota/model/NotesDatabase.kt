package com.dhanazam.nota.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NotesEntity::class], version = 1, exportSchema = false)
abstract class NotesDatabase: RoomDatabase() {

    abstract fun myNotesDao():NotesDao

    companion object {
        private var INSTANCE: NotesDatabase? = null

        fun getDatabaseInstance(context: Context): NotesDatabase {
            if(INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    NotesDatabase::class.java, "NotesDB").build()
                }
            }

            return INSTANCE!!
        }
    }
}