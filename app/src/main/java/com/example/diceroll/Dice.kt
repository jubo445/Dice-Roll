package com.example.diceroll

class Dice(var numOfDice : Int) {

    fun roll():Int{
        return(1..numOfDice).random()
    }
}