package makoto.yoshida.uitesttutorial.domain

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
abstract class TestDao {
    @Insert
    abstract fun insert(entity: TestEntity)

    @Update
    abstract fun update(entity: TestEntity)

    @Query("select max(`order`) from test")
    abstract fun getMax(): Int

    @Query("select * from test order by `order` asc")
    abstract fun getAll(): LiveData<List<TestEntity>>

    @Query("select * from test where id = (:id)")
    abstract fun get(id: Long): LiveData<TestEntity>
}