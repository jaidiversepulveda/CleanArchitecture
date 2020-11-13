package co.antcloud.core.usecase

import co.antcloud.core.data.Note
import co.antcloud.core.repository.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.addNote(note)
}