package com.example.numberfacts.triviaScreen

interface TriviaContractView {
    fun setTextInfoAboutNumber(text: String)
    fun btnSetText(text: Int)
    fun showError()
    fun showProgress(isShow: Boolean)
    fun saveIntoDb()
    fun showSuccessfulSave()
    fun showSaveBtn(isShow: Boolean)
}