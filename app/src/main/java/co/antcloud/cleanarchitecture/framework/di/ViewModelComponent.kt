package co.antcloud.cleanarchitecture.framework.di

import co.antcloud.cleanarchitecture.framework.ListViewModel
import co.antcloud.cleanarchitecture.framework.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}