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

    private val _textMarket = MutableLiveData<String>().apply {
        value = "St.Jacob's Market"

    }
    val textMarket: LiveData<String> = _textMarket

    private val _textPrice = MutableLiveData<String>().apply {
        value = "$100"

    }
    val textPrice: LiveData<String> = _textPrice

    private val _textWeight = MutableLiveData<String>().apply {
        value = "50 lbs"

    }
    val textWeight: LiveData<String> = _textWeight



    // TODO: Implement the ViewModel
}