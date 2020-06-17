package makoto.yoshida.uitesttutorial.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import makoto.yoshida.uitesttutorial.domain.TestEntity
import makoto.yoshida.uitesttutorial.domain.TestRepository

class MainActivityViewModel @ViewModelInject constructor(private val repository: TestRepository) :
    ViewModel() {
    fun insert() {
        val entity = TestEntity(
            0,
            "テスト ${repository.getMax() + 1}"
        )
        repository.insert(entity)
    }
}