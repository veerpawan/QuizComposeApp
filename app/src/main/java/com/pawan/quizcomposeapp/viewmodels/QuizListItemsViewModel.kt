package com.pawan.quizcomposeapp.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pawan.quizcomposeapp.models.QuizItemsUiState
import com.pawan.quizcomposeapp.repository.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizListItemsViewModel @Inject constructor(
    private val repository: QuizRepository,
    private val savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    val quizItemsUiState: StateFlow<List<QuizItemsUiState>>
        get() = repository.quizItem

    init {

        viewModelScope.launch {
            val category  = savedStateHandle.get<String>("category") ?: "WordPress"
            repository.getQuizItem(category)
        }
    }
}