package com.pawan.quizcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.pawan.quizcomposeapp.screens.onboarding.OnboardingUtils
import com.pawan.quizcomposeapp.ui.theme.QuizComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val onboardingUtils by lazy { OnboardingUtils(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        //enableEdgeToEdge()

        setContent {
            QuizComposeAppTheme {


                Navigation()

                /*if (onboardingUtils.isOnboardingCompleted()) {
                    ShowHomeScreen()
                } else {
                    ShowOnboardingScreen(onboardingUtils)

                }
*/

            }
        }
    }
}



@Composable
private fun ShowOnboardingScreen(onboardingUtils: OnboardingUtils) {
    val scope = rememberCoroutineScope()




}

