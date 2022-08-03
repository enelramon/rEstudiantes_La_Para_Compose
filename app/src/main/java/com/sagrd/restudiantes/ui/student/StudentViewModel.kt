package com.sagrd.restudiantes.ui.student

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagrd.restudiantes.model.Student
import com.sagrd.restudiantes.repository.StudentRepository
import com.sagrd.restudiantes.ui.student_list.StudentListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class StudentViewModel @Inject constructor(
    val repository: StudentRepository
) : ViewModel() {

    var name by mutableStateOf("")
    var semester by mutableStateOf(0)
    var nationality by mutableStateOf("")

    fun Save(){
        viewModelScope.launch {
            repository.insertStudent(
                Student(
                    name = name,
                    semester = semester,
                    nationality = nationality
                )
            )
        }
    }
}