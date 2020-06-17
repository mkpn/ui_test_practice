package makoto.yoshida.uitesttutorial.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import makoto.yoshida.uitesttutorial.domain.TestEntity
import makoto.yoshida.uitesttutorial.domain.TestRepository

class SecondFragmentViewModel @ViewModelInject constructor(private val repository: TestRepository) :
    ViewModel() {
    fun getLiveDataList(): LiveData<List<TestEntity>> {
        return repository.getAll()
    }
}