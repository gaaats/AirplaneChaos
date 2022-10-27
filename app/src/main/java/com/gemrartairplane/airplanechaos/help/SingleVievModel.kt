package com.gemrartairplane.airplanechaos.help

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SingleVievModel: ViewModel() {

    private var _isItGood = MutableLiveData<Boolean>()
    val isItGood: LiveData<Boolean>
        get() = _isItGood

    init {
        _isItGood.value = true
    }



}