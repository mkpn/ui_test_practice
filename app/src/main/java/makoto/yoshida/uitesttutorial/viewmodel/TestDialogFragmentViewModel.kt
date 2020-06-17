package makoto.yoshida.uitesttutorial.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import makoto.yoshida.uitesttutorial.domain.TestEntity
import makoto.yoshida.uitesttutorial.domain.TestRepository

class TestDialogFragmentViewModel @ViewModelInject constructor (
                                  private val repository: TestRepository) : ViewModel() {

    val name = MutableLiveData("変わるかな？？")

    fun fetchData() {
        // DialogFragmentのViewModelでLiveDataをobserveできない問題があまりにも深刻でこの方法しか思いつかなかった
        // 素直にTransformations.mapとかしても動かない
        repository.get(1).also { liveData ->
            liveData.observeForever(object: Observer<TestEntity> {
                override fun onChanged(t: TestEntity) {
                    name.postValue(t.name)
                    liveData.removeObserver(this)
                }
            })
        }
    }
}