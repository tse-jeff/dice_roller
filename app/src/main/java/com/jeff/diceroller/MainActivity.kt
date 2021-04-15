package com.jeff.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
//import android.widget.Toast

/**
 * This activity allows the user to roll a die and view the result
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * The rollDice function creates a Dice object of 6 sides and adds
     * the result to the textView.
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

//        This follow line allows for a pop up on the bottom of the screen
//        that shows a text.
//        Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
    }
}

/**
 * The Dice class has sides and a function to roll and return a random
 * number within the range.
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}