package com.example.numberfacts.savedFacts

import com.example.numberfacts.db.entity.TriviaNumberEntity

interface SavedFactsContactView {

    fun showNumberList(numberList: List<TriviaNumberEntity>)
}