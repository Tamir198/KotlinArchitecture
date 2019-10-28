package com.kotlin.kotlinarchitecture.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class QuoteFakeDao {
    //Fake Dao (Data Access Objects), in here every database related actions goes here.

    //Fake database, list of Quotes
    private val quotList = mutableListOf<Quote>()
    //Live data to observe database changes + its lifecycle-aware from the architecture component library
    private val quotsLiveData = MutableLiveData<List<Quote>>()

    //The init block is always called after the primary constructor,
    // here we can do things that we cant do inside the primary constructor
    // when the object is being initialized
    init {
        updateLiveData() //To immediately connect the empty quotlist to the live data
    }

    fun addQuot(quote:Quote){
        quotList.add(quote)
        updateLiveData()
    }

    // Casting MutableLiveData to LiveData because its value
    // shouldn't be changed from other classes
    fun getQuot() = quotsLiveData as LiveData<List<Quote>>


    private fun updateLiveData(){
        quotsLiveData.value = quotList
    }


}
