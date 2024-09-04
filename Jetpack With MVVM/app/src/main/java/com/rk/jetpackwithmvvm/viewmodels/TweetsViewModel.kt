package com.rk.jetpackwithmvvm.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rk.jetpackwithmvvm.model.TweetListItem
import com.rk.jetpackwithmvvm.repositories.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetsViewModel @Inject constructor(private val tweetRepository: TweetRepository, private val savedStateHandle: SavedStateHandle) : ViewModel() {
    val tweets: StateFlow<List<TweetListItem>> get() = tweetRepository.tweets

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "android"
            tweetRepository.getTweets(category)
        }
    }
}