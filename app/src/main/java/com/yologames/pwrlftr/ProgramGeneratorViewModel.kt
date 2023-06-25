package com.yologames.pwrlftr

import android.util.Log
import androidx.lifecycle.*
import com.yologames.pwrlftr.room.Session
import java.math.BigDecimal
import java.math.MathContext

class ProgramGeneratorViewModel : ViewModel() {


    val trainingProgram = ArrayList<Session>()

    var multiplier : Double = 1.00

    var increment : Double = 2.5

    var passesComplete : Int = 0
    var passedExpected : Int = 1
    var sessions_generated: Int = 0
//    var passesAllowable: Int = 1
    var day: Int = 1
    var dayExpected = 3


//    init {
//        _1rms.add( 300.0f) //Squat
//        _1rms.add( 230.0f) //Bench
//        _1rms.add( 300.0f) //Deadlift
//    }


    fun createBetaProgram(): ArrayList<Session>{
        Log.d("FATAL", "S ${_1rms[0]} B ${_1rms[1]} D ${_1rms[2]}")
        while (passesComplete < _passesAllowable) {
            if (day == 1) {
                //Squat
                trainingProgram.add(Beta_Set_1())
                trainingProgram.add(Beta_Set_2())
                trainingProgram.add(Beta_Set_3())
                trainingProgram.add(Beta_Set_4())
                trainingProgram.add(Beta_Set_5())
                trainingProgram.add(Beta_Set_6())
                trainingProgram.add(Beta_Set_7())
                sessions_generated++

                //Bench
                trainingProgram.add(Beta_Set_8())
                trainingProgram.add(Beta_Set_9())
                trainingProgram.add(Beta_Set_10())
                trainingProgram.add(Beta_Set_11())
                trainingProgram.add(Beta_Set_12())
                trainingProgram.add(Beta_Set_13())
                trainingProgram.add(Beta_Set_14())
                sessions_generated++
            }
            if (day == 2) {
                //Squat
                trainingProgram.add(Beta_Set_15())
                trainingProgram.add(Beta_Set_16())
                trainingProgram.add(Beta_Set_17())
                trainingProgram.add(Beta_Set_18())
                sessions_generated++

                //Bench
                trainingProgram.add(Beta_Set_19())
                trainingProgram.add(Beta_Set_20())
                trainingProgram.add(Beta_Set_21())
                trainingProgram.add(Beta_Set_22())
                sessions_generated++
            }
            if (day == 3) {
                //Deadlift
                trainingProgram.add(Beta_Set_23())
                trainingProgram.add(Beta_Set_24())
                trainingProgram.add(Beta_Set_25())
                trainingProgram.add(Beta_Set_26())
                trainingProgram.add(Beta_Set_27())
                trainingProgram.add(Beta_Set_28())
                trainingProgram.add(Beta_Set_29())
                sessions_generated++
            }

            if (day <= dayExpected) {
                day++
            }
            if (day > dayExpected){
                passesComplete++
                _weeks = passesComplete
                day = 1
            }
        }

        return trainingProgram
    }

