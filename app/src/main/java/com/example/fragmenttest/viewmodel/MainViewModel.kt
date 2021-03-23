package com.example.fragmenttest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _textCount: MutableLiveData<Int> = MutableLiveData(0)
    val textCount: LiveData<Int> = _textCount

    fun incrementCount() {
        _textCount.value = _textCount.value?.plus(1)
    }
}