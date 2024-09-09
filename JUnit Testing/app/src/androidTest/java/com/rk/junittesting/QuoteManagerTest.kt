package com.rk.junittesting

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
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
                Quote("This is quote 1", "1"),
                Quote("This is quote 2", "2"),
                Quote("This is quote 3", "3"),
                )
        )

        //Act
        val quote = quoteManager.getPreviousQuote()
        //Assert
        assertEquals("1", quote.author)

    }

    @Test
    fun testNextQuote_expected_CorrectQuote() {
        //Arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote("This is quote 1", "1"),
                Quote("This is quote 2", "2"),
                Quote("This is quote 3", "3"),
            )
        )

        //Act
        val quote = quoteManager.getNextQuote()
        //Assert
        assertEquals("2", quote.author)

    }
}