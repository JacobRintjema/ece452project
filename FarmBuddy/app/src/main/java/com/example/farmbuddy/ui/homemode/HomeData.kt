package com.example.farmbuddy.ui.homemode

object HomeData {
    private val home_produce = listOf(
        ProduceModelHome("Apples", 1230),
        ProduceModelHome("Potatoes", 120),
        ProduceModelHome("Tomatoes", 57),
        ProduceModelHome("Bananas", 538),
        ProduceModelHome("Mushrooms", 73),
        ProduceModelHome("Lettuce", 25),
        ProduceModelHome("Avocados", 26),
        ProduceModelHome("Peaches", 100),
        ProduceModelHome("Pineapple", 500),
    )

    val inventory = listOf(InventoryModel("Inventory", home_produce))
}