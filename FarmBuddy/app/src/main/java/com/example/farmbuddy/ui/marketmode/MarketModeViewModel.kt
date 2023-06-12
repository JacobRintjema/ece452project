package com.example.farmbuddy.ui.marketmode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MarketModeViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Market Mode"
    }
    val text: LiveData<String> = _text
}