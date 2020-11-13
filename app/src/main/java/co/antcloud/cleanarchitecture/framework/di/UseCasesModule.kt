package co.antcloud.cleanarchitecture.framework.di

import co.antcloud.cleanarchitecture.framework.UseCases
import co.antcloud.core.repository.NoteRepository
import co.antcloud.core.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {
    @Provides
    fun getUseCases(repository: NoteRepository) = UseCases (
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
        GetWordCount()
    )
}