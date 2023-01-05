package com.example.gradingsystem
import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val main = Main()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.FLfragment, main)
            commit()
        }

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
        val content = MyFrag()

        when (item.itemId) {
            R.id.item1 -> supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLfragment, Main())
                commit()
            }
            R.id.subitem1 -> supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLfragment, fragG)
                commit()
            }
            R.id.subitem2 -> supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLfragment, fragR)
                commit()
            }

            R.id.subitem3 -> supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLfragment, content)
                commit()
            }
        }
        return true
    }


    fun InsertCourse(name: String, grade: String) {
        val values = ContentValues()
        values.put(
            Courses.NAME,
            name
        )
        values.put(
            Courses.GRADE,
            grade
        )
        val uri = contentResolver.insert(
            Courses.CONTENT_URI, values
        )
        Toast.makeText(baseContext, uri.toString(), Toast.LENGTH_LONG).show()

    }

    fun UpdateCourse(name: String, grade: String) {
        val values = ContentValues()
        values.put(
            Courses.GRADE,
            grade
        )

        val uri = contentResolver.update(
            Courses.CONTENT_URI, values, "NAME = ?", arrayOf(name)
        )

    }

    fun DeleteCourse(name: String, grade: String) {
        var values = ContentValues()
        val uri = contentResolver.delete(
            Courses.CONTENT_URI, "NAME = ?", arrayOf(name)
        )

    }


    //@SuppressLint("Range")
    fun ShowGrades(name: String,grades: TextView) {
        // Retrieve student records
        val URL = "content://com.example.gradingsystem.Courses"
        val students = Uri.parse(URL)
        val mProjection: Array<String> = arrayOf( Courses.NAME, Courses.GRADE)
            // Courses._ID,
       // val projection = arrayOf("column1", "column2")
        val selection = "NAME = ?"
        val selectionArgs = arrayOf(name)
        //val sortOrder = "column2 DESC"


        //\  val c = contentResolver!!.query(students,null,null,null,"name"
        var c = contentResolver.query(students, mProjection, selection, selectionArgs,null)
        //var c = contentResolver.query(students, null, null, null, null)

        //val //c = managedQuery(students, null, null, null, "name")
        if (c != null && name != "") {
            if (c.moveToFirst()) {
                do {
                    //Toast.makeText(this , c.getString(c.getColumnIndex(Courses.NAME)) + "," + c.getString(c.getColumnIndex(Courses.GRADE)) , Toast.LENGTH_SHORT).show()

                    grades.text =  c.getString(c.getColumnIndex(Courses.NAME)) + ", " + c.getString(c.getColumnIndex(Courses.GRADE))
                   // grades.text =  c.getString(c.getColumnIndex(Courses.NAME)) + ", " + c.getString(c.getColumnIndex(Courses.GRADE))+"\n"

//                    grades.text = text



            } while (c.moveToNext())
        }
    }
        else{
            grades.text = "No Course has been entered"
        }
}
}



