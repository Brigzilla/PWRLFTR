package com.yologames.pwrlftr

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
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
import kotlinx.coroutines.launch


private lateinit var binding: FragmentProgramGeneratorBinding

var _Database_size = 1

private lateinit var sessionDao: SessionDao


var sessionsInCard = ArrayList<String>(40)
//some test sessions. Can probably safely delete but will save time later
//val sesh = Session(0, "Week 1", "Bench", 4, 4, 120)
//val sesh2 = Session(0, "Week 2", "Bench", 3, 4, 125)
//val sesh3 = Session(0, "Week 3", "Bench", 2, 4, 130)
var can_init: Boolean  = false

class ProgramGenerator : Fragment() {

    private val viewModel: ProgramGeneratorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        BuildDatabase()
        super.onCreate(savedInstanceState)
    }

    fun BuildDatabase(){
        val database = Room.databaseBuilder(
            requireContext(),
            SessionDatabase::class.java, "session_database"
        ).allowMainThreadQueries().build()
        sessionDao = database.sessionDao()
        queryDatabaseSize()
        can_init = true
    }

    //for reference check https://appdevnotes.com/android-room-db-tutorial-for-beginners-in-kotlin/
    fun queryDatabaseSize(){
        lifecycleScope.launch(Dispatchers.IO) {
            if (sessionDao.getAllSessions().isNotEmpty())
            {
            val i = sessionDao.getAllSessions().size
            if (i > _Database_size)
            {
                _Database_size = i
            }

            if (_Database_size > 0)
            {
                //PopulateCards()
                PopulateCardsNew()
            }
            }
        }
    }

    private fun PopulateCardsNew(){
        //lifecycleScope.launch(Dispatchers.IO) {
            ClearCards()


            val session = sessionDao.getAllSessions().sortedBy { it.title }
            if (sessionDao.getAllSessions().isNotEmpty())
            {

                var i = 0

                while (i < session.size) {
                    sessionsInCard = arrayListOf("_","_", "_", "_", "_", "_", "_", "_", "_", "_")
                    val tempTitles = sessionDao.getByTitle(session[i].title)
                    var j = 0
                    while (j< tempTitles.size)
                    {
                        sessionsInCard[j] = ("${tempTitles[j].sets} * ${tempTitles[j].reps} at ${tempTitles[j].weight}KG")
                        j++
                    }


                    addPCard(tempTitles[0])

                    i+= tempTitles.size
                }
            }
           // }
        updateRecyclerView()
        }

    private fun updateRecyclerView() {
        requireActivity().runOnUiThread {
            binding.recyclerView.adapter?.notifyDataSetChanged()
        }
    }

    private fun addPCard(session: Session) {
        val cardToAdd = PCard(
            session.title,
            session.exercise,
            sessionsInCard[0],
            sessionsInCard[1],
            sessionsInCard[2],
            sessionsInCard[3],
            sessionsInCard[4],
            sessionsInCard[5],
            sessionsInCard[6],
            sessionsInCard[7],
            sessionsInCard[8],
            sessionsInCard[9],
            0
        )
        Log.d("FATAL", cardToAdd.title)
        PCardList.add(cardToAdd)


    }


//    private fun PopulateCards() {
//
//        lifecycleScope.launch(Dispatchers.IO){
//        ClearCards()
//
//        var i = 0
//        if (sessionDao.getAllSessions().isNotEmpty())
//        {
//
//        while (i< sessionDao.getAllSessions().size)
//        {
//            val session = sessionDao.getAllSessions().sortedBy { it.title }
//            for (Session in session) {
//
//            }
//            val tempSession = session[i]
//            val cardToAdd = PCard(
//                tempSession.title,
//                tempSession.exercise,
//                tempSession.sets.toString() + " * "+ tempSession.reps +" at "+ tempSession.weight + "KG",
//                "","","","","","","","","",
//                i
//            )
//            PCardList.add(cardToAdd)
//            i++
//        }
//        }
//        }
//
//
//    }



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

       if (can_init) {
           InitRecycler()

           lifecycleScope.launch(Dispatchers.Main)
           {

               if (sessionDao.getAllSessions().isNotEmpty()) hideInitialElements()
           }
       }
           setOnClickListeners()

    }

    fun InitRecycler(){
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this.context, 1)
            adapter = PCardAdapter(PCardList)
        }

        updateDataset()
    }



