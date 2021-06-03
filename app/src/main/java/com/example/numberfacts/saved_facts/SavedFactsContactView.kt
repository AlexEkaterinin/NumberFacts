package com.example.numberfacts.saved_facts

import com.example.numberfacts.db.entity.NumbersNotDateInfo

interface SavedFactsContactView {

    fun showNumberList(numberList: List<NumbersNotDateInfo>)
    fun titleSetText(text: String)
}