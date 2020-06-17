package makoto.yoshida.uitesttutorial.domain

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import java.util.ArrayList
import javax.inject.Singleton

@Singleton
class TestRepository(context: Context) {
    private val dao = TestDataBase.getDatabase(context)!!.testDao()

    fun insert(entity: TestEntity) {
        entity.order = dao.getMax() + 1
        dao.insert(entity)
    }

    fun getMax(): Int {
        return dao.getMax()
    }

    fun get(id :Long): LiveData<TestEntity> {
        return dao.get(id)
    }

    fun getAll(): LiveData<List<TestDataClass>> {
        val mediator = MediatorLiveData<List<TestDataClass>>()
        mediator.addSource(dao.getAll()) {
            val dataList = ArrayList<TestDataClass>(it.size)
            it.forEach {entity ->
                dataList.add(TestDataClass(
                    entity.id,
                    entity.name,
                    entity.order
                ))
            }
            mediator.postValue(dataList)
        }
        return mediator
    }

    fun updateByList(list: ArrayList<TestDataClass>) {
        val tempList = mutableListOf<TestEntity>()
        list.forEachIndexed { index, data ->
            data.order = index + 1
            val entity = TestEntity(
                data.id,
                data.name,
                data.order
            )
            tempList.add(entity)
        }
        dao.updateByList(tempList)
    }
}