package com.example.diceroll

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.example.diceroll.databinding.ActivityMainBinding



var TAG="TAG"

   lateinit var dice: Dice
   lateinit var binding : ActivityMainBinding

   lateinit var profile1 : User
   lateinit var profile2 : MutableList<User>


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        profile2= mutableListOf(
            User("IronMan",R.drawable.ironman),
            User("Shield",R.drawable.shield)
        )


        profile1= User("Captain America",R.drawable.captainamerica)

        setUser()



        dice= Dice(6)



       binding.btnRollProfile1.setOnClickListener {
            Log.i(TAG,"Clicked")

            rollDice()
        }

        binding.btnRollProfile2.setOnClickListener { rollDice() }

        rollDice()
    }


    private fun setUser() {
        binding.profile1.setImageResource(profile1.image)

        val selectUser=(0..2).random()

        binding.profile2.setImageResource(profile2[selectUser].image)
    }

    private fun rollDice(){


        val imgRes= when(dice.roll()){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            6->R.drawable.dice_6

            else -> 0
        }
        binding.diceImg.setImageResource(imgRes)

    }


}