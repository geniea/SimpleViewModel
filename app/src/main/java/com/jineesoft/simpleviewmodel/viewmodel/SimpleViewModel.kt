package com.jineesoft.simpleviewmodel.viewmodel

import androidx.lifecycle.ViewModel

class SimpleViewModel() : ViewModel() {

    var cnt = 0

    override fun onCleared() {
        super.onCleared()
    }
}