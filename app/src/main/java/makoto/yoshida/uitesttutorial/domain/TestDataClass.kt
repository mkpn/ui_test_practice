package makoto.yoshida.uitesttutorial.domain

import androidx.room.ColumnInfo

data class TestDataClass(
    val id: Long = 0,
    val name: String,
    var order: Int = 0
)