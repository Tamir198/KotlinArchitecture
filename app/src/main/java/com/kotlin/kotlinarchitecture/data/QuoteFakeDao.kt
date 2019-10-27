package com.kotlin.kotlinarchitecture.data

import androidx.lifecycle.MutableLiveData

class QuoteFakeDao {
    //Fake Dao (Data Access Objects), in here every database related actions goes here.

    //Fake database, list of Quotes
    private val quotList = mutableListOf<Quote>()
    //Live data to observe database changes + its lifecycle-aware
    private val quotsLiveData = MutableLiveData<>
}