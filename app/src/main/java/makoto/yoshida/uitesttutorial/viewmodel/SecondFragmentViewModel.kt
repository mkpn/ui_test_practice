package makoto.yoshida.uitesttutorial.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import makoto.yoshida.uitesttutorial.domain.TestDataClass
import makoto.yoshida.uitesttutorial.domain.TestEntity
import makoto.yoshida.uitesttutorial.domain.TestRepository

class SecondFragmentViewModel @ViewModelInject constructor(private val repository: TestRepository) :
    ViewModel() {
    private val list = ArrayList<TestDataClass>()

    fun getLiveDataList(): MediatorLiveData<List<TestDataClass>> {
        val mediatorLiveData = MediatorLiveData<List<TestDataClass>>()
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
        repository.updateByList(list)
    }
}