package co.antcloud.core.repository

import co.antcloud.core.data.Note

class NoteRepository(private val dataSource: NoteDataSource) {
    suspend fun addNote(note: Note) = dataSource.add(note)

    suspend fun getNote(id: Long) = dataSource.get(id)

    suspend fun getAllNotes(): List<Note> = dataSource.getAll()

    suspend fun removeNote(note: Note) = dataSource.remove(note)
}