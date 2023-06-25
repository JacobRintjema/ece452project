package com.example.farmbuddy.data

import android.util.Log
import com.example.farmbuddy.data.interfaces.ITransaction
import com.example.farmbuddy.data.schema.Transaction
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

open class TransactionDBHandler : ITransaction {
    // Firestore logic
    private val uid = FirebaseAuth.getInstance().currentUser?.uid.toString()
    private val root = FirebaseFirestore.getInstance()
    private val transactionCollection = root.collection("transaction")

    override fun getTransaction(callback: (MutableList<Transaction>?) -> Unit) {
        transactionCollection.document(uid).collection("transactions").get()
            .addOnSuccessListener { result ->
                if (result != null) {
                    val response: MutableList<Transaction> = mutableListOf<Transaction>()
                    for (document in result) {
                        Log.d("getTransaction()", "ID: ${document.id} data: ${document.data}")
                        val t = deserializeTransaction(document)
                        if (t != null) {
                            response.add(t)
                        }
                    }
                    callback(response)
                } else {
                    Log.d("getInventory()", "No such document")
                    callback(null)
                }
            }
            .addOnFailureListener { exception ->
                Log.w("getInventory()", "Error getting documents.", exception)
            }
    }

    override fun upsertTransaction(transaction: Transaction) {
        val transactionRef = transactionCollection.document(uid).collection("transactions")
        transactionRef.document(transaction.transactionID.toString()).set(transaction).addOnSuccessListener {
            Log.d("addTransaction()", "DocumentSnapshot added transaction $transaction.product.productID")
        }
            .addOnFailureListener {e ->
                Log.w("addTransaction()", "Error adding document", e)
            }
    }

    private fun deserializeTransaction(ds: DocumentSnapshot): Transaction? {
        val tr : Transaction? = ds.toObject(Transaction::class.java)
        Log.d("deserializeTransaction()", "transaction: $tr")
        return tr
    }
}