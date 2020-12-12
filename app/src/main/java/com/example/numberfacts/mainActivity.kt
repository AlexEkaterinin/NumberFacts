package com.example.numberfacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.numberfacts.saved_facts.SavedFactsFragment
import com.example.numberfacts.searchCategory.SearchCategoryFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentsContainer, SearchCategoryFragment()).commit()

        bottomNavigation.setOnNavigationItemSelectedListener(navListener)
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.numbers_category -> {
                val fragment = SearchCategoryFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentsContainer, fragment).commit()
                true
            }
            R.id.saved_facts -> {
                val fragment = SavedFactsFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentsContainer, fragment).commit()
                true
            }
            else -> false
        }
    }
}