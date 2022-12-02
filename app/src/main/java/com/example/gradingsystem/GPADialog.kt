package com.example.gradingsystem

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.gradingsystem.R

class GPADialog : DialogFragment(R.layout.dialog_gpa) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cancelbtn : Button = view.findViewById(R.id.cancel)
        val calc: Button = view.findViewById(R.id.calc);
        val courses: EditText = view.findViewById(R.id.course);
        val sum: EditText = view.findViewById(R.id.grades);
        val result: TextView = view.findViewById(R.id.result)
        cancelbtn.setOnClickListener {
            dismiss()
        }

        calc.setOnClickListener {
            var course: Int = courses.text.toString().toInt();
            var sum: Int = sum.text.toString().toInt()
            result.text = "Your GPA is : "+calculate(course, sum).toString();
        }




        }


    public fun calculate(x : Int , y :Int): Float {

        return y.toFloat()/x.toFloat() ;


    }
    }



