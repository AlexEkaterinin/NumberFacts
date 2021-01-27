package com.example.numberfacts.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.numberfacts.db.entity.TriviaNumberEntity

@Dao
interface TriviaNumbersDao {
    @Query("SELECT * FROM trivia_numbers")
    fun getAll(): List<TriviaNumberEntity>

    @Query("SELECT * FROM trivia_numbers WHERE number = :number")
    fun getSpecificNumber(number: Int): List<TriviaNumberEntity>

    @Query("SELECT * FROM trivia_numbers WHERE number >= :min AND number <= :max")
    fun getNumbersInRange(min: Int, max: Int): List<TriviaNumberEntity>

    @Query("SELECT * FROM trivia_numbers WHERE number > :min")
    fun getMoreSetNumber(min: Int): List<TriviaNumberEntity>

    @Query("SELECT * FROM trivia_numbers WHERE number < :max")
    fun getLessSetNumber(max: Int): List<TriviaNumberEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNumberInfo(number: TriviaNumberEntity)

    @Query("DELETE FROM trivia_numbers WHERE uid = :id")
    fun deleteNumberById(id: Int)

    @Query("DELETE FROM trivia_numbers")
    fun deleteAll()
}