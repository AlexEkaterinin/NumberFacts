package com.example.numberfacts.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "date_numbers")
data class DateNumberEntity(
    @PrimaryKey
    override val uid: Int,
    @ColumnInfo(name = "text_info")
    override val text_info: String?,
    @ColumnInfo(name = "number")
    override val number: Long?,
    @ColumnInfo(name = "year")
    val year: Int?
): Fact