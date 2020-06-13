package makoto.yoshida.uitesttutorial.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import makoto.yoshida.uitesttutorial.domain.TestRepository

class TestDialogFragmentViewModel @ViewModelInject constructor (
                                  private val repository: TestRepository) : ViewModel() {

    val name = MutableLiveData("変わるかな？？")


    fun fetchData() {
        repository.get(1).observeForever {
            name.postValue(it.name)
        }
    }
}