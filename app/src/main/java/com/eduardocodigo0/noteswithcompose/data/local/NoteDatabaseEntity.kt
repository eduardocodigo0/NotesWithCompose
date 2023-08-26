package com.eduardocodigo0.noteswithcompose.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.eduardocodigo0.noteswithcompose.data.DataConstants.NOTE_DB_TABLE_NAME
import com.eduardocodigo0.noteswithcompose.model.NoteModel

@Entity(tableName = NOTE_DB_TABLE_NAME, indices = [(Index(value = ["title"], unique = true))])
data class NoteDatabaseEntity(
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo
    val title: String,

    @ColumnInfo
    val content: String,

    @ColumnInfo
    val date: String

) {
    companion object {
        fun NoteDatabaseEntity.Companion.fromModel(noteModel: NoteModel): NoteDatabaseEntity {
            return NoteDatabaseEntity(
                id = noteModel.id,
                title = noteModel.title,
                content = noteModel.content,
                date = noteModel.date
            )
        }
    }
}

fun NoteDatabaseEntity.toModel(): NoteModel {
    return NoteModel(
        id = this.id,
        title = this.title,
        content = this.content,
        date = this.date
    )
}


