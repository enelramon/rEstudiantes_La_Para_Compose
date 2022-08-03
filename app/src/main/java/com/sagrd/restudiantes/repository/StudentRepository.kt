package com.sagrd.restudiantes.repository

import com.sagrd.restudiantes.data.AppDataBase
import com.sagrd.restudiantes.data.dao.StudentDao
import com.sagrd.restudiantes.model.Student
import javax.inject.Inject

class StudentRepository @Inject constructor(
     val db: AppDataBase
) {
    suspend fun insertStudent(student: Student) {
        db.studentDao.insertStudent(student)
    }

    suspend fun updateStudent(student: Student) {
        db.studentDao.updateStudent(student)
    }

    suspend fun deleteStudent(student: Student) {
        db.studentDao.deleteStudent(student)
    }

    fun getStudent(id: Int) = db.studentDao.getStudent(id)

    fun getAll() = db.studentDao.getAll()

}