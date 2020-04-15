package com.mkemp.mvvmkotlinquotes.data

/**
 * To put all the Daos in one place
 *
 * Singleton
 *
 * Primary constructor is private
 *
 * This is  how to create singletons if you would need something passed in the constructor.
 */
class FakeDatabase private constructor()
{
    /**
     * Data access object (Dao)
     *
     * Can set this only from the FaceDatabase class.
     */
    var quoteDao = FakeQuoteDao()
        private set

    companion object
    {
        /**
         * Current instance. Writes to this property are immediately visible to other threads.
         */
        @Volatile
        private var instance: FakeDatabase? = null

        /**
         * If instance is not null, return the instance.
         *
         * If it is null, call synchronized() with this companion object as the lock object.
         * Two threads cannot be executing this at the same time.
         */
        fun getInstance() = instance ?: synchronized(this)
        {
            /**
             * If instance is not null, return the instance.
             *
             * Otherwise return a new [FakeDatabase] and set the instance to this new object.
             */
            instance ?: FakeDatabase().also { instance = it }
        }
    }
}