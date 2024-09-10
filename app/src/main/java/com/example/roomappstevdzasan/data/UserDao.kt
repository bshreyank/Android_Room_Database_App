package com.example.roomappstevdzasan.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomappstevdzasan.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) // If there is same user again we are going to ignore that!
    suspend fun addUser(user: User)

    @Query(value = "SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>
}