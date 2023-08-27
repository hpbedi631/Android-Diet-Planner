package project.n01358063.Harshdeep

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_third.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class ThirdActivity : AppCompatActivity() {
    private lateinit var mDb: DietHistoryDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val intent = getIntent()
        val food = intent.getStringExtra("FOOD")
        val timeOfDay = intent.getStringExtra("TIME OF DAY")
        val goal = intent.getIntExtra("TOTAL CALORIES", 0)

        // Initialize Room Database
        mDb = DietHistoryDatabase.getInstance(applicationContext)

        // Make the text view scrollable
        val mytext1 = findViewById<TextView>(R.id.textView13)
        val mytext2 = findViewById<TextView>(R.id.textView14)
        val mytext3 = findViewById<TextView>(R.id.textView15)

        mytext1.movementMethod = ScrollingMovementMethod()
        mytext2.movementMethod = ScrollingMovementMethod()
        mytext3.movementMethod = ScrollingMovementMethod()

        val goals = listOf(goal)
        val foods = listOf(food)
        val timeOfDays = listOf(timeOfDay)

        val insert = findViewById<Button>(R.id.btnInsert)

        insert.setOnClickListener {
            val dietRecord =
                DietHistory(0, timeOfDays.toString(), foods.toString(), goals.toString())

            doAsync {
                mDb.dietHistoryDao().insert(dietRecord)

                uiThread {
                    toast("record inserted")
                }
            }
        }
        val select = findViewById<Button>(R.id.btnSelect)

        select.setOnClickListener {
            doAsync {
                val list = mDb.dietHistoryDao().getAll()

                uiThread {
                    toast("${list.size} records found")
                    for (dietRecord in list)
                        mytext1.append("${dietRecord.timeOfDay} : ${dietRecord.Food} : ${dietRecord.calorieCount}\n")
                }
            }
        }
        val update = findViewById<Button>(R.id.btnUpdate)

        update.setOnClickListener {
            doAsync {
                //   val list = mDb.dietHistoryDao().update()

                uiThread {
                    //   toast("$list record updated")
                }
            }
        }

        val delete = findViewById<Button>(R.id.btnDelete)

        delete.setOnClickListener {
            doAsync {
                mDb.dietHistoryDao().delete()

                uiThread {
                    toast("record deleted")
                }
            }

        }
        btnHelp.setOnClickListener {
            val intent = Intent(this@ThirdActivity, FourthActivity::class.java)
            startActivity(intent)
        }
    }
}

