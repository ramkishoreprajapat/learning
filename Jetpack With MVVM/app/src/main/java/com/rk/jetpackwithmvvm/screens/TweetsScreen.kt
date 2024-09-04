package com.rk.jetpackwithmvvm.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rk.jetpackwithmvvm.viewmodels.TweetsViewModel

@Composable
fun TweetScreen() {
    val tweetsViewModel: TweetsViewModel = hiltViewModel()
    val tweets = tweetsViewModel.tweets.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
       items(tweets.value.size) {
           TweetListItem(tweets = tweets.value[it].tweet)
       }
    }
}

@Composable
fun TweetListItem(tweets: String) {
    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp, horizontal = 16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
    ) {
        Text(text = tweets, modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
@Preview
fun TweetListItemPreview(){
    TweetListItem("Did you know? Honey never spoils. Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3,000 years old! #FunFacts #History")
}