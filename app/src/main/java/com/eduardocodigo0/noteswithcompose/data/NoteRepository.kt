package com.eduardocodigo0.noteswithcompose.data

import com.eduardocodigo0.noteswithcompose.model.NoteModel
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun  getAllNotes(): Flow<List<NoteModel>>
    suspend fun  getOneNote(noteId: Int): NoteModel?
    suspend fun upsertNote(note: NoteModel): Boolean
    suspend fun deleteNote(note: NoteModel): Boolean
}