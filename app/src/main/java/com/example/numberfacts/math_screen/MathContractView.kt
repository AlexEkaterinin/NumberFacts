package com.example.numberfacts.math_screen

interface MathContractView {
    fun setTextInfoAboutNumber(text: String)
    fun btnSetText(text: Int)
    fun showError()
    fun showProgress(isShow: Boolean)
    fun saveIntoDb()
    fun showSuccessfulSave()
    fun showSaveBtn(isShow: Boolean)
}