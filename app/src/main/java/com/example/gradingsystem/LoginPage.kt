package com.example.gradingsystem
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.gradingsystem.R

class LoginPage : Fragment(R.layout.page_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val login : Button = view.findViewById(R.id.login)
        val call : MainActivity = getActivity() as MainActivity

        login.setOnClickListener(){
            call.Login()
        }
    }

}