package com.yologames.pwrlftr

import android.content.Context
import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.yologames.pwrlftr.databinding.FragmentProgramGeneratorBinding
import com.yologames.pwrlftr.recyclerview.PCard
import com.yologames.pwrlftr.recyclerview.PCardAdapter
import com.yologames.pwrlftr.recyclerview.PCardList
import com.yologames.pwrlftr.room.Session
import com.yologames.pwrlftr.room.SessionDao
import com.yologames.pwrlftr.room.SessionDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


private lateinit var binding: FragmentProgramGeneratorBinding

private lateinit var sessionDao: SessionDao
val sesh = Session(0, "Week 1", "Bench", 4, 4, 120)
val sesh2 = Session(1, "Week 2", "Bench", 3, 4, 125)
val sesh3 = Session(2, "Week 3", "Bench", 2, 4, 130)

class ProgramGenerator : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        BuildDatabase()
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_program_generator, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        PopulateCards()
        InitRecycler()
    }

    fun BuildDatabase(){
        val database = Room.databaseBuilder(
            requireContext(),
            SessionDatabase::class.java, "session_database"
        ).build()
        sessionDao = database.sessionDao()
        testDB()
    }

    //for reference check https://appdevnotes.com/android-room-db-tutorial-for-beginners-in-kotlin/
    //Use below function to call Database Test functionality. It will always be called directly after Build, but remove any functionality that shouldnt exist when not in use
    private fun testDB() {


    }

    fun addToTestDatabase() {
        lifecycleScope.launch(Dispatchers.IO) {
            sessionDao.insertSession(sesh)
            val sessions = sessionDao.getAllSessions()
            Log.d("SDAO", "${sessions.size} Sessions Total")
        }
        Dispatchers.IO.cancel()

    }

    fun clearDatabase(){
        lifecycleScope.launch(Dispatchers.IO) {
            val sessions = sessionDao.getAllSessions()

            for (session in sessions) {
                sessionDao.deleteByID(session.id)
            }
            val sessionsB = sessionDao.getAllSessions()

            Log.d("SDAO", "${sessionsB.size} SessionsB Total - Post Delete")
        }
        Dispatchers.IO.cancel()
    }

    }


    fun InitRecycler(){
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this.context, 1)
            adapter = PCardAdapter(PCardList)
        }
    }

    private fun PopulateCards() {
        ClearCards()
        var i = 0
        while (i<100)
        {
            val cardToAdd = PCard(
                "TITLE" + i,
                "EXERCISE",
                "SETS"+i,
                "REPS",
                i
            )
            PCardList.add(cardToAdd)
            i++
        }
    }

    private fun ClearCards() {
        PCardList.clear()
    }


//
////        Log.d("SDAO", "**** Inserting Session ****")
//// sessionDao.insertSession(Session(0, "Week 2", "Bench", 4, 4, 120))
//sessionDao.insertSession(sesh)
//
//val sessions = sessionDao.getAllSessions()
//
//Log.d("SDAO", "${sessions.size} Sessions Total")
//
//// sessionDao.deleteSession(Session(0, "Week 2", "Bench", 4, 4, 120))
//sessionDao.deleteSession(sesh)
//val sessions2 = database.sessionDaosessionDao.getAllSessions()
//
//for (session in sessions2){
//    Log.i("SDAO", "id: ${session.id}")
//}
//
//Log.d("SDAO", "${sessions2.size} Sessions2 Total")
//
//sessionDao.deleteSession(sesh)
//sessionDao.deleteSession(sesh)
//sessionDao.deleteSession(sesh)
//val sessions3 = sessionDao.getAllSessions()
//Log.d("SDAO", "${sessions3.size} Sessions3 Total")