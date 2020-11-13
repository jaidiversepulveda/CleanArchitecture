package co.antcloud.cleanarchitecture.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import co.antcloud.cleanarchitecture.framework.di.ApplicationModule
import co.antcloud.cleanarchitecture.framework.di.DaggerViewModelComponent
import co.antcloud.core.data.Note
import co.antcloud.core.repository.NoteRepository
import co.antcloud.core.usecase.AddNote
import co.antcloud.core.usecase.GetAllNotes
import co.antcloud.core.usecase.GetNote
import co.antcloud.core.usecase.RemoveNote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel(application: Application): AndroidViewModel(application) {

    private val coroutineSource = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    val notes = MutableLiveData<List<Note>>()

    fun getNotes(){
        coroutineSource.launch {
            val noteList: List<Note> = useCases.getAllNotes()
            noteList.forEach { it.wordCount = useCases.getWordCount.invoke(it) }
            notes.postValue(noteList)
        }
    }
}