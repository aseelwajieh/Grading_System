package com.example.gradingsystem
import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.app.ProgressDialog.show
import android.content.ContentValues
import android.content.Intent
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
        val main = Main()
        val login = LoginPage()
        val register = Registration()


        val intent = Intent(this, LoginPage::class.java)

        when (item.itemId) {
            R.id.item1 -> supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLfragment, main)
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
            R.id.subitem4 -> supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLfragment, register)
                commit()
            }
        }
        return true
    }


    fun InsertCourse(name: String, grade: String , txt : TextView) {
        if (name == "" || grade == "") {
            txt.text = " Please enter the course's name and its grade"
        } else {
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
    }

    fun UpdateCourse(name: String, grade: String, txt : TextView) {
        if (name == "" || grade == "") {
            txt.text = " Please enter the name of the course you want to update"
        } else {
            val values = ContentValues()
            values.put(
                Courses.GRADE,
                grade
            )

            val uri = contentResolver.update(
                Courses.CONTENT_URI, values, "NAME = ?", arrayOf(name)
            )

        }
    }

    fun DeleteCourse(name: String, txt : TextView) {
        if (name == "") {
            txt.text = " Please enter the name of the course you want to delete"
        } else {
            var values = ContentValues()
            val uri = contentResolver.delete(
                Courses.CONTENT_URI, "NAME = ?", arrayOf(name)
            )

        }
    }


    fun ShowGrades(name: String, grades: TextView, txt : TextView) {
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
            txt.text = "No Course has been entered"
        }
    }

    fun Login() {
        val login = Main()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.FLfragment, login)
            commit()

        }


//            val intent = Intent(this, Main::class.java)
//            //intent.putExtra("key", message)
//            startActivity(intent)
//    }
    }

    fun showFirst(firstYear : FirstYear){
        firstYear.show(supportFragmentManager, "FirstYear")


    }


    fun showSecond(secondYear : SecondYear){
        secondYear.show(supportFragmentManager, "SecondYear")


    }

    fun showThird(thirdYear : ThirdYear){
        thirdYear.show(supportFragmentManager, "ThirdYear")


    }
    fun showFourth(fourthYear : FourthYear){
        fourthYear.show(supportFragmentManager, "FourthYear")


    }

    fun showFifth(fifthYear: FifthYear ){
        fifthYear.show(supportFragmentManager, "FifthYear")


    }

}



