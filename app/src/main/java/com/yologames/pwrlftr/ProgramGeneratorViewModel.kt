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
    var sessions_generated : Int = 0
//    var passesAllowable: Int = 1
    var day: Int = 1
    var dayExpected = 3

    fun createNextWeek(): ArrayList<Session>{
        day = 1

        //Squat
        trainingProgram.add(Beta_Set_1())
        sessions_generated++
        //Bench
        trainingProgram.add(Beta_Set_2())
        sessions_generated++
        day = 2
        //Squat
        trainingProgram.add(Beta_Set_3())
        sessions_generated++
        //Bench
        trainingProgram.add(Beta_Set_4())
        sessions_generated++
        day = 3
        //Deadlift
        trainingProgram.add(Beta_Set_5())
        sessions_generated++
        Log.d("FATAL", sessions_generated.toString())

            passesComplete++
            _weeks = passesComplete
            day = 1
            _passesAllowable = 0

        return trainingProgram
    }


    fun createBetaProgram(): ArrayList<Session>{
        while (_passesAllowable > 0){
            if (day == 1) {
                //Squat
                trainingProgram.add(Beta_Set_1())
                sessions_generated++
                //Bench
                trainingProgram.add(Beta_Set_2())
                sessions_generated++
            }
            if (day == 2) {
                //Squat
                trainingProgram.add(Beta_Set_3())
                sessions_generated++
                //Bench
                trainingProgram.add(Beta_Set_4())
                sessions_generated++
            }
            if (day == 3) {
                //Deadlift
                trainingProgram.add(Beta_Set_5())
                sessions_generated++
            }

            if (day <= dayExpected) {
                day++
            }
            if (day > dayExpected){
                passesComplete++
                _weeks = passesComplete
                day = 1
                _passesAllowable = 0
            }

        }

        return trainingProgram
    }

    private fun Beta_Set_1(): Session{
        return Session(0,
            "${sessions_generated}_Week ${passesComplete + 1}, Day $day - Squat",
            "Squat",
            "1 * 5 at ${rounded(_1rms[0]*.7).toInt()}",
            "1 * 5 at ${rounded(_1rms[0]*.7).toInt()}",
            "1 * 2 at ${rounded(_1rms[0]*.8).toInt()}",
            "1 * 1 at ${rounded(_1rms[0]*.85).toInt()}",
            "1 * 1 at ${rounded(_1rms[0]*.9).toInt()}",
            "1 * 5 at ${rounded(_1rms[0]*.8).toInt()}",
            "1 * 5 at ${rounded(_1rms[0]*.75).toInt()}",
            "",
            "",
            "")
    }
    private fun Beta_Set_2(): Session{
        return Session(0,
            "${sessions_generated}_Week ${passesComplete + 1}, Day $day - Bench",
            "Bench",
            "1 * 5 at ${rounded(_1rms[1]*.7).toInt()}",
            "1 * 3 at ${rounded(_1rms[1]*.75).toInt()}",
            "1 * 2 at ${rounded(_1rms[1]*.8).toInt()}",
            "1 * 1 at ${rounded(_1rms[1]*.85).toInt()}",
            "1 * 1 at ${rounded(_1rms[1]*.9).toInt()}",
            "1 * 5 at ${rounded(_1rms[1]*.8).toInt()}",
            "1 * 5 at ${rounded(_1rms[1]*.75).toInt()}",
            "",
            "",
            "")
    }

    private fun Beta_Set_3(): Session{
        return Session(0,
            "${sessions_generated}_Week ${passesComplete + 1}, Day $day - Squat",
            "Squat",
            "1 * 5 at ${rounded(_1rms[0]*.6).toInt()}",
            "1 * 5 at ${rounded(_1rms[0]*.65).toInt()}",
            "1 * 5 at ${rounded(_1rms[0]*.7).toInt()}",
            "1 * 5 at ${rounded(_1rms[0]*.75).toInt()}",
            "",
            "",
            "",
            "",
            "",
            "")
    }

    private fun Beta_Set_4(): Session{
        return Session(0,
            "${sessions_generated}_Week ${passesComplete + 1}, Day $day - Bench",
            "Bench",
            "1 * 5 at ${rounded(_1rms[1]*.6).toInt()}",
            "1 * 3 at ${rounded(_1rms[1]*.65).toInt()}",
            "1 * 2 at ${rounded(_1rms[1]*.7).toInt()}",
            "1 * 1 at ${rounded(_1rms[1]*.75).toInt()}",
            "",
            "",
            "",
            "",
            "",
            "")
    }
    private fun Beta_Set_5(): Session{
        return Session(0,
            "${sessions_generated}_Week ${passesComplete + 1}, Day $day - Deadlift",
            "Deadlift",
            "1 * 5 at ${rounded(_1rms[2]*.65).toInt()}",
            "1 * 5 at ${rounded(_1rms[2]*.75).toInt()}",
            "1 * 3 at ${rounded(_1rms[2]*.85).toInt()}",
            "1 * 1 at ${rounded(_1rms[2]*.9).toInt()}",
            "1 * 1 at ${rounded(_1rms[2]*.95).toInt()}",
            "1 * 5 at ${rounded(_1rms[2]*.8).toInt()}",
            "1 * 5 at ${rounded(_1rms[2]*.75).toInt()}",
            "",
            "",
            "")
    }
