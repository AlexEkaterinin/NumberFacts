package com.example.numberfacts.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.numberfacts.db.entity.MathNumberEntity

@Dao
interface MathNumbersDao {
    @Query("SELECT * FROM math_numbers")
    fun getAll(): List<MathNumberEntity>

    @Query("SELECT * FROM math_numbers WHERE number = :number")
    fun getSpecificNumber(number: Int): List<MathNumberEntity>

    @Query("SELECT * FROM math_numbers WHERE number >= :min AND number <= :max")
    fun getNumbersInRange(min: Int, max: Int): List<MathNumberEntity>

    @Query("SELECT * FROM math_numbers WHERE number > :min")
    fun getMoreSetNumber(min: Int): List<MathNumberEntity>

    @Query("SELECT * FROM math_numbers WHERE number < :max")
    fun getLessSetNumber(max: Int): List<MathNumberEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNumberInfo(number: MathNumberEntity)

    @Query("DELETE FROM math_numbers WHERE uid = :id")
    fun deleteNumberById(id: Int)

    @Query("DELETE FROM math_numbers")
    fun deleteAll()
}