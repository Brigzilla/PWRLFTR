package com.yologames.pwrlftr

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.*
import androidx.room.Room
import com.yologames.pwrlftr.recyclerview.PCard
import com.yologames.pwrlftr.recyclerview.PCardList
import com.yologames.pwrlftr.room.Session
import com.yologames.pwrlftr.room.SessionDao
import com.yologames.pwrlftr.room.SessionDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProgramGeneratorViewModel : ViewModel() {

    var _Database_size = 1
    private lateinit var sessionDao: SessionDao

    //some test sessions. Can probably safely delete but will save time later
    var can_init: Boolean = false

    init {

        BuildDatabase()
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

    fun BuildDatabase() {
//        //viewModelScope.launch(Dispatchers.IO) {
//            val database = Room.databaseBuilder(
//                context,
//                SessionDatabase::class.java, "session_database"
//            ).build()
//            sessionDao = database.sessionDao()
//            testDB()
//            queryDatabaseSize()
//        Log.d("VMDB", "Database retrieved with ${sessionDao.getAllSessions().size} elements")
//            can_init = true
//       // }
    }

    private fun testDB() {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

    fun queryDatabaseSize() {
        viewModelScope.launch(Dispatchers.IO) {

        }

        //Dispatchers.IO.cancel()
    }

    fun AddElementToRecycler() {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

    fun RemoveElementFromDatabase() {
        viewModelScope.launch(Dispatchers.IO) {

        }

    }

    fun clearDatabase() {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

}