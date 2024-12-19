package com.pawan.quizcomposeapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pawan.quizcomposeapp.models.QuizUiState
import com.pawan.quizcomposeapp.repository.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizzesViewModel @Inject constructor(private val repository: QuizRepository) :
    ViewModel() {

        val quizUiState: StateFlow<List<QuizUiState>>
            get() = repository.quizzes

    init {

        viewModelScope.launch{
            repository.getQuizzes()
        }
    }
}