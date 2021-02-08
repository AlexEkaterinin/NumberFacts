package com.example.numberfacts.searchCategory

class SearchCategoryPresenter(
    private val view: SearchCategoryFragment
) {

    fun clickMainMenuBtn(cls: Class<*>) {
        view.startActivity(cls)
    }
}