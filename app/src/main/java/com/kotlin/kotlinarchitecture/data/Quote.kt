package com.kotlin.kotlinarchitecture.data

data class Quote(val quotText:String, val author:String){
    //This is Quote data class for the list of the quotes

    override fun toString(): String {
        return "$quotText - $author"
    }
}