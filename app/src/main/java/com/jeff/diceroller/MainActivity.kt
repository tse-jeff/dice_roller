package com.jeff.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

//import android.widget.Toast

/**
 * This activity allows the user to roll a die and view the result
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // adds an event listener for a roll button
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // random roll when app starts
        rollDice()
    }

    /**
     * The rollDice function creates a Dice object of 6 sides and adds
     * the result to the textView.
     */
    private fun rollDice() {
        // create dice object with 6 sides
        val dice = Dice(6)
        val roll = dice.roll()

        // find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // determine which drawable to show based on the roll
        val drawableResource = when (roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // update the content description
        diceImage.contentDescription = roll.toString()

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