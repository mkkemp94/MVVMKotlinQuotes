package com.mkemp.mvvmkotlinquotes.data

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao)
{
    fun addQuote(quote: Quote)
    {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object
    {
        /**
         * Current instance. Writes to this property are immediately visible to other threads.
         */
        @Volatile
        private var instance: QuoteRepository? = null

        /**
         * If instance is not null, return the instance.
         *
         * If it is null, call synchronized() with this companion object as the lock object.
         * Two threads cannot be executing this at the same time.
         */
        fun getInstance(quoteDao: FakeQuoteDao) = instance ?: synchronized(this)
        {
            /**
             * If instance is not null, return the instance.
             *
             * Otherwise return a new [QuoteRepository] and set the instance to this new object.
             */
            instance ?: QuoteRepository(quoteDao).also { instance = it }
        }
    }
}
