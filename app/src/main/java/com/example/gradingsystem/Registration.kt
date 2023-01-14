package com.example.gradingsystem

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

class Registration : Fragment(R.layout.registration) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val firstBtn : TextView = view.findViewById(R.id.btFirst)
        firstBtn.setOnClickListener{
            val first = FirstYear()
            val call : MainActivity = getActivity() as MainActivity
            call.showFirst(first)
        }
        val secondBtn : TextView = view.findViewById(R.id.btSecond)
        secondBtn.setOnClickListener{
            val second = SecondYear()
            val call : MainActivity = getActivity() as MainActivity
            call.showSecond(second)
        }
        val thirdBtn : TextView = view.findViewById(R.id.btThird)
        thirdBtn.setOnClickListener{
            val third = ThirdYear()
            val call : MainActivity = getActivity() as MainActivity
            call.showThird(third)
        }
        val FourthBtn : TextView = view.findViewById(R.id.btFourth)
        FourthBtn.setOnClickListener{
            val fourth = FourthYear()
            val call : MainActivity = getActivity() as MainActivity
            call.showFourth(fourth)
        }
        val fifthBtn : TextView = view.findViewById(R.id.btFifth)
        fifthBtn.setOnClickListener{
            val fifth = FifthYear()
            val call : MainActivity = getActivity() as MainActivity
            call.showFifth(fifth)        }
    }


}