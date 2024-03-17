package com.example.maths_tutor_app.data.repository

import com.example.maths_tutor_app.data.utils.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(id:Int): Flow<User>
    fun readLoginData(username:String,password:String):Flow<User>

    suspend fun addUser(user: User)

    suspend fun deleteUser(user:User)

    suspend fun updateUser(user: User)

}