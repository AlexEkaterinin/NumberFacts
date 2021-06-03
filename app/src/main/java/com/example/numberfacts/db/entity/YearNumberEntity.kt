package com.example.numberfacts.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "year_numbers")
data class YearNumberEntity(
    @PrimaryKey
    val uid: Int,
    @ColumnInfo(name = "text_info")
    override val textInfo: String?,
    @ColumnInfo(name = "number")
    override val number: Long?
): NumbersNotDateInfo