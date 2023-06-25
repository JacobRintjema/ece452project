package com.example.farmbuddy.data.schema
import com.google.firebase.firestore.PropertyName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    @get: PropertyName("productID")
    @set: PropertyName("productID")
    var productID: Int? = null,

    @get: PropertyName("productName")
    @set: PropertyName("productName")
    var productName: String? = "",

    @get: PropertyName("quantity")
    @set: PropertyName("quantity")
    var quantity: Int? = null,

    @get: PropertyName("unit")
    @set: PropertyName("unit")
    var unit: String? = ""
)
