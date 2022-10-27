package com.steve_md.mvvm_demo.data.room_database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "user_table")
data class User(
@PrimaryKey(autoGenerate = true) var id:Int?,
@ColumnInfo(name = "first_name") var firstName: String?,
@ColumnInfo(name = "last_name") var lastName: String?
)
