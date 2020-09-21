package com.example.numberfacts.mainMenu

import android.service.voice.VoiceInteractionSession
import com.example.numberfacts.TriviaActivity

class MainMenuPresenter(
    private val view: MainMenuContractView
) {

    fun clickMainMenuBtn(cls: Class<*>) {
        view.startActivity(cls)
    }
}