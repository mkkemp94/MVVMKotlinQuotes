package com.mkemp.mvvmkotlinquotes.data

/**
 * Constructor parameters are public but immutable.
 */
data class Quote(val quoteText: String,
                 val author: String)
{
    override fun toString(): String
    {
        return "$quoteText = $author"
    }
}