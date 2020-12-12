package com.example.numberfacts.searchCategory

class MainMenuPresenter(
    private val view: searchCategoryActivity
) {

    fun clickMainMenuBtn(cls: Class<*>) {
        view.startActivity(cls)
    }
}