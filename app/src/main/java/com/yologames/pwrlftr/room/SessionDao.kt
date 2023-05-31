package com.yologames.pwrlftr.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SessionDao {
    @Insert
    suspend fun insertSession(session: Session)

    @Query("SELECT * FROM session_table")
    fun getAllSessions(): List<Session>

    @Update
    suspend fun updateSession(session: Session)

    @Delete
    suspend fun deleteSession(session: Session)
}