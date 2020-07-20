package com.example.numberfacts

data class NumberNotDate(
    val text: String,
    val number: Long,
    val isFound: Boolean,
    val type: String
)

data class DateNumber(
    val text: String,
    val year: Long,
    val number: Int,
    val isFound: Boolean,
    val type: String
)

