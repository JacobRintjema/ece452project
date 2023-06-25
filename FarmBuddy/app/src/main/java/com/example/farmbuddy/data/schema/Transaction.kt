package com.example.farmbuddy.data.schema

import com.google.firebase.Timestamp
import com.google.firebase.firestore.PropertyName

data class Transaction(
    @get: PropertyName("transactionID")
    @set: PropertyName("transactionID")
    var transactionID: Int? = null,

    @get: PropertyName("datePosted")
    @set: PropertyName("datePosted")
    var datePosted: Timestamp? = null,

    @get: PropertyName("dateSold")
    @set: PropertyName("dateSold")
    var dateSold: Timestamp? = null,

    @get: PropertyName("product")
    @set: PropertyName("product")
    var product: Product? = null,

    @get: PropertyName("market")
    @set: PropertyName("market")
    var market: Market? = null,
)
