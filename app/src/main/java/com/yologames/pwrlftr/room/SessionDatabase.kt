package com.yologames.pwrlftr.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Session::class], version = 3)
abstract class SessionDatabase : RoomDatabase() {
    abstract fun sessionDao(): SessionDao
}
