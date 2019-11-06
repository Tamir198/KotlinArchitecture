package com.kotlin.kotlinarchitecture.ui

import androidx.lifecycle.ViewModel
import com.kotlin.kotlinarchitecture.data.Quote
import com.kotlin.kotlinarchitecture.data.QuoteRepository

class QuotViewModel(private val quoteRepository:QuoteRepository) : ViewModel() {
    //class to update quot in the repository
    

    //this view model class is not inside the activity life cycle
    // so this way my data will get saved even on orientation change (AKA configuration change  )

    //calling the quoteRepository methods
    fun getQuote() =quoteRepository.getQuots()
    fun addQuot(quot:Quote) = quoteRepository.addQuot(quot)
}