//    fun AddElementToRecycler(){
//        lifecycleScope.launch(Dispatchers.IO) {
//            val session = sessionDao.getAllSessions()
//            if (sessionDao.getAllSessions().isNotEmpty()) {
//                val tempSession = session.last()
//
//                val cardToAdd = PCard(
//                    tempSession.title,
//                    tempSession.exercise,
//                    tempSession.sets,
//                    tempSession.reps,
//                    tempSession.weight.toString().toInt(),
//                    session.size-1
//
//                    )
//                PCardList.add(cardToAdd)
//               // withContext(Dispatchers.Main)
//               // {
//                    binding.recyclerView.adapter!!.notifyItemInserted(PCardList.size)
//                //}
//            }
//        }
//
//        //binding.recyclerView.adapter!!.notifyItemInserted(PCardList.size-1 )
//    }

    fun RemoveElementFromDatabase(){
        var t : Int = 0
        lifecycleScope.launch(Dispatchers.IO) {

            if (sessionDao.getAllSessions().isNotEmpty()) {
                sessionDao.deleteByID(sessionDao.getAllSessions().last().id)
            }
        }
        if (PCardList.size > 0) {
            PCardList.removeAt(PCardList.size - 1)

            binding.recyclerView.adapter!!.notifyItemRemoved(PCardList.size)
        }

    }

    fun setOnClickListeners(){


        binding.enter1rmSquat.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                if (binding.enter1rmSquat.text.isNotEmpty() || binding.enter1rmBench.text.isNotEmpty() || binding.enter1rmDead.text.isNotEmpty())
                {
                    addArrayToDatabase(viewModel.createAlphaProgram())
                    updateDataset()
                    hideInitialElements()
                }

                    return@OnKeyListener true
            }
            false
        })

        binding.enter1rmBench.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                if (binding.enter1rmSquat.text.isNotEmpty() || binding.enter1rmBench.text.isNotEmpty() || binding.enter1rmDead.text.isNotEmpty())
                {
                    addArrayToDatabase(viewModel.createAlphaProgram())
                    updateDataset()
                    hideInitialElements()
                }

                return@OnKeyListener true
            }
            false
        })

        binding.enter1rmDead.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                if (binding.enter1rmSquat.text.isNotEmpty() || binding.enter1rmBench.text.isNotEmpty() || binding.enter1rmDead.text.isNotEmpty())
                {
                    addArrayToDatabase(viewModel.createAlphaProgram())
                    updateDataset()
                    hideInitialElements()
                }

                return@OnKeyListener true
            }
            false
        })



        binding.addTestButton.setOnClickListener {
            viewModel._1rms[0] = binding.enter1rmSquat.text.toString().toFloat()
            viewModel._1rms[1] = binding.enter1rmBench.text.toString().toFloat()
            viewModel._1rms[2] = binding.enter1rmDead.text.toString().toFloat()

            lifecycleScope.launch { Dispatchers.IO
                val temp = viewModel.createBetaProgram()
            addArrayToDatabase(temp)
            hideInitialElements()
                updateRecyclerView()
                reloadFragment()
                }
        }


        binding.addSecondaryTestButton.setOnClickListener{
            //addToTestDatabase(sesh2)
        }

        binding.removeTestButton.setOnClickListener{
            //clearDatabase()
//            while (PCardList.size > 0) {
//                RemoveElementFromDatabase()
//            }
            binding.removeTestButton.visibility = View.GONE
            clearDatabase()
            reloadFragment()

        }
    }

//    private fun reloadFragment() {
//        val fragmentManager = requireFragmentManager()
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        val currentFragment = fragmentManager.findFragmentByTag("ProgramGenerator")
//        fragmentTransaction.remove(currentFragment!!)
//        fragmentTransaction.add(R.id.nav_host_fragment, ProgramGenerator(), "ProgramGenerator")
//        fragmentTransaction.commit()
//    }

    fun parseArray(listOfList: ArrayList<ArrayList<Session>>){


    }

    fun addArrayToDatabase(list : ArrayList<Session>){
        var i = 0
        while (i < list.size)
        {
            addToTestDatabase(list[i])
            i++
        }
    }


    fun addToTestDatabase(_local_session : Session) {
        lifecycleScope.launch(Dispatchers.IO) {
                sessionDao.insertSession(_local_session)
        }

        //AddElementToRecycler()
        updateDataset()
        //PopulateCards()
        PopulateCardsNew()

    }

    fun reloadFragment(){
//        val ft: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
//        //ft.remove(holder())
//        ft.remove(ProgramGenerator())
////                    ft.add(android.R.id.content, DictionaryFragment())
//        ft.add(android.R.id.content, Menu())
//        ft.commitNow()
        findNavController().navigate(R.id.action_programGenerator_self)
    }

    fun hideInitialElements(){
        binding.enter1rmSquat.visibility = View.GONE
        binding.enter1rmBench.visibility = View.GONE
        binding.enter1rmDead.visibility = View.GONE
        binding.addTestButton.visibility = View.GONE
        binding.textSquat.visibility = View.GONE
        binding.textBench.visibility = View.GONE
        binding.textDead.visibility = View.GONE
        binding.removeTestButton.visibility = View.VISIBLE
        //binding.removeTestButton.visibility  =View.GONE

        //maybe remove bottom two from here for own function
        binding.scrollView.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.VISIBLE
    }

    fun clearDatabase(){
        lifecycleScope.launch(Dispatchers.IO) {
            val sessions = sessionDao.getAllSessions()

            for (session in sessions) {
                sessionDao.deleteByID(session.id)
            }
            val sessionsB = sessionDao.getAllSessions()

           // Log.d("SDAO", "${sessionsB.size} SessionsB Total - Post Delete")
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