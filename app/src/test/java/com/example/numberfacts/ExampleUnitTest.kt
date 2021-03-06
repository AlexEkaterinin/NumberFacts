package com.example.numberfacts

import android.content.Context
import androidx.room.Room
import com.example.numberfacts.db.TriviaNumbersDao
import org.junit.Before
import com.example.numberfacts.db.NumberDatabase
import androidx.test.core.app.ApplicationProvider
import com.example.numberfacts.db.entity.TriviaNumberEntity
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test


class DbTests09 {
    private lateinit var db: NumberDatabase
    private lateinit var triviaDao: TriviaNumbersDao

    @Before
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NumberDatabase::class.java
        ).build()
        triviaDao = db.numbersDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertTriviaNumber() {
        val triviaNum = TriviaNumberEntity(0, "Some text", 5)
        triviaDao.insertNumberInfo(triviaNum)
        val db1 = triviaDao.getAll()
        assertEquals(1, db1.size)
    }
}