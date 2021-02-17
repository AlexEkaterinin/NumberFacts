package com.example.numberfacts.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.numberfacts.db.entity.DateNumberEntity
import com.example.numberfacts.db.entity.MathNumberEntity
import com.example.numberfacts.db.entity.TriviaNumberEntity
import com.example.numberfacts.db.entity.YearNumberEntity

@Database(
    entities = [
        DateNumberEntity::class,
        MathNumberEntity::class,
        TriviaNumberEntity::class,
        YearNumberEntity::class
    ],
    version = 1
)
abstract class NumberDatabase : RoomDatabase() {
    abstract fun triviaNumbersDao(): TriviaNumbersDao
    abstract fun mathNumbersDao(): MathNumbersDao

    companion object {
        @Volatile
        private var INSTANCE: NumberDatabase? = null

        fun getInstance(context: Context): NumberDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NumberDatabase::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
