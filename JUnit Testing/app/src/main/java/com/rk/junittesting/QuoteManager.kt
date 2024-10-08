package com.rk.junittesting

import android.content.Context
import com.google.gson.Gson
import com.rk.junittesting.room.Quote

class QuoteManager {
    var quoteList = emptyArray<Quote>()
    private var currentQuoteIndex = 0

    fun populateQuoteFromAssets(context: Context, fileName: String) {
        val inputStream = context.assets.open(fileName)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quoteList = gson.fromJson(json, Array<Quote>::class.java)
    }

    fun populateQuotes(quotes: Array<Quote>) {
        quoteList = quotes
    }

    fun getCurrentQuote(): Quote {
     return quoteList[currentQuoteIndex]
    }

    fun getNextQuote(): Quote {
        if (currentQuoteIndex == quoteList.size - 1) return quoteList[currentQuoteIndex]
        return quoteList[++currentQuoteIndex]
    }

    fun getPreviousQuote(): Quote {
        if (currentQuoteIndex == 0) return quoteList[currentQuoteIndex]
        return quoteList[--currentQuoteIndex]
    }
}