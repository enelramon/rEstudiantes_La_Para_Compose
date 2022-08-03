package com.sagrd.restudiantes.data

import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase
import com.sagrd.restudiantes.data.dao.StudentDao
import com.sagrd.restudiantes.model.Student

@Database(
    entities = [Student::class, Usuario::class, Palabra::class, Practica::class],
    version = 2
)
abstract class AppDataBase : RoomDatabase() {
    abstract val studentDao: StudentDao
}

@Entity(tableName = "Usuarios")
data class Usuario (
    @PrimaryKey(autoGenerate = true)
    val usuarioId : Int = 0,
    val nombres: String,
    val edad : Int
)

@Entity(tableName = "Palabras")
data class Palabra(
    @PrimaryKey(autoGenerate = true)
    val palabraId: Int = 0,
    val palabra: String = "",
    val descripcion: String = "",
    val imagenUrl: String = ""
)
@Entity(tableName = "Practicas")
data class Practica (
    @PrimaryKey(autoGenerate = true)
    val practicaId : Int = 0,/*
    val fecha : Date = Calendar.getInstance().getTime()*/
    val usuarioId : Int = 0,
    val fraseId : Int = 0,
    val vecesPracticado : Int = 0
)
