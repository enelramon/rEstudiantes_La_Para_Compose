package com.sagrd.restudiantes.util

sealed class Screen(val route: String){
    object StudentListScreen: Screen("StudentList")
    object StudentScreen: Screen("Student")
}