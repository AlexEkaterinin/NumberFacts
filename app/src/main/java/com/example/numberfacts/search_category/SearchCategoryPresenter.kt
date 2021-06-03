package com.example.numberfacts.search_category

class SearchCategoryPresenter(
    private val view: SearchCategoryFragment
) {

    fun clickMainMenuBtn(cls: Class<*>) {
        view.startActivity(cls)
    }
}