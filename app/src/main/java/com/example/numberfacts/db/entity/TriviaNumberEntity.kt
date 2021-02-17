package com.example.numberfacts.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trivia_numbers")
data class TriviaNumberEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    @ColumnInfo(name = "text_info")
    override val textInfo: String?,
    @ColumnInfo(name = "number")
    override val number: Long?
) : NumbersNotDateInfo

