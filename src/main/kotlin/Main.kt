import kotlin.math.min
import kotlin.random.Random

fun main() {
//    Задача 1
    println("\n---Задача 1---")

    fun calculateCommission(amount: Int): Double =
        min(amount * 0.75, 35.0)

    println(calculateCommission(1000))

//    Задача 2
    println("\n---Задача 2---")

    fun showLikeStatistic(likes: Int): String {
        val string = when {
            likes % 10 == 1 && likes % 100 != 11 -> "человеку"
            likes % 100 == 0 && likes % 1000 == 0 -> "людей"
            else -> "людям"
        }

        return "Понравилось $likes $string"
    }

    repeat(10) {
        println(
            showLikeStatistic(Random.nextInt(0, 10000))
        )
    }

//    Задача 3
    println("\n---Задача 3---")

    fun calculateDiscount(purchasePrice: Int, isRegularCustomer: Boolean): Double {
        val discount: Double = when (purchasePrice) {
            in 0..1000 -> 0.0
            in 1001..10000 -> 100.0
            else -> purchasePrice * 0.05
        }

        return (purchasePrice - discount) * if (isRegularCustomer) 0.99 else 1.0
    }

    println(calculateDiscount(1500, true))

}