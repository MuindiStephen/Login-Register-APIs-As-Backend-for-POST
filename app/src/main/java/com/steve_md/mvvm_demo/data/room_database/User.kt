package com.steve_md.mvvm_demo.data.room_database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity(tableName = "user_table")
data class User(
   var id:Int?,
   var firstName: String?,
   var lastName:String?
//@PrimaryKey(autoGenerate = true) var id:Int?,
//@ColumnInfo(name = "first_name") var firstName: String?,
//@ColumnInfo(name = "last_name") var lastName: String?
){
    val uid:Int = CURRENT_USER_ID
}
