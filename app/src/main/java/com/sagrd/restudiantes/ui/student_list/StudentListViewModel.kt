package com.sagrd.restudiantes.ui.student_list

import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagrd.restudiantes.model.Student
import com.sagrd.restudiantes.repository.StudentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class StudentListUiState(
    val students: List<Student> = emptyList(),
    val texto: String = "Meeting"
)

@HiltViewModel
class StudentListViewModel @Inject constructor(
    val repository: StudentRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(StudentListUiState())
    val uiState: StateFlow<StudentListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAll().collect { list ->
                _uiState.update {
                    it.copy( students = list )
                }
            }
        }
    }
}
