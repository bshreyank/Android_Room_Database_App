package com.example.roomappstevdzasan.data

import User
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) // If there is same user again we are going to ignore that!
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query(value = "SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>
}