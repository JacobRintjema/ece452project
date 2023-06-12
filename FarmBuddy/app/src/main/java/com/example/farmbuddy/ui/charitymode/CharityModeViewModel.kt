package com.example.farmbuddy.ui.charitymode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharityModeViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Charity Mode"
    }
    val text: LiveData<String> = _text
}