package makoto.yoshida.uitesttutorial.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import makoto.yoshida.uitesttutorial.TestDataBase
import makoto.yoshida.uitesttutorial.TestEntity

class TestDialogFragmentViewModel : ViewModel() {
    private lateinit var database : TestDataBase
    val name = MutableLiveData("変わるかな？？")

    fun setup(context: Context) {
        database = TestDataBase.getDatabase(context)!!
    }

    fun fetchData() {
        database.testDao().get(1).observeForever {
        Log.d("デバッグ", "${it.name}")
            name.postValue(it.name)
        }
    }

    fun test() : LiveData<TestEntity>{
        return database.testDao().get(1)
    }
}