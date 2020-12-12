package com.example.numberfacts.searchCategory

class MainMenuPresenter(
    private val view: SearchCategoryFragment
) {

    fun clickMainMenuBtn(cls: Class<*>) {
        view.startActivity(cls)
    }
}