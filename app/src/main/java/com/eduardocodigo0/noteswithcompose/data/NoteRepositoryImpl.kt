package com.eduardocodigo0.noteswithcompose.data

import com.eduardocodigo0.noteswithcompose.data.local.NoteDatabaseEntity
import com.eduardocodigo0.noteswithcompose.data.local.NoteDatabaseEntity.Companion.fromModel
import com.eduardocodigo0.noteswithcompose.data.local.NoteTableDao
import com.eduardocodigo0.noteswithcompose.data.local.toModel
import com.eduardocodigo0.noteswithcompose.model.NoteModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl( private val notesDao: NoteTableDao ): NoteRepository {

    override suspend fun getAllNotes(): Flow<List<NoteModel>> {
        return notesDao.getAllNotes().map { noteList ->
            noteList.map { noteEntity ->
                noteEntity.toModel()
            }
        }
    }

    override suspend fun getOneNote(noteId: Int): NoteModel? {
        return try {
            notesDao.getOneNote(noteId).toModel()
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun upsertNote(note: NoteModel): Boolean {
        return try {
            notesDao.insertNote(
                NoteDatabaseEntity.fromModel(note)
            )
            true
        }catch (e: Exception){
            false
        }
    }

    override suspend fun deleteNote(note: NoteModel): Boolean {
        return try {
            notesDao.deleteNote(
                NoteDatabaseEntity.fromModel(note)
            )
            true
        }catch (e: Exception){
            false
        }
    }
}