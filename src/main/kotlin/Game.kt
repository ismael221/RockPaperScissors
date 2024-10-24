package org.ismael

import java.util.*

fun main(args: Array<String>){
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice,gameChoice)
}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String{
    var isValidChoice = false
    var userChoice = ""
    while (!isValidChoice){
        print("Please enter one of the following:")
        for (item in optionsParam) print(" $item")
        println(".")
        val userInput = readLine()?.capitalize()

        if (userInput != null && userInput in optionsParam){
            isValidChoice = true
            userChoice = userInput.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }

        if (!isValidChoice) println("You must enter a valid choice.")
    }

    return userChoice

}

fun printResult(userChoice: String, gameChoice: String){
    val result: String
    if (userChoice == gameChoice) result = "Tie!"
      else if((userChoice == "Rock" && gameChoice == "Scissors")
          || (userChoice == "Paper" && gameChoice == "Rock")
            || (userChoice == "Scissors" && gameChoice == "Paper")) result  = "You win"
      else result = "You lose!"
    println("You chooose $userChoice. I chose $gameChoice. $result")
}