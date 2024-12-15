package com.pawan.quizcomposeapp.api

import com.pawan.quizcomposeapp.models.QuizList
import com.pawan.quizcomposeapp.models.QuizListItems
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizApi {

    @GET("/api/v1/categories?apiKey=nIEY5rDAGzpCGnVHM9hduvWhHfBYaGxcojYW0VX2")
    suspend fun getQuizCategories(): Response<List<QuizList>>

    @GET("/api/v1/questions?apiKey=nIEY5rDAGzpCGnVHM9hduvWhHfBYaGxcojYW0VX2")
    suspend fun getQuizItems(@Query("category") category: String, @Query("limit") limit: Int = 20):  Response<List<QuizListItems>>
}