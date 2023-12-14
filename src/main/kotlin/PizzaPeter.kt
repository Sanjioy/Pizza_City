class PizzaPeter(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), Drink {

    override fun drinkSale() {
        println("Вы будете пить кофе?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            println("С вас 200 рублей")
            totalCoffeesSold++
            totalCoffeeRevenue += 200.0

            when {
                neapolitanPizzaCount > 0 -> coffeeWithNeapolitanPizza++
                romanPizzaCount > 0 -> coffeeWithRomanPizza++
                sicilianPizzaCount > 0 -> coffeeWithSicilianPizza++
                tyroleanPizzaCount > 0 -> coffeeWithTyroleanPizza++
            }
        } else {
            totalCoffeeRefusals++
        }
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
    }
    override fun offerSauce() {}
}