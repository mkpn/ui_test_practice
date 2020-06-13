package makoto.yoshida.uitesttutorial.domain

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TestEntity::class], version = 1)
abstract class TestDataBase : RoomDatabase() {
    abstract fun testDao(): TestDao

    companion object {
        @Volatile
        private var instance: TestDataBase? = null

        fun getDatabase(context: Context): TestDataBase? {
            return instance
                ?: synchronized(this) {
                val databaseInstance = Room.databaseBuilder(context.applicationContext,
                    TestDataBase::class.java,
                    "test")
                    .allowMainThreadQueries()
                    .build()
                instance = databaseInstance
                    instance
            }
        }
    }
}