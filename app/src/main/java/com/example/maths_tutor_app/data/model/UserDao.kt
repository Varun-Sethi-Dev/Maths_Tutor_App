package com.example.maths_tutor_app.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.maths_tutor_app.data.utils.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT*FROM Users WHERE uId = :id")
    fun getUser(id: Int): Flow<User>

    @Query("SELECT * FROM Users WHERE username=:username AND password = :password")
    fun readLoginData(username: String, password: String): Flow<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUser(user: User)


}