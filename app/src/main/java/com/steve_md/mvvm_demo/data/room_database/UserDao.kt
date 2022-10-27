package com.steve_md.mvvm_demo.data.room_database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query


@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
   fun upsert(user:User) : Long    // insert and update operations

   @Query("SELECT * FROM user_table")
   fun getUser() : LiveData<User>
}