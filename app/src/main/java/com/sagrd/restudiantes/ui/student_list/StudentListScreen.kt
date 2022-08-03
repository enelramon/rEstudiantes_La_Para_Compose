package com.sagrd.restudiantes.ui.student_list

import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.hilt.navigation.compose.hiltViewModel
import com.sagrd.restudiantes.model.Student
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentListScreen(
    onClick: () -> Unit,
    viewModel: StudentListViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Student List") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onClick) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add a Student")
            }
        }
    ) {

        val uiState by viewModel.uiState.collectAsState()

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(it)) {

            StudentList(
                students = uiState.students,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }

    }

}



@Composable
fun StudentList(
    students: List<Student>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(students) { student ->
            StudentRow(student)
        }
    }
}

@Composable
fun StudentRow(student: Student) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text = student.name,
            style = MaterialTheme.typography.titleLarge
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = student.nationality)
            Text(
                text = "semester: ${student.semester}"
            )

        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.LightGray
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {
    val lista = listOf(
        Student(
            name = "Nachely",
            semester = 12,
            nationality = "Dominican"
        ),
        Student(
            name = "Kelvin",
            semester = 11,
            nationality = "Dominican"
        )
    )

    StudentList(students = lista)

}