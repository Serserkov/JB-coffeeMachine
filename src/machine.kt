package machine
import java.util.Scanner

class coffeMachines (var water: Int, var milk: Int, var cofBeans: Int, var cups: Int, var money: Int) {
    val scan = Scanner(System.`in`)
    fun status() {
        println("")
        println("The coffee machine has:")
        println("$water of water")
        println("$milk of milk")
        println("$cofBeans of coffee beans")
        println("$cups of disposable cups")
        println("$money of money")
        println("")
    }
    fun fill(addWater: Int, addMilk: Int, addCofBeans: Int, addCups: Int) {
        water += addWater
        milk += addMilk
        cofBeans += addCofBeans
        cups += addCups
    }
    fun take() {
        println("")
        println("I gave you $money")
        money = 0
        println("")
    }
    fun buy(usedWater: Int, usedMilk: Int, usedCofBeans: Int, usedCups: Int, usedMoney: Int) {
        if (water >= usedWater && milk >= usedMilk && cofBeans >= usedCofBeans && cups >= usedCups) {
            println("I have enough resources, making you a coffee!")
            water -= usedWater
            milk -= usedMilk
            cofBeans -= usedCofBeans
            cups -= usedCups
            money += usedMoney
        }
        else {
            println( when {
                water < usedWater -> "Sorry, not enough water!"
                milk < usedMilk ->  "Sorry, not enough milk!"
                cofBeans < usedCofBeans -> "Sorry, not enough coffee beans!"
                cups < usedCups -> "Sorry, not enough cups!"
                else -> "Impossible!"
            })
        }
        println("")
    }
}

fun main() {
    val scan = Scanner(System.`in`)
    var coffeMachine = coffeMachines(400, 540, 120, 9, 550)
    var action = "start"
    while (action != "exit") {
        print("Write action (buy, fill, take, remaining, exit): ")
        action = scan.nextLine()
        when (action) {
            "take" -> coffeMachine.take()
            "fill" -> {
                println("")
                print("Write how many ml of water do you want to add: ")
                val addWater = scan.nextLine().toInt()
                print("Write how many ml of milk do you want to add: ")
                val addMilk = scan.nextLine().toInt()
                print("Write how many grams of coffee beans do you want to add: ")
                val addCofBeans = scan.nextLine().toInt()
                print("Write how many disposable cups of coffee do you want to add: ")
                val addCups = scan.nextLine().toInt()
                println("")
                coffeMachine.fill(addWater, addMilk, addCofBeans, addCups)
            }
            "buy" -> {
                println("")
                print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
                when (scan.nextLine())  {
                    "1" -> coffeMachine.buy(250, 0, 16, 1, 4)
                    "2" -> coffeMachine.buy(350, 75, 20, 1, 7)
                    "3" -> coffeMachine.buy(200, 100, 12, 1, 6)
                }
            }
            "remaining" -> coffeMachine.status()
        }
    }
}
