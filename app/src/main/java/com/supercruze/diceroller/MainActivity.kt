package com.supercruze.diceroller

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtView : TextView = findViewById(R.id.DiceRollResultTxtView)
        val rollBtn : Button =findViewById(R.id.DiceRollBtn)
         
        val diceObj = Dice(6)
        var numOfClickes : Int = 0
        rollBtn.setOnClickListener {

            txtView.text = diceObj.rollDice()
            numOfClickes++
            Toast.makeText(this,"Dice Rolled "+numOfClickes+" Times",Toast.LENGTH_SHORT).show()
        }
    }
}

class Dice(private val numOfSides : Int)  {

    val diceRange = 1..numOfSides

    
    fun rollDice() : String {
       return diceRange.random().toString()
    }
}