package com.example.numberfacts.mainMenu

class MainMenuPresenter(
    private val view: MainMenuContractView
) {

    fun clickMainMenuBtn(cls: Class<*>) {
        view.startActivity(cls)
    }
}