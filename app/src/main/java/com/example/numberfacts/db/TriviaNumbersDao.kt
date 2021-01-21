package com.example.numberfacts.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface TriviaNumbersDao {
    @Query("SELECT * FROM trivia_numbers")
    fun getAll()
}