package com.example.onlybags

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelExample :ViewModel(){

    companion object{
        const val DOLLAR_TO_SHEKEL_RATE=3.75
    }

    val result = MutableLiveData<Double>()

    fun setValue(value:Double){
        result.value=value* DOLLAR_TO_SHEKEL_RATE
    }
}