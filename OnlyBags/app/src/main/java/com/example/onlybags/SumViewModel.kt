package com.example.onlybags

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SumViewModel :ViewModel() {

    private val _sum = MutableLiveData<String>()

    val sum : LiveData<String> get() = _sum

    fun setSum(sum:String){
        _sum.value=sum
    }

}