class PizzaNovgorod(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double,
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice
), CheckPhoto, Drink, SauceOption {

    override val saucePriceTomato: Double = 20.0
    override val saucePriceCreamy: Double = 25.0

    override var sauceCountTomato: Int = 0
    override var sauceCountCreamy: Int = 0
    override var revenueFromTomatoSauce: Double = 0.0
    override var revenueFromCreamySauce: Double = 0.0

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            println("Вам будет скидка 40 рублей с покупки")
            totalChecksDisplayed++
            checksWithPhoto++
            totalDiscountAmount += 40.0
        } else {
            totalChecksDisplayed++
        }
    }

    override fun drinkSale() {
        println("Вы будете пить кофе?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            println("С вас 180 рублей")
            totalCoffeesSold++
            totalCoffeeRevenue += 180.0
        } else {
            totalCoffeeRefusals++
        }
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Великом Новгороде")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Великом Новгороде")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Великом Новгороде")
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Великом Новгороде")
    }

    override fun offerSauce() {
        println("Выберите соус:")
        println("1. Томатный ($saucePriceTomato рублей)\n2. Сливочный ($saucePriceCreamy рублей)\n3. Соус не нужен")

        when (readln()) {
            "1" -> {
                sauceCountTomato++
                revenueFromTomatoSauce += saucePriceTomato
            }

            "2" -> {
                sauceCountCreamy++
                revenueFromCreamySauce += saucePriceCreamy
            }
            "3" -> {

            }

            else -> {
                println("Неверный выбор соуса")
            }
        }
        totalSauceRevenue = revenueFromTomatoSauce + revenueFromCreamySauce
    }
}