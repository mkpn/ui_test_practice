package makoto.yoshida.uitesttutorial.viewmodel

import android.provider.MediaStore
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import makoto.yoshida.uitesttutorial.domain.TestEntity
import makoto.yoshida.uitesttutorial.domain.TestRepository

class SecondFragmentViewModel @ViewModelInject constructor(private val repository: TestRepository) :
    ViewModel() {

    private val list = ArrayList<TestEntity>()
    fun getLiveDataList(): LiveData<List<TestEntity>> {
        val mediatorLiveData = MediatorLiveData<List<TestEntity>>()
        mediatorLiveData.addSource(repository.getAll()) {
            list.clear()
            list.addAll(it)
            mediatorLiveData.postValue(it)
        }
        return mediatorLiveData
    }

    fun sortItem(fromPosition: Int, toPosition: Int) {
        val testEntity = list[fromPosition]
        list.removeAt(fromPosition)
        list.add(toPosition, testEntity)
    }

    fun updateOrder() {

    }
}