package com.example.gradingsystem

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment

class FirstYear : DialogFragment(R.layout.year_first) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val okBtn: Button = view.findViewById(R.id.OKBtn);

        okBtn.setOnClickListener {
            dismiss()
        }

    }
}