package co.antcloud.cleanarchitecture.framework

import co.antcloud.core.usecase.*

data class UseCases (
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote,
    val getWordCount: GetWordCount
)