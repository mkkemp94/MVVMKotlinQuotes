package com.mkemp.mvvmkotlinquotes.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mkemp.mvvmkotlinquotes.R

class QuotesActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
    }
}
