package com.example.igbo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main)

        // Find the View that shows the numbers category
        val numbers = findViewById<TextView>(R.id.numbers)

        // Set a click listener on that View
        numbers!!.setOnClickListener { // Create a new intent to open the {@link NumbersActivity}
            val numbersIntent = Intent(this@MainActivity, NumbersActivity::class.java)

            Toast.makeText(this, "Numbers button clicked", Toast.LENGTH_SHORT).show()
            // Start the new activity
            startActivity(numbersIntent)
        }

        // Find the View that shows the family category
        val family = findViewById<TextView>(R.id.family)

        // Set a click listener on that View
        family!!.setOnClickListener { // Create a new intent to open the {@link FamilyActivity}
            val familyIntent = Intent(this@MainActivity, FamilyActivity::class.java)

            // Start the new activity
            startActivity(familyIntent)
        }

        // Find the View that shows the colors category
        val colors = findViewById<TextView>(R.id.colors)

        // Set a click listener on that View
        colors!!.setOnClickListener { // Create a new intent to open the {@link ColorsActivity}
            val colorsIntent = Intent(this@MainActivity, ColorsActivity::class.java)

            // Start the new activity
            startActivity(colorsIntent)
        }

        // Find the View that shows the phrases category
        val phrases =  findViewById<TextView>(R.id.phrases)

        // Set a click listener on that View
        phrases!!.setOnClickListener { // Create a new intent to open the {@link PhrasesActivity}
            val phrasesIntent = Intent(this@MainActivity, PhrasesActivity::class.java)

            // Start the new activity
            startActivity(phrasesIntent)
        }
    }
}