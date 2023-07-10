package com.supercruze.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val diceImageView: ImageView = findViewById(R.id.diceImageView)
        val rollBtn: Button = findViewById(R.id.DiceRollBtn)

        val diceObj = Dice(6)
        var numOfClickes = 0
        var rollResult: Int
        rollBtn.setOnClickListener {

            rollResult = diceObj.rollDice()
            numOfClickes++
            Toast.makeText(this, "Dice Rolled " + numOfClickes + " Times", Toast.LENGTH_SHORT)
                .show()
            when (rollResult) {

                1 -> diceImageView.setImageResource(R.drawable.dice_1)
                2 -> diceImageView.setImageResource(R.drawable.dice_2)
                3 -> diceImageView.setImageResource(R.drawable.dice_3)
                4 -> diceImageView.setImageResource(R.drawable.dice_4)
                5 -> diceImageView.setImageResource(R.drawable.dice_5)
                6 -> diceImageView.setImageResource(R.drawable.dice_6)
            }
            diceImageView.contentDescription = rollResult.toString()
        }
    }
}

class Dice(numOfSides: Int) {

    val diceRange = 1..numOfSides


    fun rollDice(): Int {
        return diceRange.random()
    }
}