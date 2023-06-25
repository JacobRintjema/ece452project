package com.example.farmbuddy.data.interfaces

import com.example.farmbuddy.data.schema.Transaction

interface ITransaction {
    fun getTransaction(callback: (MutableList<Transaction>?) -> Unit)
    fun upsertTransaction(transaction: Transaction)
}