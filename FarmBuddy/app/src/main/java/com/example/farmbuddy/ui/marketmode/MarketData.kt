package com.example.farmbuddy.ui.marketmode

object MarketData {
    private val market1_produce = listOf(
        ProduceModel("Apples", 30, 29.99),
        ProduceModel("Potatoes", 120, 129.99),
        ProduceModel("Tomatoes", 57, 35.47),
        ProduceModel("Bananas", 233, 535.29),
        ProduceModel("Mushrooms", 73, 99.99)
    )

    private val market2_produce = listOf(
        ProduceModel("Lettuce", 25, 4.56),
        ProduceModel("Avocados", 26, 9.99),
        ProduceModel("Peaches", 100, 39.99),
    )

    private val market3_produce = listOf(
        ProduceModel("Pineapple", 500, 399.99),
        ProduceModel("Apples", 1200, 599.99),
        ProduceModel("Bananas", 305, 705.29),
    )

    val markets = listOf(
        MarketModel("St. Jacobs Market", market1_produce),
        MarketModel("Farmer's Market", market2_produce),
        MarketModel("McDonald's", market3_produce)
    )
}