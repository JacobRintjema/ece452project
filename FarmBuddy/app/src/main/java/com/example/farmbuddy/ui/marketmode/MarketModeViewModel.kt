package com.example.farmbuddy.ui.marketmode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MarketModeViewModel : ViewModel() {
    private val _title = MutableLiveData<String>().apply {
        value = "This is Market Mode"
    }
    val title: LiveData<String> = _title


}