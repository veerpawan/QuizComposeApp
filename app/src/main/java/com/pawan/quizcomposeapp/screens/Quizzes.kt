package com.pawan.quizcomposeapp.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pawan.quizcomposeapp.models.QuizList
import com.pawan.quizcomposeapp.viewmodels.QuizzesViewModel
import com.pawan.quizcomposeapp.R


@Composable
fun QuizzesScreen(onClick: (category: String) -> Unit) {

    val quizzesViewModel: QuizzesViewModel = hiltViewModel()
    val quizList: State<List<QuizList>> = quizzesViewModel.quizList.collectAsState()


    if (quizList.value.isEmpty()) {
        Box(modifier = Modifier.fillMaxWidth(1f), contentAlignment = Alignment.Center) {

            Text(
                text = "Loading...",
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 24.sp)
            )
        }

    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            items(quizList.value) {
                Quizzes(quizList = it, onClick)
            }
        }
    }

}


@Composable
fun Quizzes(quizList: QuizList, onClick: (quizList: String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .clickable {
                onClick(quizList.name.toString())
            }
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .paint(
                painter = painterResource(id = R.drawable.wave_haikei),
                contentScale = ContentScale.Crop
            )
            .border(1.dp, Color(0xFF6200EE)), contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = quizList.name.toString(),
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(0.dp, 20.dp),
            style = MaterialTheme.typography.bodyMedium
        )

    }
}



