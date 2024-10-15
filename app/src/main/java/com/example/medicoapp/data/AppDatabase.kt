package com.example.medicoapp.data


import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(entities = [Medico::class, Cita::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun medicoDao(): MedicoDao
    abstract fun citaDao(): CitaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "medico_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
