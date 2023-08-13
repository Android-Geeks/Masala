package com.example.masala_food_recipes


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search,menu)
        val search=menu?.findItem(R.id.search)
        val searchView=search?.actionView as SearchView
        searchView.queryHint="@string/hinted_search_text"

        return super.onCreateOptionsMenu(menu)
    }
}