package com.example.numberfacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.*
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnMath: Button
    lateinit var btnTrivia: Button
    lateinit var btnDate: Button
    lateinit var btnYear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        btnMath = findViewById(R.id.btnMath)
        btnMath.setOnClickListener(this)

        btnTrivia = findViewById(R.id.btnTrivia)
        btnTrivia.setOnClickListener(this)

        btnDate = findViewById(R.id.btnDate)
        btnDate.setOnClickListener(this)

        btnYear = findViewById(R.id.btnYear)
        btnYear.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnMath -> {
                val intent: Intent = Intent(this, MathActivity::class.java)
                startActivity(intent)
            }
            R.id.btnTrivia -> {
                val intent: Intent = Intent(this, TriviaActivity::class.java)
                startActivity(intent)
            }
            R.id.btnDate -> {
                val intent: Intent = Intent(this, DateActivity::class.java)
                startActivity(intent)
            }
            R.id.btnYear -> {
                val intent: Intent = Intent(this, YearActivity::class.java)
                startActivity(intent)
            }
        }
    }
}