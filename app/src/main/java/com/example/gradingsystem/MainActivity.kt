package com.example.gradingsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rating:TextView = findViewById(R.id.descriptive)
        var flag : String = "Select your grade range"
        val spinnerVals : Spinner = findViewById(R.id.rating)
        var options = arrayOf("Select your grade range","100 - 85","84 - 75","74 - 65","64 - 50","less than 50")
        spinnerVals.adapter =
            ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        spinnerVals.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                       TODO("Not yet implemented")
            }

            }

        val button : Button = findViewById(R.id.gbtn)
        button.setOnClickListener{
            when(flag){
                "100 - 85"-> rating.text = "Rating is: Excellent"
                "84 - 75"-> rating.text = "Rating is: Very Good"
                "74 - 65"-> rating.text = "Rating is: Good"
                "64 - 50"-> rating.text = "Rating is: satisfactory"
                "less than 50"-> rating.text = "Rating is: Fail"

            }
        }
    }



    }
