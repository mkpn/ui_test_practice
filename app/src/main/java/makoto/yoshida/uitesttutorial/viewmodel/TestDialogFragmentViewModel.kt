package makoto.yoshida.uitesttutorial.viewmodel

import android.content.Context
import androidx.lifecycle.*
import makoto.yoshida.uitesttutorial.TestDataBase
import makoto.yoshida.uitesttutorial.TestEntity

class TestDialogFragmentViewModel : ViewModel() {
    lateinit var database : TestDataBase
    val name = MutableLiveData<String>("テスト")

    fun setup(context: Context) {
        val database = TestDataBase.getDatabase(context)
    }

    fun getData(id: Long) : LiveData<TestEntity>{
        val mediator = MediatorLiveData<TestEntity>()
        mediator.addSource(database.testDao().get(id), Observer {
            name.postValue(it.name)
            mediator.postValue(it)
        })
        return mediator
    }
}