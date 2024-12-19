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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pawan.quizcomposeapp.api.QuizApi
import com.pawan.quizcomposeapp.screens.QuizListScreen
import com.pawan.quizcomposeapp.screens.QuizzesScreen
import com.pawan.quizcomposeapp.screens.onboarding.OnboardingScreen
import com.pawan.quizcomposeapp.screens.onboarding.OnboardingUtils
import com.pawan.quizcomposeapp.ui.theme.QuizComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val onboardingUtils by lazy { OnboardingUtils(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        //enableEdgeToEdge()

        setContent {
            QuizComposeAppTheme {




                /*if (onboardingUtils.isOnboardingCompleted()) {
                    ShowHomeScreen()
                } else {
                    ShowOnboardingScreen(onboardingUtils)

                }
*/
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

            }
        }
    }
}



@Composable
private fun ShowOnboardingScreen(onboardingUtils: OnboardingUtils) {
    val scope = rememberCoroutineScope()


    OnboardingScreen {
        onboardingUtils.setOnboardingCompleted()
        scope.launch {


        }
    }


}



@Composable
fun App() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "OnBoardingScreen") {


        composable(route = "OnBoardingScreen"){
            OnboardingScreen{
                navController.navigate("quizzes")
            }
        }

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
