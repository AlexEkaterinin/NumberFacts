package com.example.numberfacts.math_screen

import com.example.numberfacts.R
import com.example.numberfacts.db.entity.NumbersNotDateInfo
import com.example.numberfacts.model.NumbersInfoModel
import com.example.numberfacts.model.NumbersInfoModel.Companion.MATH_PATH
import kotlinx.coroutines.*

class MathPresenter(
    private val view: MathContractView,
    private val model: NumbersInfoModel
) {

    var progress: Boolean = false
        set(value) {
            field = value
            view.showProgress(value)
        }

    private var response: NumbersNotDateInfo? = null


    fun btnSearchSetText(isEmpty: Boolean) {
        view.btnSetText(
            if (isEmpty) {
                R.string.button_search_text_empty_enter
            } else {
                R.string.button_search_text_not_empty_enter
            }
        )
    }


    fun saveMathNumber() {

        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                response?.let(model::insertMathNumberDb)
            }
        }
        view.showSuccessfulSave()
    }

    fun getNumberInfo(number: String) {
        progress = true

        val exc = CoroutineExceptionHandler { _, t ->
            view.showError()
            progress = false
        }

        GlobalScope.launch(exc) {

            response = withContext(Dispatchers.IO) {
                model.getNumberNotDateInfo(number, MATH_PATH)
            }

            withContext(Dispatchers.Main) {
                if (response != null) {
                    view.setTextInfoAboutNumber(response?.textInfo.orEmpty())
                    view.showSaveBtn(true)
                } else {
                    view.showError()
                }
                progress = false
            }
        }
    }
}