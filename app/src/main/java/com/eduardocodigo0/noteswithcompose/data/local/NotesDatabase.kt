package com.eduardocodigo0.noteswithcompose.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.eduardocodigo0.noteswithcompose.data.DataConstants

@Database(entities = [NoteDatabaseEntity::class], version = 1)
abstract class NotesDatabase: RoomDatabase() {
    abstract fun notesDao(): NoteTableDao
}

fun Context.getNoteDao(): NoteTableDao{
    return Room.databaseBuilder(
        this,
        NotesDatabase::class.java,
        DataConstants.NOTE_DB_TABLE_NAME
    ).build().notesDao()
}

