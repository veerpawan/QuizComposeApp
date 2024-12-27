package com.pawan.quizcomposeapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pawan.quizcomposeapp.screens.QuizListScreen
import com.pawan.quizcomposeapp.screens.QuizzesScreen
import com.pawan.quizcomposeapp.screens.onboarding.OnboardingScreen
import androidx.navigation.compose.NavHost
import com.pawan.quizcomposeapp.screens.LoginScreen


@Composable
fun Navigation() {


    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "OnBoardingScreen") {


        composable(route = "OnBoardingScreen") {
            OnboardingScreen(navController)
        }

        composable(route = "LoginScreen") {
            LoginScreen(navController)
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