package com.example.maths_tutor_app.data.repository

import com.example.maths_tutor_app.data.model.UserDao
import com.example.maths_tutor_app.data.utils.User
import kotlinx.coroutines.flow.Flow

class OfflineUserRepository(private val userDao: UserDao) : UserRepository {
    override fun getUser(id: Int): Flow<User> = userDao.getUser(id)

    override fun readLoginData(username: String, password: String): Flow<User> =
        userDao.readLoginData(username, password)

    override suspend fun addUser(user: User) = userDao.addUser(user)

    override suspend fun deleteUser(user: User) = userDao.deleteUser(user)

    override suspend fun updateUser(user: User) = userDao.updateUser(user)

}