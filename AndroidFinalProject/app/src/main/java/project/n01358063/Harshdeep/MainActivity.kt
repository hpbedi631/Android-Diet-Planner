package project.n01358063.Harshdeep

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calorieGoal = arrayOf(
            "1000 cal",
            "1200 cal",
            "1400 cal",
            "1600 cal",
            "1800 cal",
            "2000 cal",
            "2200 cal",
            "2400 cal",
            "2600 cal",
            "2800 cal",
            "3000 cal"
        )
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, calorieGoal)
        // attached arrayAdapter to spinner
        spinner.adapter = arrayAdapter

        val pref = getPreferences(Context.MODE_PRIVATE)
        val name = pref.getString("NAME", "")
        val calorieIndex = pref.getInt("CALORIE", 0)
        txtName.setText(name)
        spinner.setSelection(calorieIndex)
        btnHelp.setOnClickListener {
            val intent = Intent(this@MainActivity, FourthActivity::class.java)
            startActivity(intent)
        }

    }


    fun OnConfirm(view: View) {
        if (txtName.text.toString() != "") {
            val name = txtName.text.toString()
            Toast.makeText(this, "You are being redirected to a new page", Toast.LENGTH_LONG).show()
            // create shared preferences file
            val pref = getPreferences(Context.MODE_PRIVATE)
            val editor = pref.edit()

            // save name
            editor.putString("NAME", txtName.text.toString())
            // save Calorie
            editor.putInt("CALORIE", spinner.selectedItemPosition)
            // commit changes
            editor.commit()
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("NAME", name)
            intent.putExtra("CALORIE", spinner.selectedItemPosition)
            startActivity(intent)

        } else {
            Toast.makeText(this, "Please fill in your name", Toast.LENGTH_LONG).show()
        }

    }

}