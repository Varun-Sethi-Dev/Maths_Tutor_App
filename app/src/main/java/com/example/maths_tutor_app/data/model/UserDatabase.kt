package com.example.maths_tutor_app.data.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.maths_tutor_app.data.utils.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        var Instance: UserDatabase? = null
        fun getDatabase(context: Context): UserDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context,UserDatabase::class.java,"user_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        Instance = it
                    }
            }
        }
    }
}