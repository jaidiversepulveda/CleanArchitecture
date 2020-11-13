package co.antcloud.cleanarchitecture.framework.di

import android.app.Application
import co.antcloud.cleanarchitecture.framework.RoomNoteDataSource
import co.antcloud.core.repository.NoteRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))
}