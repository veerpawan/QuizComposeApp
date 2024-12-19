package com.pawan.quizcomposeapp.screens.onboarding

import androidx.annotation.DrawableRes
import com.pawan.quizcomposeapp.R


sealed class OnboardingModel(
    @DrawableRes val image: Int,
    val title: String,
    val description: String,
) {

    data object FirstPage : OnboardingModel(
        image = R.drawable.img_into_1,
        title = "Your Quiz Partner",
        description = "Play as many quiz as you want, anywhere you want"
    )

    data object SecondPage : OnboardingModel(
        image = R.drawable.img_into_2,
        title = "Your Personal TechStack",
        description = "Play Quizes in different ways, make your own TechStack"
    )

    data object ThirdPages : OnboardingModel(
        image = R.drawable.img_into_3,
        title = "Search and Filter",
        description = "Get any quiz you want within a simple search across your device"
    )


}