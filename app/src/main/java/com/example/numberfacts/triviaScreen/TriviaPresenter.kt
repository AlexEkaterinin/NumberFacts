package com.example.numberfacts.triviaScreen

import android.util.Log
import com.example.numberfacts.R
import com.example.numberfacts.db.entity.TriviaNumberEntity
import com.example.numberfacts.model.NumbersInfoModel
import kotlinx.coroutines.*
import kotlinx.coroutines.async

class TriviaPresenter(
    private val view: TriviaContractView,
    private val model: NumbersInfoModel
) {

    var progress: Boolean = false
        set(value) {
            field = value
            view.showProgress(value)
        }

    private var response: TriviaNumberEntity? = null


    fun btnState(isEmpty: Boolean) {
        view.btnSetText(
            if (isEmpty) {
                R.string.button_search_text_empty_enter
            } else {
                R.string.button_search_text_not_empty_enter
            }
        )
    }


    fun saveTriviaNumber() {

        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                response?.let(model::insertNumberDb)
            }
        }
        view.showSuccessfulSave()
    }

    fun getNumberInfo(text: String) {
        progress = true

        val exc = CoroutineExceptionHandler { _, t ->
            view.showError()
            progress = false
        }

        GlobalScope.launch(exc) {

            response = withContext(Dispatchers.IO) {
                model.requestServer(text)
            }

            withContext(Dispatchers.Main) {
                if (response != null) {
                    view.setTextInfoAboutNumber(response?.text_info.orEmpty())
                    view.showSaveBtn(true)
                } else {
                    view.showError()
                }
                progress = false
            }
        }
    }
}