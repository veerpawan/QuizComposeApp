package com.pawan.quizcomposeapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pawan.quizcomposeapp.models.QuizList
import com.pawan.quizcomposeapp.models.QuizListItems
import com.pawan.quizcomposeapp.viewmodels.QuizListItemsViewModel
import java.nio.file.WatchEvent


@Composable
fun QuizListScreen() {
    val quizListItemsViewModel: QuizListItemsViewModel = hiltViewModel()
    val quizListItems: State<List<QuizListItems>> = quizListItemsViewModel.quizListItems.collectAsState()

    LazyColumn(content = {
        items(quizListItems.value) {
            QuizList(quizListItems = it)
        }
    })
}

@Composable
fun QuizList(quizListItems: QuizListItems) {

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
        content = {
            Text(
                text = quizListItems.question.toString(),
                modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.bodyMedium
            )
        }

    )

}