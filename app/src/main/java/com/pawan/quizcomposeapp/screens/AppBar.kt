package com.pawan.quizcomposeapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pawan.quizcomposeapp.Navigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    Scaffold(
        topBar = {

            TopAppBar(
                title = {
                    Text(text = "Quiz App")
                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )

        }
    ) {



       Box(modifier = Modifier.padding(it)) {
            //Navigation()
        }
    }
}