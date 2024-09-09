package com.rk.junittesting.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuotesDao {
    @Insert
    suspend fun insertQuote(quote: Quote)

    @Update
    suspend fun updateQuote(quote: Quote)

    @Query("DELETE FROM quote")
    suspend fun delete()

    @Query("SELECT * FROM quote")
    suspend fun getQuotes(): List<Quote>

    @Query("SELECT * FROM quote WHERE id = :quoteId")
    suspend fun getQuoteById(quoteId: Int): Quote

}