package com.example.gradingsystem
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager


class RatingDialog : DialogFragment(R.layout.dialog_rating) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cancelbtn : Button = view.findViewById(R.id.cancelbtn)
        val submitbt: Button = view.findViewById(R.id.gbtn);
        val radioGroup = view.findViewById<RadioGroup>(R.id.group)
        val txt : TextView = view.findViewById(R.id.descriptive)
        cancelbtn.setOnClickListener {
            dismiss()
        }
        submitbt.setOnClickListener {
            val selectedOption: Int = radioGroup.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedOption)
            when(radioButton.id){
                R.id.grade1 -> txt.text = "Rating is: Excellent"
                R.id.grade2-> txt.text = "Rating is: Very Good"
                R.id.grade3-> txt.text = "Rating is: Good"
                R.id.grade4-> txt.text = "Rating is: satisfactory"
                R.id.grade5-> txt.text = "Rating is: Fail"
            }
        }


        }

}
