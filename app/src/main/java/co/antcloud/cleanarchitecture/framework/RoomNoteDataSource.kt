package co.antcloud.cleanarchitecture.framework

import android.content.Context
import co.antcloud.cleanarchitecture.framework.db.DatabaseService
import co.antcloud.cleanarchitecture.framework.db.NoteEntity
import co.antcloud.core.data.Note
import co.antcloud.core.repository.NoteDataSource

class RoomNoteDataSource(context: Context): NoteDataSource {
    val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long) = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll() = noteDao.getAllNoteEntity().map { it.toNote() }

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
}