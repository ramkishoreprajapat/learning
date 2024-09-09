package com.rk.junittesting

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.rk.junittesting.room.Quote
import com.rk.junittesting.room.QuoteDatabase
import com.rk.junittesting.room.QuotesDao
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class QuotesDaoTest {
    private lateinit var quoteDatabase: QuoteDatabase
    private lateinit var quotesDao: QuotesDao

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()

        quotesDao = quoteDatabase.quoteDao()
    }

    @Test
    fun insertQuote_expectedSingleQuote() = runBlocking {
        val quote = Quote(1, "This is a test quote", "Author")
        quotesDao.insertQuote(quote)

        val result = quotesDao.getQuotes()
        assertEquals(1, result.size)
    }

    @Test
    fun deleteQuote_expectedNoResults() = runBlocking {
        val quote = Quote(1, "This is a test quote", "Author")
        quotesDao.insertQuote(quote)

        val result = quotesDao.getQuotes()
        assertEquals(1, result.size)

        quotesDao.delete()
        val resultAfterDelete = quotesDao.getQuotes()
        assertEquals(0, resultAfterDelete.size)
    }



    @Test
    fun tearDown(){
        quoteDatabase.close()
    }
}