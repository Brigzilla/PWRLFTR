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
import java.math.BigDecimal
import java.math.MathContext
import kotlin.math.round

class ProgramGeneratorViewModel : ViewModel() {

    var _1rms = ArrayList<Float>()
//    val sesh3 = Session(0, "Week 3", "Bench", 2, 4, 130)
    val trainingProgram = ArrayList<Session>()
    var multiplier : Double = 1.00
    var increment : Double = 2.5


    init {
        _1rms.add( 300.0f) //Squat
        _1rms.add( 230.0f) //Bench
        _1rms.add( 300.0f) //Deadlift
    }

    fun Alpha_Session_1(): Session{
        val sessionAspect  = ArrayList<String>()
        sessionAspect.add("Squat")
        sessionAspect.add("\nSet 1: ${rounded(_1rms[0]*.7)} * 5 reps")
        sessionAspect.add("\nSet 2: ${rounded( _1rms[0]*.75)} * 3 reps")
        sessionAspect.add("\nSet 3: ${rounded(_1rms[0]*.80)} * 2 reps")
        sessionAspect.add("\nSet 4: ${rounded(_1rms[0]*.85)} * 1 rep")
        sessionAspect.add("\nSet 5: ${rounded(_1rms[0]*.90)} * 1 rep")
        sessionAspect.add("\nBack-off Set: ${rounded(_1rms[0]*.80)} * 5 reps")
        sessionAspect.add("\nBack-off Set: ${rounded(_1rms[0]*.75)} * 5 reps")
        sessionAspect.add("\nBench")
        sessionAspect.add("\nSet 1: ${rounded(_1rms[1]*.7)} * 5 reps")
        sessionAspect.add("\nSet 2: ${rounded(_1rms[1]*.75)} * 3 reps")
        sessionAspect.add("\nSet 3: ${rounded(_1rms[1]*.80)} * 2 reps")
        sessionAspect.add("\nSet 4: ${rounded(_1rms[1]*.85)} * 1 rep")
        sessionAspect.add("\nSet 5: ${rounded(_1rms[1]*.90)} * 1 rep")
        sessionAspect.add("\nBack-off Set: ${rounded(_1rms[1]*.80)} * 5 reps")
        sessionAspect.add("\nBack-off Set: ${rounded(_1rms[1]*.75)} * 5 reps")
        return Session(0,
            "Week ${1}, Day 1",
            sessionAspect.toString().substringAfter("[").substringBefore("]"),
            0, 0, 0)
    }

    private fun Alpha_Session_2(): Session {
        val sessionAspect  = ArrayList<String>()
        sessionAspect.add("Squat")
        sessionAspect.add("\nSet 1: ${rounded(_1rms[0]*.6)} * 5 reps")
        sessionAspect.add("\nSet 2: ${rounded(_1rms[0]*.65)} * 5 reps")
        sessionAspect.add("\nSet 3: ${rounded(_1rms[0]*.70)} * 5 reps")
        sessionAspect.add("\nSet 4: ${rounded(_1rms[0]*.75)} * 5 reps")
        sessionAspect.add("\nBench")
        sessionAspect.add("\nSet 1: ${rounded(_1rms[1]*.60)} * 5 reps")
        sessionAspect.add("\nSet 2: ${rounded(_1rms[1]*.65)} * 5 reps")
        sessionAspect.add("\nSet 3: ${rounded(_1rms[1]*.70)} * 5 reps")
        sessionAspect.add("\nSet 4: ${rounded(_1rms[1]*.75)} * 5 reps")
        return Session(0,
            "Week ${1}, Day 3",
            sessionAspect.toString().substringAfter("[").substringBefore("]"),
            0, 0, 0)
    }

    private fun Alpha_Session_3(): Session {
        val sessionAspect  = ArrayList<String>()
        sessionAspect.add("Deadlift")
        sessionAspect.add("\nSet 1: ${rounded(_1rms[2]*.65)} * 5 reps")
        sessionAspect.add("\nSet 2: ${rounded(_1rms[2]*.75)} * 5 reps")
        sessionAspect.add("\nSet 3: ${rounded(_1rms[2]*.85)} * 3 reps")
        sessionAspect.add("\nSet 4: ${rounded(_1rms[2]*.90)} * 1 rep")
        sessionAspect.add("\nSet 5: ${rounded(_1rms[2]*.95)} * 1 rep")
        sessionAspect.add("\nBack-off Set: ${rounded(_1rms[2]*.80)} * 5 reps")
        sessionAspect.add("\nBack-off Set: ${rounded(_1rms[2]*.75)} * 5 reps")
        return Session(0,
            "Week ${1}, Day 5",
            sessionAspect.toString().substringAfter("[").substringBefore("]"),
            0, 0, 0)
    }



    fun createAlphaProgram(): ArrayList<Session>{
        trainingProgram.clear()
        trainingProgram.add(Alpha_Session_1())
        trainingProgram.add(Alpha_Session_2())
        trainingProgram.add(Alpha_Session_3())
        return trainingProgram
    }



    //Math stuff
    fun rounded(f: Double): BigDecimal
    {
        val bd = BigDecimal(f).round(MathContext(3))
        return applyMultiplier(bd)
    }

    fun applyMultiplier(f: BigDecimal) : BigDecimal
    {

        val bd = f * (BigDecimal(multiplier))
        return applyIncrement(f)
    }

    fun applyIncrement(bd: BigDecimal) : BigDecimal
    {
        return bd + BigDecimal(increment)
    }

}