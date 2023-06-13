package com.yologames.pwrlftr

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
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

var _Database_size = 1

private lateinit var sessionDao: SessionDao
//some test sessions. Can probably safely delete but will save time later
val sesh = Session(0, "Week 1", "Bench", 4, 4, 120)
val sesh2 = Session(0, "Week 2", "Bench", 3, 4, 125)
val sesh3 = Session(0, "Week 3", "Bench", 2, 4, 130)
var can_init: Boolean  = false

class ProgramGenerator : Fragment() {

    private val viewModel: ProgramGeneratorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel.BuildDatabase()
        BuildDatabase()
        super.onCreate(savedInstanceState)
    }

    fun BuildDatabase(){
        val database = Room.databaseBuilder(
            requireContext(),
            SessionDatabase::class.java, "session_database"
        ).build()
        sessionDao = database.sessionDao()
        testDB()
        queryDatabaseSize()
        can_init = true
    }

    //for reference check https://appdevnotes.com/android-room-db-tutorial-for-beginners-in-kotlin/
    //Use below function to call Database Test functionality. It will always be called directly after Build, but remove any functionality that shouldnt exist when not in use
    private fun testDB() {
        //addToTestDatabase(sesh)
        //clearDatabase()
        //addToTestDatabase()
    }

    fun queryDatabaseSize(){
        lifecycleScope.launch(Dispatchers.IO) {
            val i = sessionDao.getAllSessions().size
            if (i > _Database_size)
            {
                _Database_size = i
            }

            if (_Database_size > 0)
            {
                PopulateCards()
            }

//            Log.d("SDAO", "${_Database_size} Sessions Total")
        }

        //Dispatchers.IO.cancel()
    }

    private fun PopulateCards() {

        ClearCards()

        var i = 0
        while (i< _Database_size-1)
        {
            val session = sessionDao.getAllSessions()
            val tempSession = session[i]
            val cardToAdd = PCard(
                tempSession.title + (session[i].id).toString(),
                tempSession.exercise,
                tempSession.sets,
                tempSession.reps,
                tempSession.weight,
                i
            )
            PCardList.add(cardToAdd)
            i++
           // binding.recyclerView.adapter!!.notifyDataSetChanged()
        }


    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_program_generator, container, false)
        return binding.root

        updateDataset()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        if (can_init) InitRecycler()
        setOnClickListeners()
        //InitRecycler()
    }

    fun InitRecycler(){
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this.context, 3)
            adapter = PCardAdapter(PCardList)
        }
    }

    fun AddElementToRecycler(){
        lifecycleScope.launch(Dispatchers.IO) {
            val session = sessionDao.getAllSessions()
            val tempSession = session[session.lastIndex]
            val cardToAdd = PCard(
                tempSession.title + (sessionDao.getAllSessions().last().id).toString(),
                tempSession.exercise,
                tempSession.sets,
                tempSession.reps,
                tempSession.weight,

                )
            PCardList.add(cardToAdd)

        }
        binding.recyclerView.adapter!!.notifyItemInserted(PCardList.size)
    }

    fun RemoveElementFromDatabase(){
        var t : Int = 0
        lifecycleScope.launch(Dispatchers.IO) {

                sessionDao.deleteByID(sessionDao.getAllSessions().last().id)
//            Log.d("SDAO", "${sessionDao.getAllSessions().last().id} Sessions Total")
        }
        PCardList.removeAt(PCardList.size-1)
        binding.recyclerView.adapter!!.notifyItemRemoved(PCardList.size)

    }

    fun setOnClickListeners(){
        binding.addTestButton.setOnClickListener{
            addToTestDatabase(sesh)
        }

        binding.addSecondaryTestButton.setOnClickListener{
            addToTestDatabase(sesh2)
        }

        binding.removeTestButton.setOnClickListener{
            //clearDatabase()
            RemoveElementFromDatabase()

        }
    }


    fun addToTestDatabase(_local_session : Session) {
        lifecycleScope.launch(Dispatchers.IO) {
            sessionDao.insertSession(_local_session)


        }
        AddElementToRecycler()

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
        var i = _Database_size
        while (i > 0)
        {
            binding.recyclerView.adapter!!.notifyItemRemoved(i-1)
            i--
        }

        updateDataset()
    }

    }

    fun updateDataset(){
        binding.recyclerView.adapter!!.notifyDataSetChanged()
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