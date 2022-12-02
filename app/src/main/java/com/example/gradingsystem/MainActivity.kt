package com.example.gradingsystem

import android.os.Build
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.gradingsystem.GPADialog
import com.example.gradingsystem.R
import android.view.MenuInflater as MenuInflater1
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.app_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val fragG = GPADialog()
        val fragR = RatingDialog()

        when (item.itemId) {
            R.id.item1 -> Toast.makeText(this, "item 1 selected", Toast.LENGTH_SHORT).show()
            R.id.subitem1 -> fragG.show(supportFragmentManager,"Calculate GPA")
            R.id.subitem2 -> fragR.show(supportFragmentManager,"Show Rating")
        }
        return true;
    }


}


