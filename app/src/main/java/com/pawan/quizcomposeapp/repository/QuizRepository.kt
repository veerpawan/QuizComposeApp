package com.pawan.quizcomposeapp.repository

import com.pawan.quizcomposeapp.models.QuizList
import com.pawan.quizcomposeapp.api.QuizApi
import com.pawan.quizcomposeapp.models.QuizListItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class QuizRepository @Inject constructor(private val quizApi: QuizApi) {


    private val _quizzes = MutableStateFlow<List<QuizList>>(emptyList())
    val quizzes: StateFlow<List<QuizList>>
        get() = _quizzes


    private val _quizItem = MutableStateFlow<List<QuizListItems>>(emptyList())
    val quizItem: StateFlow<List<QuizListItems>>
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