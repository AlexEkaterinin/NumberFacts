package com.example.numberfacts.saved_facts

import com.example.numberfacts.db.entity.TriviaNumberEntity

interface SavedFactsContactView {

    fun showNumberList(numberList: List<TriviaNumberEntity>)
}