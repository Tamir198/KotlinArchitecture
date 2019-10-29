package com.kotlin.kotlinarchitecture.data

//primary private constructor so it wont be accessible from other classes
class FakeDatabase private constructor() {
    //In real app I will have more than 1 DAO so this is where I put all of them In one place

    //This class will be singleton because I only want one database instance every time:

    //Dao for example that will go here
    var quoteDAO = QuoteFakeDao()

    companion object {
        // @Volatile - Writes to this property are immediately visible to other threads
        @Volatile
        private var instance: FakeDatabase? = null
        // The only way to get hold of the FakeDatabase object

        fun getInstance() =
        // If instantiated return the instance
            // Otherwise instantiate in a thread-safe manner
            instance ?: synchronized(this) {
                // If it's still not instantiated, finally create an object
                // also set the "instance" property to be the currently created one
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}


