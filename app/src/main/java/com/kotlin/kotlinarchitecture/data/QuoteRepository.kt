package com.kotlin.kotlinarchitecture.data

class QuoteRepository private constructor(private val quotDao: QuoteFakeDao) {

    //the repository is to mediate between the data and the view models


    //just like in the data access object - set and get quotes:
    fun addQuot(qout:Quote){
        //adds a quot to the Dao
        quotDao.addQuot(qout)

    }

    //Return the live data
    fun getQuots()= quotDao.getQuot()

    companion object {
        @Volatile
        private var instance: QuoteRepository? = null

        fun getInstance(quotDao: QuoteFakeDao) =
        // If instantiated return the instance
            // Otherwise instantiate in a thread-safe manner
            instance ?: synchronized(this) {
                // If it's still not instantiated, finally create an object
                // also set the "instance" property to be the currently created one
                instance ?: QuoteRepository(quotDao).also { instance = it }
            }
    }
}