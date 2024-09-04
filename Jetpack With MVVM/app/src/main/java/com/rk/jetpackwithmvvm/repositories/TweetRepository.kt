package com.rk.jetpackwithmvvm.repositories

import com.rk.jetpackwithmvvm.api.TweetsApi
import com.rk.jetpackwithmvvm.model.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsApi: TweetsApi) {
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories get() = _categories.asStateFlow()

    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets get() = _tweets.asStateFlow()

    suspend fun getTweets(category: String) {
        val response = tweetsApi.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }

    suspend fun getCategories() {
        val response = tweetsApi.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

}