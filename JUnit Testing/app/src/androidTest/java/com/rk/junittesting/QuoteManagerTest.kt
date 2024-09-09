package com.rk.junittesting

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import com.rk.junittesting.room.Quote
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

    @Test(expected = FileNotFoundException::class)//Assert
    fun populateQuoteFromAssets() {
        //Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        //Act
        quoteManager.populateQuoteFromAssets(context, "")
        //Assert
    }

    @Test(expected = JsonSyntaxException::class)//Assert
    fun populateQuoteFromAssets_InvalidJson_expected_Exception() {
        //Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        //Act
        quoteManager.populateQuoteFromAssets(context, "malformed.json")
        //Assert
    }

    @Test
    fun populateQuoteFromAssets_ValidJson_expected_Count() {
        //Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        //Act
        quoteManager.populateQuoteFromAssets(context, "quotes.json")
        //Assert
        assertEquals(10, quoteManager.quoteList.size)
    }

    @Test
    fun testPreviousQuote_expected_CorrectQuote() {
        //Arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote(1,"This is quote 1", "smith"),
                Quote(2,"This is quote 2", "john"),
                Quote(3,"This is quote 3", "rock"),
                )
        )

        //Act
        val quote = quoteManager.getPreviousQuote()
        //Assert
        assertEquals(1, quote.id)

    }

    @Test
    fun testNextQuote_expected_CorrectQuote() {
        //Arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote(1,"This is quote 1", "smith"),
                Quote(2,"This is quote 2", "john"),
                Quote(3,"This is quote 3", "rock"),
            )
        )

        //Act
        val quote = quoteManager.getNextQuote()
        //Assert
        assertEquals(2, quote.id)

    }
}