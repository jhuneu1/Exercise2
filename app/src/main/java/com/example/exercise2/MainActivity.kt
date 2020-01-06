package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private var totalBMI: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            displayBMI()
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            resetAttributes()
        }
    }

    private fun displayBMI() {
        val bmi = findViewById<TextView>(R.id.textViewBMI)

        calcBMI()
        if (totalBMI < 18.5) {
            imageViewProfile.setImageResource(R.drawable.under)
        } else if (totalBMI >= 18.5 && totalBMI <= 24.9) {
            imageViewProfile.setImageResource(R.drawable.normal)
        } else {
            imageViewProfile.setImageResource(R.drawable.over)
        }
        totalBMI.toString()
        bmi.text = "BMI= " + String.format("%.2f", totalBMI)
    }

    private fun calcBMI() {
        val weight = findViewById<EditText>(R.id.editTextWeight)
        val height = findViewById<EditText>(R.id.editTextHeight)
        val weightString = weight.text.toString()
        val weightDouble = weightString.toDouble()
        val heightString = height.text.toString()
        val heightDouble = heightString.toDouble() / 100

        totalBMI = weightDouble / heightDouble.pow(2)
    }

    private fun resetAttributes(){
        val weight = findViewById<EditText>(R.id.editTextWeight)
        val height = findViewById<EditText>(R.id.editTextHeight)

        weight.text.clear()
        height.text.clear()
        imageViewProfile.setImageResource(R.drawable.empty)
    }
}