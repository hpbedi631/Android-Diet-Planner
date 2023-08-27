package project.n01358063.Harshdeep

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FourthActivity : AppCompatActivity() {
    lateinit var output: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        output = findViewById(R.id.textview22)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    fun msgShow(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    // actions on click menu items
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.action_search -> {
            output.text = "search..."
            msgShow("Search")
            true
        }
        R.id.action_help -> {
            output.text =
                "The name of my project is DietPlanner Final Project. In order to use this project you will enter your name and calorie goal in the first activity and you" +
                        " will click the confirm button, which will redirect you to the second page if you have entered the correct input otherwise you will have to fill it in again. Once you" +
                        " are on the second page you will be asked what time of the day you are consuming the meal and what dishes are you consuming. After receiving your input when you click the " +
                        "submit button the program will calculate the total calories consumed by you and display them. After all that is done your history will be saved in the databases" +
                        ", which can be manipulated like Insert, Select, Update, and Delete."

            msgShow("Help")
            true
        }
        R.id.action_about -> {
            output.text =
                "Hi, my name is Harshdeep Bedi and my student number is N01358063, I am enrolled in Computer Programming course at Humber Collage making this program as a part of my final project." +
                        " The submission date for this project is December 8, 2020 at 6pm."
            msgShow("About")
            true
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }

    }
}


