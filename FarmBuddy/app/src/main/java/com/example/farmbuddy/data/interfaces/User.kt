package com.example.farmbuddy.data.interfaces

import com.example.farmbuddy.data.schema.LiveProduct
import com.example.farmbuddy.data.schema.Product

interface IUser {
    fun addUser()
    fun getUser()
    fun getInventory(callback: (MutableList<Product>?) -> Unit)
    fun upsertInventory(product: Product)
    fun getLiveMarket(callback: (MutableList<LiveProduct>?) -> Unit)
    fun upsertLiveMarket(liveProduct: LiveProduct)
}