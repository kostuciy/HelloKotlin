fun main() {
//    Задание 1
    println("---Задание 1---")

    fun minutesToText(minutes: Int): String =
        when {
            minutes % 10 == 1 && minutes != 11 -> "$minutes минуту назад"
            minutes % 100 in 11..14 -> "$minutes минут назад"
            minutes % 10 in 2..4 -> "$minutes минуты назад"
            else -> "$minutes минут назад"
        }

    fun hoursToText(hours: Int): String =
        when {
            hours % 10 == 1 && hours!= 11 -> "$hours час назад"
            hours % 100 in 11..14 -> "$hours часов назад"
            hours % 10 in 2..4 -> "$hours часа назад"
            else -> "$hours часов назад"
        }

    fun agoToText(secondsAfterExit: Int): String =
        if (secondsAfterExit < 0) "Неверные данные"
        else when (secondsAfterExit) {
            in 0..60 -> "только что"
            in 61..60 * 60 -> minutesToText(secondsAfterExit / 60)
            in 60 * 60 + 1..24 * 60 * 60 -> hoursToText(secondsAfterExit / 3600)
            in 24 * 3600 + 1..2 * 24 * 3600 -> "вчера"
            in 2 * 24 * 3600 + 1..3 * 24 * 3600 -> "позавчера"
            else -> "давно"
        }

    repeat(5) {
        val randomSec = (-1..4 * 24 * 3600).random()
        println("${agoToText(randomSec)} ($randomSec сек.)")
    }

//    Задание 2
    println("\n---Задание 2---")

    fun commissionComplex(
        cardType: CardType,
        amount: Int,
        transferredThisMonth: Int
    ): Double =
        when (cardType) {
            CardType.VK_PAY -> {
                if (
                    transferredThisMonth + amount <= 40_000
                    && amount <= 15_000
                ) 0.0
                else {
                    println("Невозможно осуществить перевод")
                    -1.0
                }
            }

            CardType.VISA, CardType.MIR -> {
                if (
                    amount in 35..150_000
                    && amount + transferredThisMonth <= 600_000
                ) amount * 0.75
                else {
                    println("Невозможно осуществить перевод")
                    -1.0
                }
            }

            CardType.MAESTRO, CardType.MASTERCARD -> {
                if (amount < 75_000) 0.0
                else if (
                    amount <= 150_000
                    && amount + transferredThisMonth <= 600_000
                ) amount * 0.6 + 20
                else {
                    println("Невозможно осуществить перевод")
                    -1.0
                }
            }
        }

    repeat(5) {
        val monthTransactions = (0..600_000).random()
        val cardType = CardType.values().random()
        val amount = (1..160_000).random()

        println("""
            COMMISSION: ${commissionComplex(cardType, amount, monthTransactions)}
            transactions summary during this month: $monthTransactions
            card type: ${cardType.name}
            amount to transfer: $amount
            
        """.trimIndent())
    }
}

enum class CardType {
    VK_PAY, VISA, MIR,
    MASTERCARD, MAESTRO
}