package com.example.numberfacts.savedFacts

import com.example.numberfacts.model.NumbersInfoModel
import kotlinx.coroutines.*

class SavedNumbersPresenter(
    private val view: SavedFactsContactView,
    private val model: NumbersInfoModel
) {

    private val coroutineScope = CoroutineScope(Job())

    fun getNumbersListFromDb() {
        coroutineScope.launch {
            val list = withContext(Dispatchers.IO) {
                model.getAllTriviaNumbers()
            }

            withContext(Dispatchers.Main) {
                view.showNumberList(list)
            }
        }

    }

    fun dispose(){
        coroutineScope.cancel()
    }
}