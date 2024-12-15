package com.pawan.quizcomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.AlertDialogDefaults.titleContentColor
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pawan.quizcomposeapp.api.QuizApi
import com.pawan.quizcomposeapp.screens.QuizListScreen
import com.pawan.quizcomposeapp.screens.QuizzesScreen
import com.pawan.quizcomposeapp.ui.theme.QuizComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            QuizComposeAppTheme {

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

                        /* TopAppBar(title = {
                             Text(text = "Quiz App")
                         }, backgroundColor = Color.Blue, contentColor = Color.White)*/

                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        App()
                    }
                }

                //App()
                //QuizListScreen()
                //QuizzesScreen()
            }
        }
    }
}

@Composable
fun App() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "quizzes") {
        composable(route = "quizzes") {

            QuizzesScreen {
                navController.navigate("detail/${it}")
            }
        }

        composable(route = "detail/{category}", arguments = listOf(
            navArgument("category") {
                type = NavType.StringType
            }
        )) {
            QuizListScreen()

        }
    }


}
