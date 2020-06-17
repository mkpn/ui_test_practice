package makoto.yoshida.uitesttutorial.domain

import android.content.Context
import androidx.lifecycle.LiveData
import javax.inject.Singleton

@Singleton
class TestRepository(context: Context) {
    private val dao = TestDataBase.getDatabase(context)!!.testDao()

    fun get(id :Long): LiveData<TestEntity> {
        return dao.get(id)
    }

    fun getAll(): LiveData<List<TestEntity>> {
        return dao.getAll()
    }
}