package com.example.farmbuddy.data

import android.util.Log
import com.example.farmbuddy.data.interfaces.IUser
import com.example.farmbuddy.data.schema.LiveProduct
import com.example.farmbuddy.data.schema.Product
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore


open class UserDBHandler : IUser {
    // Firestore logic
    private val uid = FirebaseAuth.getInstance().currentUser?.uid.toString()
    private val root = FirebaseFirestore.getInstance()
    private val userCollection = root.collection("user")

    override fun addUser() {
        TODO("Not yet implemented")
    }

    override fun getUser() {
        TODO("Not yet implemented")
    }

    override fun getInventory(callback: (MutableList<Product>?) -> Unit) {
        userCollection.document(uid).collection("inventory").get()
            .addOnSuccessListener { result ->
                if (result != null) {
                    val response: MutableList<Product> = mutableListOf<Product>()
                    for (document in result) {
                        Log.d("getInventory()", "ID: ${document.id} data: ${document.data}")
                        val p = deserializeProduct(document)
                        if (p != null) {
                            response.add(p)
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

    override fun upsertInventory(product: Product) {
        val inventoryRef = userCollection.document(uid).collection("inventory")
        inventoryRef.document(product.productID.toString()).set(product).addOnSuccessListener {
            Log.d("addInventory()", "DocumentSnapshot added product $product.productID")
        }
        .addOnFailureListener {e ->
            Log.w("addInventory()", "Error adding document", e)
        }
    }

    override fun getLiveMarket(callback: (MutableList<LiveProduct>?) -> Unit) {
        userCollection.document(uid).collection("livemarket").get()
            .addOnSuccessListener { result ->
                if (result != null) {
                    val response: MutableList<LiveProduct> = mutableListOf()
                    for (document in result) {
                        Log.d("getLiveMarket()", "ID: ${document.id} data: ${document.data}")
                        val p = deserializeLiveProduct(document)
                        if (p != null) {
                            response.add(p)
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

    override fun upsertLiveMarket(liveProduct: LiveProduct) {
        val liveMarketRef = userCollection.document(uid).collection("livemarket")
        liveMarketRef.document(liveProduct.liveProductID.toString()).set(liveProduct).addOnSuccessListener {
            Log.d("addLiveMarket()", "DocumentSnapshot added liveproduct ${liveProduct.liveProductID}")
        }
        .addOnFailureListener {e ->
            Log.w("addLiveMarket()", "Error adding document", e)
        }
    }

    private fun deserializeProduct(ds: DocumentSnapshot): Product? {
        val pr : Product? = ds.toObject(Product::class.java)
        Log.d("deserializeProduct()", "product: $pr")
        return pr
    }

    private fun deserializeLiveProduct(ds: DocumentSnapshot): LiveProduct? {
        val lp : LiveProduct? = ds.toObject(LiveProduct::class.java)
        Log.d("deserializeLiveProduct()", "liveproduct: $lp")
        return lp
    }
}