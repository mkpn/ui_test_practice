package makoto.yoshida.uitesttutorial.viewmodel

import androidx.arch.core.util.Function
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import makoto.yoshida.uitesttutorial.domain.TestEntity
import makoto.yoshida.uitesttutorial.domain.TestRepository

class TestDialogFragmentViewModel @ViewModelInject constructor (
                                  private val repository: TestRepository) : ViewModel() {

    val name = MutableLiveData("変わるかな？？")
    private val observer = Observer<TestEntity> {
        name.postValue(it.name)
    }

    fun fetchData() {
        repository.get(1).also { liveData ->
            liveData.observeForever {
                observer.onChanged(it)
                liveData.removeObserver(observer)
            }
        }
    }
}