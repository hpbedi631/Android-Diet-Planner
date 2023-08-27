package project.n01358063.Harshdeep

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    var timeOfDay = ""
    var food = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var granolacalories: Int = 0
        var fullFatMilk_calories: Int = 0
        var almondMilk_calories: Int = 0
        var strawberryBerryBananaSmoothie_calories: Int = 0
        var pastacalories: Int = 0
        var peanutButterFrenchToastcalories: Int = 0
        var salmoncalories: Int = 0
        var veggieBurgercalories: Int = 0
        var totalCalories: Int


        val intent = getIntent()
        val name = intent.getStringExtra("NAME")
        val goal = intent.getIntExtra("CALORIE", 0)
        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.radBreakfast -> {
                    cbkPasta.isEnabled = false
                    cbkSalmon.isEnabled = false
                    cbkVeggieBurger.isEnabled = false
                    cbkPeanutButterFrenchToast.isEnabled = false
                    Toast.makeText(this, "Selected breakfast", Toast.LENGTH_SHORT).show()
                    timeOfDay = "Breakfast"
                }

                R.id.radLunch -> {
                    cbkGranola.isEnabled = false
                    cbkFullFatMilk.isEnabled = false
                    cbkAlmondMilk.isEnabled = false
                    cbkStrawberryBannanaSmothie.isEnabled = false
                    cbkVeggieBurger.isEnabled = false
                    Toast.makeText(this, "Selected Lunch", Toast.LENGTH_SHORT).show()
                    timeOfDay = "Lunch"
                }
                R.id.radDinner -> {
                    cbkGranola.isEnabled = false
                    cbkFullFatMilk.isEnabled = false
                    cbkAlmondMilk.isEnabled = false
                    cbkStrawberryBannanaSmothie.isEnabled = false
                    cbkSalmon.isEnabled = false
                    cbkPasta.isEnabled = false
                    Toast.makeText(this, "Selected Dinner", Toast.LENGTH_SHORT).show()
                    timeOfDay = "Dinner"
                }
            }
        }
        cbkGranola.setOnCheckedChangeListener { compoundButton, b ->
            if (cbkGranola.isChecked) {
                granolacalories = 350
                food = "Granola"
            } else {
                granolacalories = 0
                food = ""
            }
        }
        cbkFullFatMilk.setOnCheckedChangeListener { compoundButton, b ->
            if (cbkFullFatMilk.isChecked) {
                fullFatMilk_calories = 350
                food = "fullFatMilk"
            } else {
                fullFatMilk_calories = 0
                food = ""
            }
        }
        cbkAlmondMilk.setOnCheckedChangeListener { compoundButton, b ->
            if (cbkAlmondMilk.isChecked) {
                almondMilk_calories = 350
                food = "almondMilk"
            } else {
                almondMilk_calories = 0
                food = ""
            }
        }
        cbkStrawberryBannanaSmothie.setOnCheckedChangeListener { compoundButton, b ->
            if (cbkStrawberryBannanaSmothie.isChecked) {
                strawberryBerryBananaSmoothie_calories = 700
                food = "strawberryBerryBananaSmoothie"
            } else {
                strawberryBerryBananaSmoothie_calories = 0
                food = ""
            }
        }
        cbkPasta.setOnCheckedChangeListener { compoundButton, b ->
            if (cbkPasta.isChecked) {
                pastacalories = 800
                food = "Pasta"
            } else {
                pastacalories = 0
                food = ""
            }
        }
        cbkPeanutButterFrenchToast.setOnCheckedChangeListener { compoundButton, b ->
            if (cbkPeanutButterFrenchToast.isChecked) {
                peanutButterFrenchToastcalories = 350
                food = "peanutButterFrenchToast"
            } else {
                peanutButterFrenchToastcalories = 0
                food = ""
            }
        }
        cbkSalmon.setOnCheckedChangeListener { compoundButton, b ->
            if (cbkSalmon.isChecked) {
                salmoncalories = 200
                food = "Salmon"
            } else {
                salmoncalories = 0
                food = ""
            }
        }
        cbkVeggieBurger.setOnCheckedChangeListener { compoundButton, b ->
            if (cbkVeggieBurger.isChecked) {
                veggieBurgercalories = 600
                food = "Veggie Burger"
            } else {
                veggieBurgercalories = 0
                food = ""
            }
        }

        btnSubmit.setOnClickListener {
            totalCalories =
                granolacalories + fullFatMilk_calories + almondMilk_calories + strawberryBerryBananaSmoothie_calories + pastacalories + peanutButterFrenchToastcalories + salmoncalories + veggieBurgercalories
            txtResult.text =
                "Hello " + name + " You have consumed these " + totalCalories + " many calories"
            if (goal <= totalCalories) {
                Toast.makeText(this, "You are within your Calorie range", Toast.LENGTH_SHORT).show()
            } else if (goal >= totalCalories) {
                Toast.makeText(this, "You are not within your calorie range", Toast.LENGTH_SHORT)
                    .show()
            }

            val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
            intent.putExtra("TOTAL CALORIES", totalCalories)
            intent.putExtra("FOOD", food)
            intent.putExtra("TIME OF DAY", timeOfDay)
            startActivity(intent)
        }
        btnHelp.setOnClickListener {
            val intent = Intent(this@SecondActivity, FourthActivity::class.java)
            startActivity(intent)
        }

    }
}
