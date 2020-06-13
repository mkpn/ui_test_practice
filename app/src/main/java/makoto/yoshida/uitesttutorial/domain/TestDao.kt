package makoto.yoshida.uitesttutorial.domain

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
abstract class TestDao {
    @Insert
    abstract fun insert(entity: TestEntity)

    @Query("select * from test")
    abstract fun getAll(): LiveData<List<TestEntity>>

    @Query("select * from test where id = (:id)")
    abstract fun get(id: Long): LiveData<TestEntity>
}