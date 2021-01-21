package com.example.numberfacts.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trivia_numbers")
data class TriviaNumberEntity(
    @PrimaryKey
    val uid: Int,
    @ColumnInfo(name = "text_info")
    val text_info: String?,
    @ColumnInfo(name = "number")
    val number: Int?
)

