package com.yologames.pwrlftr

import android.app.Activity
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
import androidx.recyclerview.widget.LinearLayoutManager
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
var weight_measurement = "KG"
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

private fun PopulateCardsNew() {
    ClearCards()
    val session = sessionDao.getAllSessions().sortedBy { it.title }
    if (sessionDao.getAllSessions().isNotEmpty()) {
        var i = 0
        while (i < session.size) {
            val tempTitles = sessionDao.getByTitle(session[i].title)
            val sessionsInCard = ArrayList<String>(10)
            for (j in 0 until 10) {
                sessionsInCard.add("_")
            }
            var j = 0
            while (j < tempTitles.size && j < 10) {
                sessionsInCard[j] = "${tempTitles[j].sets} * ${tempTitles[j].reps} at ${tempTitles[j].weight}$weight_measurement"
                j++
            }
            addPCard(tempTitles[0], sessionsInCard)
            i += tempTitles.size
        }
    }
    updateRecyclerView()
}

    private fun updateRecyclerView() {
        requireActivity().runOnUiThread {
            binding.recyclerView.adapter?.notifyDataSetChanged()
        }
    }

private fun addPCard(session: Session, sessionsInCard: ArrayList<String>) {
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
    PCardList.add(cardToAdd)
}

    fun generateNextWeek(){
        viewModel.sessions_generated = 0

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

       if (can_init) {
           InitRecycler()

           lifecycleScope.launch(Dispatchers.Main)
           {

               if (sessionDao.getAllSessions().isNotEmpty()) hideInitialElements()
               if (sessionDao.getAllSessions().isEmpty())showInitialElements()
           }
       }
           setOnClickListeners()

    }

//    fun InitRecycler(){
//        binding.recyclerView.apply {
//            layoutManager = GridLayoutManager(this.context, 1)
//            adapter = PCardAdapter(PCardList)
//        }
//
//        updateDataset()
//    }
fun InitRecycler() {
    binding.recyclerView.apply {
        layoutManager = LinearLayoutManager(context)
        adapter = PCardAdapter(PCardList)

        // Set the index you want to scroll to
        val index = _session_feedback_left.lastIndexOf(true)
        Log.d("FATAL", index.toString())
        // Scroll to the desired position
        post {
            layoutManager?.scrollToPosition(index)
        }
    }

    updateDataset()
}





    fun setOnClickListeners(){

        binding.addTestButton.setOnClickListener {
            viewModel._1rms[0] = binding.enter1rmSquat.text.toString().toFloat()
            viewModel._1rms[1] = binding.enter1rmBench.text.toString().toFloat()
            viewModel._1rms[2] = binding.enter1rmDead.text.toString().toFloat()

            if (_session_feedback_left.lastIndexOf(true) < (_passesAllowable *5)){
                _passesAllowable += 1
            }
            viewModel.passesComplete = _weeks
            if (_passesAllowable > viewModel.passesComplete) {
                lifecycleScope.launch {
                    Dispatchers.IO
                    val temp = viewModel.createBetaProgram()

                    addArrayToDatabase(temp)
                    hideInitialElements()
                    updateRecyclerView()
                    saveAll()
                    reloadFragment()
                }
            }
        }

        binding.addSecondaryTestButton.setOnClickListener{
        }

        binding.removeTestButton.setOnClickListener{

            binding.removeTestButton.visibility = View.GONE
            _session_feedback_left.clear()
            lifecycleScope.launch(Dispatchers.Main)
            {
                clearDatabase()
                _weeks = 0

            }

        }
    }

    fun saveAll(){

        val mainActivity = requireActivity() as MainActivity
        mainActivity.saveBooleanListToPrefs("session_feedback_list", _session_feedback_left)
        mainActivity.saveIntToPrefs("passes_allowable", _passesAllowable)
//        mainActivity.saveIntToPrefs("sessions_reviewed", _sessions_reviewed)
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
        updateDataset()
        PopulateCardsNew()
    }

    fun reloadFragment(){
        findNavController().navigate(R.id.action_programGenerator_self)
    }

    fun showInitialElements(){
        binding.enter1rmSquat.visibility = View.VISIBLE
        binding.enter1rmBench.visibility = View.VISIBLE
        binding.enter1rmDead.visibility = View.VISIBLE
        binding.addTestButton.visibility = View.VISIBLE
        binding.textSquat.visibility = View.VISIBLE
        binding.textBench.visibility = View.VISIBLE
        binding.textDead.visibility = View.VISIBLE
    }

    fun hideInitialElements(){
        binding.enter1rmSquat.visibility = View.GONE
        binding.enter1rmBench.visibility = View.GONE
        binding.enter1rmDead.visibility = View.GONE
        //binding.addTestButton.visibility = View.GONE
        binding.textSquat.visibility = View.GONE
        binding.textBench.visibility = View.GONE
        binding.textDead.visibility = View.GONE
        binding.removeTestButton.visibility = View.VISIBLE
        //binding.removeTestButton.visibility  =View.GONE

        //maybe remove bottom two from here for own function
        binding.scrollView.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.VISIBLE
    }

    fun clearDatabase() {
        lifecycleScope.launch(Dispatchers.IO) {
            sessionDao.deleteAllSessionsExceptFirst()
        }
        PCardList.clear()
        updateDataset()
        reloadFragment()
    }

}

    fun updateDataset(){
        binding.recyclerView.adapter!!.notifyDataSetChanged()
    }

    private fun ClearCards() {
        PCardList.clear()
    }
