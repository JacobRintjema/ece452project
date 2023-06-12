package com.example.farmbuddy.ui.farmmode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FarmModeViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Farm Mode"
    }
    val text: LiveData<String> = _text
}