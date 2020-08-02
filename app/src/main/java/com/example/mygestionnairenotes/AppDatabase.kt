package com.example.mygestionnairenotes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mygestionnairenotes.data.model.StudentEntity
import com.example.mygestionnairenotes.data.model.TeacherEntity
import com.example.mygestionnairenotes.domain.IStudentDao

@Database(entities = arrayOf(StudentEntity::class, TeacherEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): IStudentDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "gestion_notes_db"
            ).build()
            return INSTANCE!!
        }
    }
}