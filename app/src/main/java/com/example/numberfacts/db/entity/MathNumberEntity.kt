package com.example.numberfacts.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "math_numbers")
data class MathNumberEntity(
    @PrimaryKey
    val uid: Int,
    @ColumnInfo(name = "text_info")
    val text_info: String?,
    @ColumnInfo(name = "number")
    val number: Int?
)
