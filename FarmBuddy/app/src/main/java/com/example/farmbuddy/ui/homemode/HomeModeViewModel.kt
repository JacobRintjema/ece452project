package com.example.farmbuddy.ui.homemode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeModeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Home Mode"
    }
    val text: LiveData<String> = _text
}