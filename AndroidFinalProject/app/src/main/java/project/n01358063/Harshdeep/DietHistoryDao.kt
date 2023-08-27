package project.n01358063.Harshdeep

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DietHistoryDao {
    @Query("SELECT * FROM person")
    fun getAll(): List<DietHistory>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dietHistory: DietHistory)


    // @Update
    //   fun update(Food:DietHistory): String


    @Query("DELETE FROM person")
    fun delete()

}