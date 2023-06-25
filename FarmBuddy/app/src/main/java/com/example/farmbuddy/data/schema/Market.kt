package com.example.farmbuddy.data.schema

import com.google.firebase.firestore.PropertyName

data class Market(
    @get: PropertyName("marketID")
    @set: PropertyName("marketID")
    var marketID: Int? = null,

    @get: PropertyName("marketName")
    @set: PropertyName("marketName")
    var marketName: String? = ""
)
