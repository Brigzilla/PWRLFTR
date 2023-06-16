package com.yologames.pwrlftr

import androidx.lifecycle.*
import com.yologames.pwrlftr.room.Session
import java.math.BigDecimal
import java.math.MathContext

class ProgramGeneratorViewModel : ViewModel() {

    var _1rms = ArrayList<Float>()
    //    val sesh3 = Session(0, "Week 3", "Bench", 2, 4, 130)
    val trainingProgram = ArrayList<Session>()


    var multiplier : Double = 1.00

    var increment : Double = 2.5

    var passesComplete : Int = 0
    var passedExpected : Int = 5
    var day: Int = 1
    var dayExpected = 3


    init {
        _1rms.add( 300.0f) //Squat
        _1rms.add( 230.0f) //Bench
        _1rms.add( 300.0f) //Deadlift
    }


    fun createBetaProgram(): ArrayList<Session>{
        while (passesComplete < passedExpected) {
            if (day == 1) {
//                createDay_1()
                //Squat
                trainingProgram.add(Beta_Set_1())
                trainingProgram.add(Beta_Set_2())
                trainingProgram.add(Beta_Set_3())
                trainingProgram.add(Beta_Set_4())
                trainingProgram.add(Beta_Set_5())
                trainingProgram.add(Beta_Set_6())
                trainingProgram.add(Beta_Set_7())

                //Bench
                trainingProgram.add(Beta_Set_8())
                trainingProgram.add(Beta_Set_9())
                trainingProgram.add(Beta_Set_10())
                trainingProgram.add(Beta_Set_11())
                trainingProgram.add(Beta_Set_12())
                trainingProgram.add(Beta_Set_13())
                trainingProgram.add(Beta_Set_14())
            }
            if (day == 2) {
//                createDay_2()
                //Squat
                trainingProgram.add(Beta_Set_15())
                trainingProgram.add(Beta_Set_16())
                trainingProgram.add(Beta_Set_17())
                trainingProgram.add(Beta_Set_18())

                //Bench
                trainingProgram.add(Beta_Set_19())
                trainingProgram.add(Beta_Set_20())
                trainingProgram.add(Beta_Set_21())
                trainingProgram.add(Beta_Set_22())
            }
            if (day == 3) {
//                createDay_3()
                //Deadlift
                trainingProgram.add(Beta_Set_23())
                trainingProgram.add(Beta_Set_24())
                trainingProgram.add(Beta_Set_25())
                trainingProgram.add(Beta_Set_26())
                trainingProgram.add(Beta_Set_27())
                trainingProgram.add(Beta_Set_28())
                trainingProgram.add(Beta_Set_29())
            }

            if (day <= dayExpected) {
                day++
            }
            if (day > dayExpected){
                passesComplete ++
                day = 1
            }
        }
        return trainingProgram
    }

    private fun createDay_1(){

        //Squat
        trainingProgram.add(Beta_Set_1())
        trainingProgram.add(Beta_Set_2())
        trainingProgram.add(Beta_Set_3())
        trainingProgram.add(Beta_Set_4())
        trainingProgram.add(Beta_Set_5())
        trainingProgram.add(Beta_Set_6())
        trainingProgram.add(Beta_Set_7())

        //Bench
        trainingProgram.add(Beta_Set_8())
        trainingProgram.add(Beta_Set_9())
        trainingProgram.add(Beta_Set_10())
        trainingProgram.add(Beta_Set_11())
        trainingProgram.add(Beta_Set_12())
        trainingProgram.add(Beta_Set_13())
        trainingProgram.add(Beta_Set_14())
    }

    private fun createDay_2() {
        //Squat
        trainingProgram.add(Beta_Set_15())
        trainingProgram.add(Beta_Set_16())
        trainingProgram.add(Beta_Set_17())
        trainingProgram.add(Beta_Set_18())

        //Bench
        trainingProgram.add(Beta_Set_19())
        trainingProgram.add(Beta_Set_20())
        trainingProgram.add(Beta_Set_21())
        trainingProgram.add(Beta_Set_22())

    }
    private fun createDay_3() {
        //Deadlift
        trainingProgram.add(Beta_Set_23())
        trainingProgram.add(Beta_Set_24())
        trainingProgram.add(Beta_Set_25())
        trainingProgram.add(Beta_Set_26())
        trainingProgram.add(Beta_Set_27())
        trainingProgram.add(Beta_Set_28())
        trainingProgram.add(Beta_Set_29())
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

//**
    //TODO: Below is the Alpha approach where the program is generated as a string. It works well, but functionally it won't scale. Use the program outlined below and create that above
    //Mat - 14/6/2023
    //**


    fun createAlphaProgram(): ArrayList<Session>{
        trainingProgram.clear()
        trainingProgram.add(Alpha_Session_1())
        trainingProgram.add(Alpha_Session_2())
        trainingProgram.add(Alpha_Session_3())
        passesComplete += 1
        trainingProgram.add(Alpha_Session_1())
        trainingProgram.add(Alpha_Session_2())
        trainingProgram.add(Alpha_Session_3())
        passesComplete += 1
        trainingProgram.add(Alpha_Session_1())
        trainingProgram.add(Alpha_Session_2())
        trainingProgram.add(Alpha_Session_3())
        passesComplete += 1
        trainingProgram.add(Alpha_Session_1())
        trainingProgram.add(Alpha_Session_2())
        trainingProgram.add(Alpha_Session_3())


        return trainingProgram

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
            "Week ${passesComplete + 1}, Day 1",
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
            "Week ${passesComplete + 1}, Day 3",
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
            "Week ${passesComplete + 1}, Day 5",
            sessionAspect.toString().substringAfter("[").substringBefore("]"),
            0, 0, 0)
    }

}