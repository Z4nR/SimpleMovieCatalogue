package com.zulham.filmntv

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FilmViewModel: ViewModel() {
    private val listFilm = MutableLiveData<ArrayList<DataModel>>()
}