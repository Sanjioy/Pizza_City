abstract class PizzaCity (
    val neapolitanPizzaPrice: Double, val romanPizzaPrice: Double,
    val sicilianPizzaPrice: Double, val tyroleanPizzaPrice: Double
) {
    var neapolitanPizzaCount = 0
        internal set
    var romanPizzaCount = 0
        internal set
    var sicilianPizzaCount = 0
        internal set
    var tyroleanPizzaCount = 0
        internal set

    var totalChecksDisplayed = 0
        internal set
    var checksWithPhoto = 0
        internal set

    var totalDiscountAmount = 0.0
        internal set

    var totalCoffeesSold = 0
        internal set
    var totalCoffeeRefusals = 0
        internal set
    var coffeeWithNeapolitanPizza = 0
        internal set
    var coffeeWithRomanPizza = 0
        internal set
    var coffeeWithSicilianPizza = 0
        internal set
    var coffeeWithTyroleanPizza = 0
        internal set
    var totalCoffeeRevenue = 0.0
        internal set

    open var sauceCountTomato = 0
        internal set
    open var sauceCountCreamy = 0
        internal set
    open var revenueFromTomatoSauce = 0.0
        internal set
    open var revenueFromCreamySauce = 0.0
        internal set
    var totalSauceRevenue = 0.0
        internal set

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()
    abstract fun offerSauce()

    open fun showStatistics() {
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")

        val pizzaRevenue = neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice


        val totalPizzaRevenue = pizzaRevenue - totalDiscountAmount
        val totalRevenue = totalPizzaRevenue + totalCoffeeRevenue

        println("Выручка от продажи пиццы (без скидок): $pizzaRevenue")

        if (totalCoffeesSold > 0) {
            println("Продано кофе: $totalCoffeesSold")
            println("Отказались от кофе: $totalCoffeeRefusals")
            println("Процент отказов от кофе: ${calculatePercentage(totalCoffeeRefusals, totalCoffeesSold)}%")
            println("Общая сумма выручки за кофе: $totalCoffeeRevenue")

            println("Количество кофе с неаполитанской пиццей: $coffeeWithNeapolitanPizza")
            println("Количество кофе с римской пиццей: $coffeeWithRomanPizza")
            println("Количество кофе с сицилийской пиццей: $coffeeWithSicilianPizza")
            println("Количество кофе с тирольской пиццей: $coffeeWithTyroleanPizza")
        }

        if (totalChecksDisplayed > 0) {
            println("Общее количество показанных чеков: $totalChecksDisplayed")
            if (checksWithPhoto > 0) {
                println("Количество чеков с фотографией: $checksWithPhoto")
                println("Процент чеков с фотографией: ${calculatePercentage(checksWithPhoto, totalChecksDisplayed)}%")
            }
        }

        if (sauceCountTomato > 0 || sauceCountCreamy > 0) {
            println("Продано томатного соуса: $sauceCountTomato")
            println("Выручка от томатного соуса: $revenueFromTomatoSauce")

            println("Продано сливочного соуса: $sauceCountCreamy")
            println("Выручка от сливочного соуса: $revenueFromCreamySauce")

            val totalSauceRevenue = revenueFromTomatoSauce + revenueFromCreamySauce
            println("Общая выручка от соусов: $totalSauceRevenue")
        }

        println("Общая сумма скидок: $totalDiscountAmount")

        println("Общая выручка (с учетом скидок и доп.услуг): ${totalRevenue + totalSauceRevenue}")
    }
}

private fun calculatePercentage(part: Int, whole: Int): Double {
    return if (whole != 0) {
        (part.toDouble() / whole.toDouble()) * 100.0
    } else {
        0.0
    }
}