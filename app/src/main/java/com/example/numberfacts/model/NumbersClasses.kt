package com.example.numberfacts.model

data class NumberNotDate(
    val text: String,
    val number: Long,
    val isFound: Boolean,
    val type: String
)

data class DateNumber(
    val text: String,
    val year: Int,
    val number: Long,
    val isFound: Boolean,
    val type: String
)

