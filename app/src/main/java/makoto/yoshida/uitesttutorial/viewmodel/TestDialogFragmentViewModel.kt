package makoto.yoshida.uitesttutorial.viewmodel

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import makoto.yoshida.uitesttutorial.domain.TestDataBase
import makoto.yoshida.uitesttutorial.domain.TestEntity
import makoto.yoshida.uitesttutorial.domain.TestRepository

class TestDialogFragmentViewModel @ViewModelInject constructor (
                                  private val repository: TestRepository) : ViewModel() {
    private lateinit var database: TestDataBase

    val name = MutableLiveData("変わるかな？？")

    fun setup(context: Context) {
        database = TestDataBase.getDatabase(context)!!
    }

    fun fetchData() {
        database.testDao().get(1).observeForever {
            name.postValue(it.name)
        }
    }

    fun test(): LiveData<TestEntity> {
        return database.testDao().get(1)
    }
}