    private fun Beta_Set_1(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Squat",
            "Squat",
            1,
            5,
            rounded(_1rms[0]*.7).toInt())
    }
    private fun Beta_Set_2(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Squat",
            "Squat",
            1,
            3,
            rounded(_1rms[0]*.75).toInt())
    }
    private fun Beta_Set_3(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Squat",
            "Squat",
            1,
            2,
            rounded(_1rms[0]*.80).toInt())
    }

    private fun Beta_Set_4(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Squat",
            "Squat",
            1,
            1,
            rounded(_1rms[0]*.85).toInt())
    }

    private fun Beta_Set_5(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Squat",
            "Squat",
            1,
            1,
            rounded(_1rms[0]*.90).toInt())
    }

    private fun Beta_Set_6(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Squat",
            "Squat",
            1,
            5,
            rounded(_1rms[0]*.80).toInt())
    }
    private fun Beta_Set_7(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Squat",
            "Squat",
            1,
            5,
            rounded(_1rms[0]*.75).toInt())
    }



    private fun Beta_Set_8(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Bench",
            "Bench",
            1,
            5,
            rounded(_1rms[1]*.7).toInt())
    }

    private fun Beta_Set_9(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Bench",
            "Bench",
            1,
            3,
            rounded(_1rms[1]*.75).toInt())
    }
    private fun Beta_Set_10(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Bench",
            "Bench",
            1,
            2,
            rounded(_1rms[1]*.80).toInt())
    }
    private fun Beta_Set_11(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Bench",
            "Bench",
            1,
            1,
            rounded(_1rms[1]*.85).toInt())
    }
    private fun Beta_Set_12(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Bench",
            "Bench",
            1,
            1,
            rounded(_1rms[1]*.90).toInt())
    }
    private fun Beta_Set_13(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Bench",
            "Bench",
            1,
            5,
            rounded(_1rms[1]*.80).toInt())
    }

    private fun Beta_Set_14(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Bench",
            "Bench",
            1,
            5,
            rounded(_1rms[1]*.75).toInt())
    }



    private fun Beta_Set_15(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Squat",
            "Squat",
            1,
            5,
            rounded(_1rms[0]*.60).toInt())
    }

    private fun Beta_Set_16(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Squat",
            "Squat",
            1,
            5,
            rounded(_1rms[0]*.65).toInt())
    }

    private fun Beta_Set_17(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Squat",
            "Squat",
            1,
            5,
            rounded(_1rms[0]*.70).toInt())
    }

    private fun Beta_Set_18(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Squat",
            "Squat",
            1,
            5,
            rounded(_1rms[0]*.75).toInt())
    }



    private fun Beta_Set_19(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Bench",
            "Bench",
            1,
            5,
            rounded(_1rms[1]*.60).toInt())
    }

    private fun Beta_Set_20(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Bench",
            "Bench",
            1,
            5,
            rounded(_1rms[1]*.65).toInt())
    }

    private fun Beta_Set_21(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Bench",
            "Bench",
            1,
            5,
            rounded(_1rms[1]*.70).toInt())
    }
    private fun Beta_Set_22(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Bench",
            "Bench",
            1,
            5,
            rounded(_1rms[1]*.75).toInt())
    }




    private fun Beta_Set_23(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Deadlift",
            "Deadlift",
            1,
            5,
            rounded(_1rms[2]*.65).toInt())
    }

    private fun Beta_Set_24(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Deadlift",
            "Deadlift",
            1,
            5,
            rounded(_1rms[2]*.75).toInt())
    }

    private fun Beta_Set_25(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Deadlift",
            "Deadlift",
            1,
            3,
            rounded(_1rms[2]*.85).toInt())
    }

    private fun Beta_Set_26(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Deadlift",
            "Deadlift",
            1,
            1,
            rounded(_1rms[2]*.90).toInt())
    }

    private fun Beta_Set_27(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Deadlift",
            "Deadlift",
            1,
            1,
            rounded(_1rms[2]*.95).toInt())
    }

    private fun Beta_Set_28(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Deadlift",
            "Deadlift",
            1,
            5,
            rounded(_1rms[2]*.80).toInt())
    }

    private fun Beta_Set_29(): Session{
        return Session(0,
            "Week ${passesComplete + 1}, Day $day - Deadlift",
            "Deadlift",
            1,
            5,
            rounded(_1rms[2]*.75).toInt())
    }


    //Math stuff
    fun rounded(f: Double): BigDecimal
    {
        val bd = BigDecimal(f).round(MathContext(3))
        return applyIncrement(bd)
    }

    fun applyMultiplier(f: BigDecimal) : BigDecimal
    {

        val bd = f * (BigDecimal(multiplier))
        return applyIncrement(bd)
    }

    fun applyIncrement(bd: BigDecimal) : BigDecimal
    {
        return bd + BigDecimal(increment * passesComplete)
    }

}