package com.example.farmbuddy.ui.productview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Carrots"

    }
    val text: LiveData<String> = _text

    private val _textQuantity = MutableLiveData<String>().apply {
        value = "10"

    }
    val textQuantity: LiveData<String> = _textQuantity

    private val _textUnits = MutableLiveData<String>().apply {
        value = "lbs"

    }
    val textUnits: LiveData<String> = _textUnits

    // TODO: Implement the ViewModel
}