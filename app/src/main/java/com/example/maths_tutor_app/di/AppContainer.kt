package com.example.maths_tutor_app.di

import android.content.Context
import com.example.maths_tutor_app.data.model.UserDatabase
import com.example.maths_tutor_app.data.repository.OfflineUserRepository
import com.example.maths_tutor_app.data.repository.UserRepository

interface AppContainer {
    val userDatabaseRepository: UserRepository
}

class AppDataContainer(context: Context) : AppContainer {
    override val userDatabaseRepository by lazy {
        OfflineUserRepository(
            userDao = UserDatabase.getDatabase(context).userDao()
        )
    }
}