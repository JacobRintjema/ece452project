package com.example.farmbuddy.ui.productview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is product view"
    }
    val text: LiveData<String> = _text
    // TODO: Implement the ViewModel
}