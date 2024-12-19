package com.pawan.quizcomposeapp.repository

import com.pawan.quizcomposeapp.models.QuizUiState
import com.pawan.quizcomposeapp.api.QuizApi
import com.pawan.quizcomposeapp.models.QuizItemsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class QuizRepository @Inject constructor(private val quizApi: QuizApi) {


    private val _quizzes = MutableStateFlow<List<QuizUiState>>(emptyList())
    val quizzes: StateFlow<List<QuizUiState>>
        get() = _quizzes


    private val _quizItem = MutableStateFlow<List<QuizItemsUiState>>(emptyList())
    val quizItem: StateFlow<List<QuizItemsUiState>>
        get() = _quizItem


    suspend fun getQuizzes() {

        val response = quizApi.getQuizCategories()
        if (response.isSuccessful && response.body() != null) {
            _quizzes.emit(response.body()!!)
        }
    }

    suspend fun getQuizItem(category: String) {

        val response = quizApi.getQuizItems(category)
        if (response.isSuccessful && response.body() != null) {
            _quizItem.emit(response.body()!!)

        }
    }
}