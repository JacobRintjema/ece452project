package com.example.farmbuddy.ui.marketmode

data class ProduceModel(
    var produceTitle: String, // name of produce (apples, bananas)
    var produceQuantity: Int, // quantity in pounds (lbs)
    var produceCost: Double // total price in dollars ($)
)
