package com.mkemp.mvvmkotlinquotes.utilities

import com.mkemp.mvvmkotlinquotes.data.FakeDatabase
import com.mkemp.mvvmkotlinquotes.data.QuoteRepository
import com.mkemp.mvvmkotlinquotes.ui.quotes.QuotesViewModelFactory

object InjectorUtils
{
    /**
     * All dependencies for QuotesViewModelFactory handled here
     */
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory
    {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}