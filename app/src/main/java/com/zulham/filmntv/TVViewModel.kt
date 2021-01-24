package com.zulham.filmntv

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TVViewModel: ViewModel() {
    private val listTV = MutableLiveData<ArrayList<DataModel>>()
}