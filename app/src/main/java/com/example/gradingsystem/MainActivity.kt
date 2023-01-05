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
        val main = LoginPage()

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
        val login = LoginPage()

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

            R.id.item4 -> supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLfragment, login)
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


    fun ShowGrades(name: String, grades: TextView) {
        // Retrieve student records
        val URL = "content://com.example.gradingsystem.Courses"
        val students = Uri.parse(URL)
        val mProjection: Array<String> = arrayOf(Courses.NAME, Courses.GRADE)
        val selection = "NAME = ?"
        val selectionArgs = arrayOf(name)
        var c = contentResolver.query(students, mProjection, selection, selectionArgs, null)
        if (c != null && name != "") {

            if (c.moveToFirst()) {
                do {
                    grades.text = c.getString(c.getColumnIndex(Courses.NAME)) + ", " + c.getString(
                        c.getColumnIndex(Courses.GRADE)
                    )


                } while (c.moveToNext())
            }
        } else {
            grades.text = "No Course has been entered"
        }
    }

    fun Login() {
        val login = Main()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.FLfragment, login)
            commit()

        }
    }
}



