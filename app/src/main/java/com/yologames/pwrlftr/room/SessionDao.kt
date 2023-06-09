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

    @Query("DELETE FROM session_table WHERE id = :id")
    suspend fun deleteByID(id: Int)

    @Query("SELECT * FROM session_table WHERE title = :title")
    fun getByTitle(title: String): List<Session>

    @Query("SELECT * FROM session_table WHERE title = :title AND exercise = :exercise")
    fun getByTitleAndExercise(title: String, exercise: String): List<Session>

    @Query("DELETE FROM session_table WHERE id NOT IN (SELECT id FROM session_table ORDER BY id ASC LIMIT 0)")
    fun deleteAllSessionsExceptFirst()

    @Query("DELETE FROM session_table")
    suspend fun deleteAllSessions()


}