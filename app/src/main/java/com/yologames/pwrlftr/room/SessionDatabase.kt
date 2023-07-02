package com.yologames.pwrlftr.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Session::class], version = 4)
abstract class SessionDatabase : RoomDatabase() {
    abstract fun sessionDao(): SessionDao
}
