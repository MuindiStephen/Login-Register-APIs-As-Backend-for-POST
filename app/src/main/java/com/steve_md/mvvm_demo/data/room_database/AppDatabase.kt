package com.steve_md.mvvm_demo.data.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(exportSchema = false, version = 1, entities = [User::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getIntance(context: Context): AppDatabase? {
            var instance = INSTANCE

            synchronized(this) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context, AppDatabase::class.java, "user_database").build()  // creates database and initializes it
                    INSTANCE = instance
                }
                return INSTANCE
            }
        }

    }
}