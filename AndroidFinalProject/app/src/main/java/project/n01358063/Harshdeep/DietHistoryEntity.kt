package project.n01358063.Harshdeep

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class DietHistory(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "timeOfDay")
    var timeOfDay: String,
    @ColumnInfo(name = "food")
    var Food: String,
    @ColumnInfo(name = "calorieCount")
    var calorieCount: String
)
