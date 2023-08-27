package project.n01358063.Harshdeep

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DietHistory::class], version = 1)
abstract class DietHistoryDatabase : RoomDatabase() {
    abstract fun dietHistoryDao(): DietHistoryDao

    companion object {

        @Volatile
        private var INSTANCE: DietHistoryDatabase? = null

        fun getInstance(context: Context): DietHistoryDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    DietHistoryDatabase::class.java,
                    "person.db"
                ).build()
            }
            return INSTANCE as DietHistoryDatabase
        }
    }
}