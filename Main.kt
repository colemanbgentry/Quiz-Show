// The beginning of everything.
fun main() {
    introductions()
    startWithQuestions()
    generateSpace(1)
    println("You have returned to the beginning!")
}
//The first bit of dialog that the player receives.
fun introductions() {
    generateSpace(1)
    computersConversations(0)
    audienceReaction(0)
}
//To get the game rolling and get the bits of information to start the game.
fun startWithQuestions() {
    val player = PlayerInfo()
    computersConversations(1)
    audienceReaction(0)
    computersConversations(2)
    readLine().toString().also { player.name = it }
    generateSpace(2)
    computersConversations(3)
    println(player.name)
    computersConversations(4)
    audienceReaction(0)
    computersConversations(5)
    computersConversations(6)
    computersConversations(7)
    readLine()!!.toInt().also { player.age = it }
    generateSpace(2)
    computersConversations(8)
    computersConversations(9)
    readLine().toString().also { player.favColor = it }
    generateSpace(2)
    computersConversations(10)
    computersConversations(11)
    readLine().toString().also { player.favAnimal = it }
    generateSpace(2)
    computersConversations(12)
    computersConversations(13)
    audienceReaction(1)
    computerQuestions(player.name, player.age, player.favColor, player.favAnimal)
}
//To establish the numbers and the correct answers from the player previous questions.
fun computerQuestions(name: String, age: Int, favColor: String, favAnimal: String) {
    val nameNumber = name.length
    val ageNumber = age + 10
    val favColorNumber = favColor.length - 3
    val favAnimalNumber = favAnimal.length + 8
    var score = 0
    question(0)
    question(1)
    question(2)
    var answer = readLine()!!.toInt()
    generateSpace(2)
    if (nameNumber == answer) {
        question(3)
    }
    else {
        score += 1
        question(4)
    }
    question(5)
    answer = readLine()!!.toInt()
    generateSpace(2)
    if (ageNumber == answer) {
        question(6)
    }
    else {
        score += 1
        question(7)
    }
    question(8)
    answer = readLine()!!.toInt()
    generateSpace(2)
    if (favColorNumber == answer) {
        question(9)
    }
    else {
        score += 1
        question(10)
    }
    question(11)
    answer = readLine()!!.toInt()
    generateSpace(2)
    if (favAnimalNumber == answer) {
        question(12)
    }
    else {
        score += 1
        question(13)
    }
    finalScore(score)
}
// More talking from the host and getting more information on the questions and response.
fun question(question: Int) {
    when(question){
        0 -> println("Let's begin the quiz show")
        1 -> println("Your score will go up when you get a answer wrong so let's get through this with the least amount alright")
        2 -> println("How many letters are in your name?")
        3 -> println("That's correct!")
        4 -> println("That's incorrect")
        5 -> println("If you aged ten more years from now, how old would you be?")
        6 -> println("That's correct!")
        7 -> println("That's incorrect")
        8 -> println("How many letters are left if you subtract the number of letter of red from your color")
        9 -> println("That's correct!")
        10 -> println("That's incorrect")
        11 -> println("How many letters are in your favorite animal name, plus the number of letters of the biggest land mammal?")
        12 -> println("That's correct!")
        13 -> println("That's incorrect")
    }
    generateSpace(1)
}
//Called by final score just to have the final say from the host.
fun scoring(x: Int) {
    when (x) {
        0 -> println("Perfect score, you are our winner!!!")
        1 -> println("Only missed one, not bad. But we can only have perfection around here.")
        2 -> println("Half the questions wrong, I'm said to say that this wasn't your night.")
        3 -> println("A complete wipe out. You didn't get any questions right.")
    }
    generateSpace(1)
}
//Just to add some noise for the player to have.
fun audienceReaction(reaction: Int) {
    when (reaction) {
        0 -> println("<The audience erupts in applause>")
        1 -> println("<Some in the audience clap>")
        2 -> println("<Nothing comes from the audience>")
        3 -> println("<Some in the audience start to boo>")
        4 -> println("<The audience erupts in disapproval>")
        else -> {
            println("<The audience is bewildered>")
        }
    }
    generateSpace(3)
}
//A place to easily have all the println in one place for each section. I thought this would allow anyone to change text quickly and be able to still get the same effect.
fun computersConversations(conversations: Int) {
    when(conversations) {
        0 -> println("Welcome new player")
        1 -> println("We are all excited to have you here player, but first we should learn your name!")
        2 -> println("So what do you call yourself player? It can be anything you like?")
        3 -> println("The player wishes to be call ... ")
        4 -> println("Let's welcome our newest player")
        5 -> println("We do have a few more questions to ask you for the reminder of the show here.")
        6 -> println("Just three more questions and we will be able to play the game we have for you.")
        7 -> println("First question is a easy one. How old are you?")
        8 -> println("That's a good age you got there, ${PlayerInfo().name}")
        9 -> println("Second question is... What is your favorite color?")
        10 -> println("That's a good color!")
        11 -> println("Third question is... What is your favorite animal?")
        12 -> println("That's definitely a great favorite animal.")
        13 -> println("Alright that's the end of the questions.")
    }
    generateSpace(1)
}
//The final function that is used to commend the player on their hard work or not.
fun finalScore(x: Int) {
    scoring(x)
    if (x == 0) {
        println("You did it, congratulations.")
        generateSpace(1)
        audienceReaction(x)
    } else {
        println("Better luck next time!")
        generateSpace(1)
        audienceReaction(x)
    }
    generateSpace(1)
}
// I always like having a bit of space for my command lines to give them room and allow anyone to read them smoothly.
fun generateSpace(x: Int) {
    if (x == 1) {
        println()
        println(">------------------------------------------------------------------------------------------------^Host<")
        println()
    }
    if (x == 2) {
        println()
        println(">----------------------------------------------------------------------------------------------^Player<")
        println()
    }
    if (x == 3) {
        println()
        println(">--------------------------------------------------------------------------------------------^Audience<")
        println()
    }

}
//This is the player info class, I was going to use it between the functions, but I was unable to find information on how to do that
class PlayerInfo {
    var name = "Player"
    var age = 0
    var favColor = "favColor"
    var favAnimal = "favAnimal"
}