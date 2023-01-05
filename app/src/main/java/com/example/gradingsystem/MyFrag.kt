package com.example.gradingsystem
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment

class MyFrag : Fragment(R.layout.frag_my) {
    //call func
//    private var resolver = requireActivity().contentResolver
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val call : MainActivity = getActivity() as MainActivity
        val insert: Button = view.findViewById(R.id.insert)
        val update: Button = view.findViewById(R.id.update)
        val delete: Button = view.findViewById(R.id.delete)
        val show: Button = view.findViewById(R.id.retrive)
        val name : EditText = view.findViewById(R.id.name)
        val grade : EditText = view.findViewById(R.id.grade)
        val grades : TextView = view.findViewById(R.id.data)

        insert.setOnClickListener() {
            call.InsertCourse(name.text.toString(),grade.text.toString()) }


        update.setOnClickListener() {
            call.UpdateCourse(name.text.toString(),grade.text.toString()) }

        delete.setOnClickListener() {
            call.DeleteCourse(name.text.toString(),grade.text.toString()) }

        show.setOnClickListener(){
            call.ShowGrades(name.text.toString(),grades)
        }




    }

}