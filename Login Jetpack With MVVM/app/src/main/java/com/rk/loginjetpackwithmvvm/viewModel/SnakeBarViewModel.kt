package com.rk.loginjetpackwithmvvm.viewModel

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.rk.loginjetpackwithmvvm.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SnakeBarViewModel @Inject constructor() : ViewModel() {
    private val _messageIds: MutableStateFlow<List<Int>> = MutableStateFlow(emptyList())
    val messageIds: StateFlow<List<Int>> = _messageIds.asStateFlow()

    fun showUserMessage(@StringRes messageId: Int) {
        _messageIds.update { currentMessageIds ->
            currentMessageIds + messageId
        }
    }

//    init {
//        showViewModelMessage()
//    }

    private fun showViewModelMessage() {
        _messageIds.update { currentMessageIds ->
            currentMessageIds +     R.string.viewmodel_message
        }
    }

    fun setMessageShown(@StringRes messageId: Int) {
        _messageIds.update { currentMessageIds ->
            currentMessageIds.filter { it != messageId }
        }
    }
}