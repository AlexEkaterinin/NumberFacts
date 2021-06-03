package com.example.numberfacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.numberfacts.saved_facts.SavedFactsFragment
import com.example.numberfacts.search_category.SearchCategoryFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private val searchCategoryFragment = SearchCategoryFragment()
    private val savedFactsFragment = SavedFactsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentsContainer, searchCategoryFragment)
            .add(R.id.fragmentsContainer, savedFactsFragment)
            .commit()

        bottomNavigation.setOnNavigationItemSelectedListener(navListener)
        bottomNavigation.selectedItemId = R.id.numbers_category
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.numbers_category -> {
                supportFragmentManager.beginTransaction()
                    .hide(savedFactsFragment)
                    .show(searchCategoryFragment)
                    .commit()
                true
            }
            R.id.saved_facts -> {
                supportFragmentManager.beginTransaction()
                    .hide(searchCategoryFragment)
                    .show(savedFactsFragment)
                    .commit()
                true
            }
            else -> false
        }
    }
}