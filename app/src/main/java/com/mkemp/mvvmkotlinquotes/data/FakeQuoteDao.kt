package com.mkemp.mvvmkotlinquotes.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao
{
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init
    {
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote)
    {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    /**
     * Cast [quotes] to LiveData so that it cannot be changed outside of here.
     */
    fun getQuotes() = quotes as LiveData<List<Quote>>
}