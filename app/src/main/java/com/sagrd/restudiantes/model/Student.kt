package com.sagrd.restudiantes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Students" )
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val name: String="",
    val semester: Int=0,
    val nationality: String=""
)
