package com.example.farmbuddy.data.schema
import com.google.firebase.Timestamp
import com.google.firebase.firestore.PropertyName

data class LiveProduct(
    @get: PropertyName("liveProductID")
    @set: PropertyName("liveProductID")
    var liveProductID: Int? = null,

    @get: PropertyName("product")
    @set: PropertyName("product")
    var product: Product? = null,

    @get: PropertyName("datePosted")
    @set: PropertyName("datePosted")
    var datePosted: Timestamp? = null,

    @get: PropertyName("market")
    @set: PropertyName("market")
    var market: Market? = null
)
