package com.jeff.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

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
        // 2 dice
        val numDice = 2

        // create dice object with 6 sides (experimenting with Kotlin arrays)
        val dice = Array(numDice) { Dice(6) }

        // roll both dice (using a for loop as practice)
        val rolls = IntArray(numDice)
        for (i in dice.indices) {
            rolls[i] = dice[i].roll()
        }

        // find the ImageView in the layout
        val diceImage1: ImageView = findViewById(R.id.die1)
        val diceImage2: ImageView = findViewById(R.id.die2)

        /*
        determine which drawable to show based on the roll
        haven't really figured out how to make these two iterations with a loop
        because I haven't fully grasped the implementation of Arrays and Lists in Kotlin
         */
        val pic1 = when (rolls[0]) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val pic2 = when (rolls[1]) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // update the ImageView with the correct drawable resource ID
        diceImage1.setImageResource(pic1)
        diceImage2.setImageResource(pic2)

        // update the content description
        diceImage1.contentDescription = rolls[0].toString()
        diceImage2.contentDescription = rolls[1].toString()

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