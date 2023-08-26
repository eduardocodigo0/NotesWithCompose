package com.eduardocodigo0.noteswithcompose.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.eduardocodigo0.noteswithcompose.data.DataConstants.NOTE_DB_TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteTableDao {
    @Upsert
    suspend fun insertNote(note: NoteDatabaseEntity)

    @Delete
    suspend fun deleteNote(note: NoteDatabaseEntity)

    @Query("SELECT * FROM $NOTE_DB_TABLE_NAME WHERE id=:noteId ")
    suspend fun getOneNote(noteId: Int): NoteDatabaseEntity

    @Query("SELECT * FROM $NOTE_DB_TABLE_NAME")
    fun getAllNotes(): Flow<List<NoteDatabaseEntity>>

}