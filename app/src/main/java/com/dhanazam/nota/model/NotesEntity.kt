package com.dhanazam.nota.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "notes_id" )
    var id:Int? = null,

    @ColumnInfo(name = "notes_title" )
    var title:String,

    @ColumnInfo(name = "notes_content" )
    var content:String,

    @ColumnInfo(name = "notes_lastEdited_date" )
    var lastEditedDate:String,

    @ColumnInfo(name = "notes_lastEdited_day" )
    var lastEditedDay:String,

    @ColumnInfo(name = "notes_lastEdited_time" )
    var lastEditedTime:String,

    @ColumnInfo(name = "notes_lastEdited_month" )
    var lastEditedMonth:String,
)
