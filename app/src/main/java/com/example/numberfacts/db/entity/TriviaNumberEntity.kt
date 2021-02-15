package com.example.numberfacts.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trivia_numbers")
data class TriviaNumberEntity(
    @PrimaryKey(autoGenerate = true)
    override val uid: Int = 0,
    @ColumnInfo(name = "text_info")
    override val text_info: String?,
    @ColumnInfo(name = "number")
    override val number: Long?
): Fact

interface Fact {
    val number: Long?
    val text_info: String?
    val uid: Int
}

