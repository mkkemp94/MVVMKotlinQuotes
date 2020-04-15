package com.mkemp.mvvmkotlinquotes.ui.quotes

import androidx.lifecycle.ViewModel
import com.mkemp.mvvmkotlinquotes.data.Quote
import com.mkemp.mvvmkotlinquotes.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel()
{
    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}