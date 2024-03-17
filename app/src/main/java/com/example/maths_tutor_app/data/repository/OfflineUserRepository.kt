package com.example.maths_tutor_app.data.repository

import com.example.maths_tutor_app.data.model.UserDao
import com.example.maths_tutor_app.data.utils.User
import kotlinx.coroutines.flow.Flow

class OfflineUserRepository(private val userDao: UserDao) : UserRepository {
    override fun getUser(id: Int): Flow<User> {
        TODO("Not yet implemented")
    }

    override fun readLoginData(username: String, password: String): Flow<User> {
        TODO("Not yet implemented")
    }

    override suspend fun addUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(user: User) {
        TODO("Not yet implemented")
    }

}