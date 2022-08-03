package com.sagrd.restudiantes.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sagrd.restudiantes.model.Student
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {
    @Insert
    suspend fun insertStudent(student: Student)

    @Update
    suspend fun updateStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)

    @Query("SELECT * FROM Students WHERE id = :id")
    fun getStudent(id: Int): Flow<Student>

    @Query("SELECT * FROM Students")
    fun getAll(): Flow<List<Student>>
}