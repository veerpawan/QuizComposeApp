package com.pawan.quizcomposeapp.screens

import androidx.compose.foundation.BorderStroke
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
import com.pawan.quizcomposeapp.models.QuizItemsUiState
import com.pawan.quizcomposeapp.viewmodels.QuizListItemsViewModel


@Composable
fun QuizListScreen() {
    val quizListItemsViewModel: QuizListItemsViewModel = hiltViewModel()
    val quizItemsUiState: State<List<QuizItemsUiState>> = quizListItemsViewModel.quizItemsUiState.collectAsState()

    LazyColumn(content = {
        items(quizItemsUiState.value) {
            QuizList(quizItemsUiState = it)
        }
    })
}

@Composable
fun QuizList(quizItemsUiState: QuizItemsUiState) {

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
        content = {
            Text(
                text = quizItemsUiState.question.toString(),
                modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.bodyMedium
            )
        }

    )

}