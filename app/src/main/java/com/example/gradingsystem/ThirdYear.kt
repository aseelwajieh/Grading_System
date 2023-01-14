package com.example.gradingsystem
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.DialogFragment

class ThirdYear : DialogFragment(R.layout.year_third){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val okBtn: Button = view.findViewById(R.id.OKBtn);

        okBtn.setOnClickListener {
            dismiss()
        }

    }
}