//    private fun Beta_Set_11(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Bench",
//            "Bench",
//            1,
//            1,
//            rounded(_1rms[1]*.85).toInt(),
//            "")
//    }
//    private fun Beta_Set_12(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Bench",
//            "Bench",
//            1,
//            1,
//            rounded(_1rms[1]*.90).toInt(),
//            "")
//    }
//    private fun Beta_Set_13(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Bench",
//            "Bench",
//            1,
//            5,
//            rounded(_1rms[1]*.80).toInt(),
//            "")
//    }
//
//    private fun Beta_Set_14(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Bench",
//            "Bench",
//            1,
//            5,
//            rounded(_1rms[1]*.75).toInt(),
//            "")
//    }
//
//
//
//    private fun Beta_Set_15(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Squat",
//            "Squat",
//            1,
//            5,
//            rounded(_1rms[0]*.60).toInt(),
//            "")
//    }
//
//    private fun Beta_Set_16(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Squat",
//            "Squat",
//            1,
//            5,
//            rounded(_1rms[0]*.65).toInt(),
//            "")
//    }
//
//    private fun Beta_Set_17(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Squat",
//            "Squat",
//            1,
//            5,
//            rounded(_1rms[0]*.70).toInt(),
//            "")
//    }
//
//    private fun Beta_Set_18(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Squat",
//            "Squat",
//            1,
//            5,
//            rounded(_1rms[0]*.75).toInt(),
//            "")
//    }
//
//
//
//    private fun Beta_Set_19(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Bench",
//            "Bench",
//            1,
//            5,
//            rounded(_1rms[1]*.60).toInt(),
//            "")
//    }
//
//    private fun Beta_Set_20(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Bench",
//            "Bench",
//            1,
//            5,
//            rounded(_1rms[1]*.65).toInt(),
//            "")
//    }
//
//    private fun Beta_Set_21(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Bench",
//            "Bench",
//            1,
//            5,
//            rounded(_1rms[1]*.70).toInt(),
//            "")
//    }
//    private fun Beta_Set_22(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Bench",
//            "Bench",
//            1,
//            5,
//            rounded(_1rms[1]*.75).toInt(),
//            "")
//    }
//
//
//
//
//    private fun Beta_Set_23(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Deadlift",
//            "Deadlift",
//            1,
//            5,
//            rounded(_1rms[2]*.65).toInt(),
//            "")
//    }
//
//    private fun Beta_Set_24(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Deadlift",
//            "Deadlift",
//            1,
//            5,
//            rounded(_1rms[2]*.75).toInt(),
//            "")
//    }
//
//    private fun Beta_Set_25(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Deadlift",
//            "Deadlift",
//            1,
//            3,
//            rounded(_1rms[2]*.85).toInt(),
//            "")
//    }
//
//    private fun Beta_Set_26(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Deadlift",
//            "Deadlift",
//            1,
//            1,
//            rounded(_1rms[2]*.90).toInt(),
//            "")
//    }
//
//    private fun Beta_Set_27(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Deadlift",
//            "Deadlift",
//            1,
//            1,
//            rounded(_1rms[2]*.95).toInt(),
//            "")
//    }
//
//    private fun Beta_Set_28(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Deadlift",
//            "Deadlift",
//            1,
//            5,
//            rounded(_1rms[2]*.80).toInt(),
//            "")
//    }
//
//    private fun Beta_Set_29(): Session{
//        return Session(0,
//            "Week ${passesComplete + 1}, Day $day - Deadlift",
//            "Deadlift",
//            1,
//            5,
//            rounded(_1rms[2]*.75).toInt(),
//            "")
//    }


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