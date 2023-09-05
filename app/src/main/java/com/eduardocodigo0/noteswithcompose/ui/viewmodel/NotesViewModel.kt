package com.eduardocodigo0.noteswithcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eduardocodigo0.noteswithcompose.data.NoteRepository
import com.eduardocodigo0.noteswithcompose.model.NoteModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NotesViewModel(
    private val repo: NoteRepository,
    private var scope: CoroutineScope? = null,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    private val _upsertFlow: MutableStateFlow<Boolean?> = MutableStateFlow(null)
    val upsertFlow: Flow<Boolean?> get() = _upsertFlow

    private val _deleteFlow: MutableStateFlow<Boolean?> = MutableStateFlow(null)
    val deleteFlow: Flow<Boolean?> get() = _deleteFlow

    private val _oneNoteFlow: MutableStateFlow<NoteModel?> = MutableStateFlow(null)
    val oneNoteFlow: Flow<NoteModel?> get() = _oneNoteFlow

    var allNotesFlow: MutableStateFlow<List<NoteModel>> = MutableStateFlow(listOf())
        private set


    init {
        if (scope == null) {
            scope = viewModelScope
        }
    }


    fun insertNote(note: NoteModel) {
        scope?.launch(dispatcher) {
            val result = repo.upsertNote(note)

            _upsertFlow.emit(result)
        }
    }

    fun deleteNote(note: NoteModel) {
        scope?.launch(dispatcher) {
            val result = repo.deleteNote(note)

            _deleteFlow.emit(result)
        }
    }

    fun getAllNotes() {
        scope?.launch(dispatcher) {
            allNotesFlow = repo.getAllNotes() as MutableStateFlow<List<NoteModel>>
        }
    }

    fun getOneNote(noteId: Int) {
        scope?.launch(dispatcher) {
            val result = repo.getOneNote(noteId)

            _oneNoteFlow.emit(result)
        }
    }

}