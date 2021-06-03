package com.example.numberfacts.trivia_screen

interface TriviaContractView {
    fun setTextInfoAboutNumber(text: String)
    fun btnSetText(text: Int)
    fun showError()
    fun showProgress(isShow: Boolean)
    fun saveNumberInfo()
    fun showSuccessfulSave()
    fun showSaveBtn(isShow: Boolean)
}