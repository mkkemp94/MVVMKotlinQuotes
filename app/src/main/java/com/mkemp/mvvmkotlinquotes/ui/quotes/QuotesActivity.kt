package com.mkemp.mvvmkotlinquotes.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mkemp.mvvmkotlinquotes.R
import com.mkemp.mvvmkotlinquotes.data.Quote
import com.mkemp.mvvmkotlinquotes.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity()
{
    private lateinit var viewModel: QuotesViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        initUI()
    }

    private fun initUI()
    {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
//        val viewModel = ViewModelProviders.of(this, factory)

        viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().also {
            it.observe(this, Observer { quotes: List<Quote> ->
                showQuotes(quotes)
            })
        }

        button_add_quote.setOnClickListener {
            addQuote()
        }
    }

    private fun showQuotes(quotes: List<Quote>)
    {
        val builder = StringBuilder()

        quotes.forEach {quote ->
            builder.append("$quote\n\n")
        }

        textView_quotes.text = builder.toString()
    }

    private fun addQuote()
    {
        val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
        viewModel.addQuote(quote)
        editText_quote.setText("")
        editText_author.setText("")
    }


}
