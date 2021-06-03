package com.example.numberfacts.saved_facts

import com.example.numberfacts.model.NumbersInfoModel
import com.example.numberfacts.saved_facts.SavedFactsFragment.Companion.MATH_CATEGORY
import com.example.numberfacts.saved_facts.SavedFactsFragment.Companion.TRIVIA_CATEGORY
import kotlinx.coroutines.*

class SavedNumbersPresenter(
    private val view: SavedFactsContactView,
    private val model: NumbersInfoModel
) {

    private val coroutineScope = CoroutineScope(Job())

    fun showNumbersList(category: String) {

        coroutineScope.launch {
            val list = withContext(Dispatchers.IO) {
                when (category) {
                    TRIVIA_CATEGORY -> model.getAllTriviaNumbers()
                    MATH_CATEGORY -> model.getAllMathNumbers()
                    else -> listOf()
                }
            }

            withContext(Dispatchers.Main) {
                view.titleSetText(category)
                view.showNumberList(list)
            }
        }
    }

    fun dispose() {
        coroutineScope.cancel()
    }
}