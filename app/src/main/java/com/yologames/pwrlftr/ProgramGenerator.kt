package com.yologames.pwrlftr

import PCardAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.yologames.pwrlftr.databinding.FragmentProgramGeneratorBinding
import com.yologames.pwrlftr.recyclerview.PCard
import com.yologames.pwrlftr.recyclerview.PCardList
import com.yologames.pwrlftr.room.Session
import com.yologames.pwrlftr.room.SessionDao
import com.yologames.pwrlftr.room.SessionDatabase
import kotlinx.coroutines.*


private lateinit var binding: FragmentProgramGeneratorBinding

var _Database_size = 1

private lateinit var sessionDao: SessionDao

var can_init: Boolean  = false

class ProgramGenerator : Fragment() {

    private val viewModel: ProgramGeneratorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        BuildDatabase()

        super.onCreate(savedInstanceState)
    }

    class YourFragment : Fragment(), PCardAdapter.ButtonClickListener {
        // Fragment code...

        override fun onButtonClicked() {
            // Handle button click event here
        }
    }


    fun BuildDatabase(){
        val database = Room.databaseBuilder(
            requireContext(),
            SessionDatabase::class.java, "session_database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
        sessionDao = database.sessionDao()
        queryDatabaseSize()
        loadFromMain()
        can_init = true
    }

    //for reference check https://appdevnotes.com/android-room-db-tutorial-for-beginners-in-kotlin/
    fun queryDatabaseSize() {
        lifecycleScope.launch(Dispatchers.IO) {
            val sessionList = sessionDao.getAllSessions()
            if (sessionList.isNotEmpty()) {
                val databaseSize = sessionList.size
                if (databaseSize > _Database_size) {
                    _Database_size = databaseSize
                }
            }
        }
    }


private fun updateRecyclerView() {
    lifecycleScope.launch(Dispatchers.IO) {
        val sessions = sessionDao.getAllSessions().sortedBy { it.title }
        withContext(Dispatchers.Main) {
            PCardList.clear()
            sessions.forEach { session ->
                val sessionsInCard = ArrayList<String>(10)
                for (k in 0 until 10) {
                    sessionsInCard.add("_")
                }
                if (session.set_0 != "") sessionsInCard[0] = session.set_0
                if (session.set_1 != "") sessionsInCard[1] = session.set_1
                if (session.set_2 != "") sessionsInCard[2] = session.set_2
                if (session.set_3 != "") sessionsInCard[3] = session.set_3
                if (session.set_4 != "") sessionsInCard[4] = session.set_4
                if (session.set_5 != "") sessionsInCard[5] = session.set_5
                if (session.set_6 != "") sessionsInCard[6] = session.set_6
                if (session.set_7 != "") sessionsInCard[7] = session.set_7
                if (session.set_8 != "") sessionsInCard[8] = session.set_8
                if (session.set_9 != "") sessionsInCard[9] = session.set_9

                val cardToAdd = PCard(
                    session.title.substringAfter("_"),
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
                    session.can_review,
                    0
                )
                PCardList.add(cardToAdd)
            }

            binding.recyclerView.adapter?.notifyDataSetChanged()
        }
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

    val listener = object : PCardAdapter.ButtonClickListener {
        override fun onButtonClicked() {
            // Handle button click event
            // This code will be executed when the button is clicked in the adapter
            Log.d("FATAL", "TEST")
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            InitRecycler()
            lifecycleScope.launch(Dispatchers.Main) {
                if (sessionDao.getAllSessions().isNotEmpty()) hideInitialElements()
                if (sessionDao.getAllSessions().isEmpty()) showInitialElements()

                updateRecyclerView() // Update the RecyclerView here
            }
        setOnClickListeners()
    }



    fun InitRecycler() {
         binding.recyclerView.apply {
             layoutManager = LinearLayoutManager(context)
             adapter = PCardAdapter(PCardList, listener)
         val index = _session_feedback_left.lastIndexOf(false) //change to true for actual build
         post {
                layoutManager?.scrollToPosition(index)
         }
     }
     updateDataset()
    }
    @SuppressLint("SuspiciousIndentation")
    fun setOnClickListeners(){
        binding.addTestButton.setOnClickListener {
            if (sessionDao.getAllSessions().isEmpty()) {
                _1rms[0] = binding.enter1rmSquat.text.toString().toFloat()
                _1rms[1] = binding.enter1rmBench.text.toString().toFloat()
                _1rms[2] = binding.enter1rmDead.text.toString().toFloat()
                _passesAllowable = 1
                viewModel.passesComplete = _weeks
                val temp = viewModel.createNextWeek()
//                for (item in temp) {
//                    Log.d("FATAL",item.title.toString())
//                }
                lifecycleScope.launch {
                    withContext(Dispatchers.Main) {
                        addArrayToDatabase(temp)
                    }
                }
                saveThroughMain()

            }
            val trueCount = countTrueElements(_session_feedback_left)
//            if (trueCount >= _session_feedback_left.size && sessionDao.getAllSessions().isNotEmpty()) {
// Swap above with below to test the ordering. Removes the requirement to leave feedback before generating the next week
                if (sessionDao.getAllSessions().isNotEmpty()) {
                _passesAllowable = 1
                _sessions_reviewed = trueCount
                viewModel.passesComplete = _weeks
                val temp = viewModel.createNextWeek()

                lifecycleScope.launch{
                         withContext(Dispatchers.IO) {
                             addArrayToDatabase(temp)
                         }
                             saveThroughMain()
                }
            }

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

    fun saveThroughMain(){
        hideInitialElements()
        updateRecyclerView()
        val mainActivity = requireActivity() as MainActivity
        mainActivity.saveBooleanListToPrefs(
            s_session_feedback_list,
            _session_feedback_left
        )
        mainActivity.saveIntToPrefs(s_week, _weeks)
        mainActivity.saveIntToPrefs(s_complete, viewModel.passesComplete)
        mainActivity.saveIntToPrefs(s_day, viewModel.day)
        mainActivity.saveFloat(s_s1rm, _1rms[0])
        mainActivity.saveFloat(s_b1rm, _1rms[1])
        mainActivity.saveFloat(s_d1rm, _1rms[2])
        mainActivity.saveIntToPrefs(s_sgenerated, viewModel.sessions_generated)
        mainActivity.saveFloat(s_fbo_s, feedback_offset_squat)
        mainActivity.saveFloat(s_fbo_b, feedback_offset_bench)
        mainActivity.saveFloat(s_fbo_d, feedback_offset_deadl)
        reloadFragment()
    }

    fun loadFromMain(){
        val mainActivity = requireActivity() as MainActivity
        _1rms[0] = mainActivity.loadFloat(s_s1rm)
        _1rms[1] = mainActivity.loadFloat(s_b1rm)
        _1rms[2] = mainActivity.loadFloat(s_d1rm)
        feedback_offset_squat = mainActivity.loadFloat(s_fbo_s)
        feedback_offset_bench = mainActivity.loadFloat(s_fbo_b)
        feedback_offset_deadl = mainActivity.loadFloat(s_fbo_d)
        viewModel.passesComplete = mainActivity.loadIntFromPrefs(s_complete, 0)
        viewModel.sessions_generated = mainActivity.loadIntFromPrefs(s_sgenerated, 0)
        _weeks = mainActivity.loadIntFromPrefs(s_week, 0)
        mainActivity.loadIntFromPrefs(s_day, 0)
    }

    fun countTrueElements(array: ArrayList<Boolean>): Int {
        var count = 0
        for (element in array) {
            if (element) {
                count++
            }
        }
        return count
    }


    fun addArrayToDatabase(list : ArrayList<Session>){
        val l = list.sortedBy { it.title }
        lifecycleScope.launch {
            withContext(Dispatchers.Main) {
//                sessionDao.insertAllSessions(list)
        var i = 0
        while (i < list.size)
             {
            addToTestDatabase(l[i])
            i++
             }
                updateDataset()
                refreshRecyclerView()
            }
        }
    }


    fun addToTestDatabase(_local_session: Session) {
        lifecycleScope.launch {
            withContext(Dispatchers.Main) {
                sessionDao.insertSession(_local_session)
                withContext(Dispatchers.Main) {

                }
            }
            }
    }


    private fun refreshRecyclerView() {
        binding.recyclerView.adapter?.apply {
            notifyDataSetChanged()
        }
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
        binding.addTestButton.visibility = View.GONE
        //maybe remove bottom two from here for own function
        binding.scrollView.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.VISIBLE
    }

    fun clearDatabase() {
        PCardList.clear()
        val mainActivity = requireActivity() as MainActivity
        _session_feedback_left.clear()
        mainActivity.saveBooleanListToPrefs(s_session_feedback_list, _session_feedback_left)
        mainActivity.saveFloat(s_s1rm, 0.0f)
        mainActivity.saveFloat(s_b1rm, 0.0f)
        mainActivity.saveFloat(s_d1rm, 0.0f)
        _passesAllowable = 0
        _weeks = 0

        mainActivity.saveIntToPrefs(s_week, _weeks)
        updateDataset()
        lifecycleScope.launch(Dispatchers.Main) {
//            sessionDao.deleteAllSessionsExceptFirst()
            sessionDao.deleteAllSessions()
            reloadFragment()
        }



    }


    fun updateDataset(){
       binding.recyclerView.adapter!!.notifyDataSetChanged()

    }

    private fun ClearCards() {
        PCardList.clear()
    }
}
