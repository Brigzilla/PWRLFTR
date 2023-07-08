package com.yologames.pwrlftr

import android.util.Log
import androidx.lifecycle.*
import com.yologames.pwrlftr.room.Session
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.runBlocking
import java.math.BigDecimal
import java.math.MathContext

class ProgramGeneratorViewModel : ViewModel() {




    var multiplier : Double = 1.00

    var increment : Double = 2.5

    var passesComplete : Int = 0
    var sessions_generated : Int = 0
    var day: Int = 1

    val cSessionGenerator = CardioSessionGenerator()

    fun createNextWeek(): ArrayList<Session>{
        val trainingProgram = ArrayList<Session>()
        day =1
        runBlocking(coroutineContext) {
            trainingProgram.add(Beta_Set_1())
            sessions_generated++
            trainingProgram.add(Beta_Set_2())
            sessions_generated++

            day++
            trainingProgram.add(generateCardio())

            sessions_generated++

            day++
            trainingProgram.add(Beta_Set_3())
            sessions_generated++
            trainingProgram.add(Beta_Set_4())
            sessions_generated++

            day++
            trainingProgram.add(generateCardio())
            sessions_generated++

            day++
            trainingProgram.add(Beta_Set_5())
            sessions_generated++
        }

        passesComplete++
        _weeks = passesComplete
        day = 1
        _passesAllowable = 0

        return trainingProgram
    }

    private fun generateCardio(): Session{
       val cSession = cSessionGenerator.generateCardio()
        cSession.title = "${1000+sessions_generated}_Week ${passesComplete + 1}, Day $day - ${cSession.exercise}"
        return cSession
    }

    private fun Beta_Set_1(): Session{
        return Session(0,
            "${1000+sessions_generated}_Week ${passesComplete + 1}, Day $day - Squat",
            "Squat",
            "1 * 5 at ${rounded("Squat",_1rms[0]*.7).toInt()}",
            "1 * 3 at ${rounded("Squat",_1rms[0]*.75).toInt()}",
            "1 * 2 at ${rounded("Squat",_1rms[0]*.8).toInt()}",
            "1 * 1 at ${rounded("Squat",_1rms[0]*.85).toInt()}",
            "1 * 1 at ${rounded("Squat",_1rms[0]*.9).toInt()}",
            "1 * 5 at ${rounded("Squat",_1rms[0]*.8).toInt()}",
            "1 * 5 at ${rounded("Squat",_1rms[0]*.75).toInt()}",
            "",
            "",
            "",
        true)
    }
    private fun Beta_Set_2(): Session{
        return Session(0,
            "${1000+sessions_generated}_Week ${passesComplete + 1}, Day $day - Bench",
            "Bench",
            "1 * 5 at ${rounded("Bench",_1rms[1]*.7).toInt()}",
            "1 * 3 at ${rounded("Bench",_1rms[1]*.75).toInt()}",
            "1 * 2 at ${rounded("Bench",_1rms[1]*.8).toInt()}",
            "1 * 1 at ${rounded("Bench",_1rms[1]*.85).toInt()}",
            "1 * 1 at ${rounded("Bench",_1rms[1]*.9).toInt()}",
            "1 * 5 at ${rounded("Bench",_1rms[1]*.8).toInt()}",
            "1 * 5 at ${rounded("Bench",_1rms[1]*.75).toInt()}",
            "",
            "",
            "",
            true)
    }

    private fun Beta_Set_3(): Session{
        return Session(0,
            "${1000+sessions_generated}_Week ${passesComplete + 1}, Day $day - Squat",
            "Squat",
            "1 * 5 at ${rounded("Squat",_1rms[0]*.6).toInt()}",
            "1 * 5 at ${rounded("Squat",_1rms[0]*.65).toInt()}",
            "1 * 5 at ${rounded("Squat",_1rms[0]*.7).toInt()}",
            "1 * 5 at ${rounded("Squat",_1rms[0]*.75).toInt()}",
            "",
            "",
            "",
            "",
            "",
            "",
            true)
    }

    private fun Beta_Set_4(): Session{
        return Session(0,
            "${1000+sessions_generated}_Week ${passesComplete + 1}, Day $day - Bench",
            "Bench",
            "1 * 5 at ${rounded("Bench",_1rms[1]*.6).toInt()}",
            "1 * 5 at ${rounded("Bench",_1rms[1]*.65).toInt()}",
            "1 * 5 at ${rounded("Bench",_1rms[1]*.7).toInt()}",
            "1 * 5 at ${rounded("Bench",_1rms[1]*.75).toInt()}",
            "",
            "",
            "",
            "",
            "",
            "",
            true)
    }
    private fun Beta_Set_5(): Session{
        return Session(0,
            "${1000+sessions_generated}_Week ${passesComplete + 1}, Day $day - Deadlift",
            "Deadlift",
            "1 * 5 at ${rounded("Deadlift",_1rms[2]*.65).toInt()}",
            "1 * 5 at ${rounded("Deadlift",_1rms[2]*.75).toInt()}",
            "1 * 3 at ${rounded("Deadlift",_1rms[2]*.85).toInt()}",
            "1 * 1 at ${rounded("Deadlift",_1rms[2]*.9).toInt()}",
            "1 * 1 at ${rounded("Deadlift",_1rms[2]*.95).toInt()}",
            "1 * 5 at ${rounded("Deadlift",_1rms[2]*.8).toInt()}",
            "1 * 5 at ${rounded("Deadlift",_1rms[2]*.75).toInt()}",
            "",
            "",
            "",
            true)
    }

    //Math stuff
    fun rounded(exercise : String ,f: Double): BigDecimal
    {
        val bd = BigDecimal(f).round(MathContext(3))
        return applyIncrement(exercise, bd)
    }
//
    fun applyMultiplier(exercise: String, f: Double) : BigDecimal
    {

        val bd = f * multiplier
//        if (exercise == "Squat"&& !feedback_offset_squat.isNaN()) return BigDecimal(bd + ((10-feedback_offset_squat)))
//        if (exercise == "Bench"&& !feedback_offset_bench.isNaN())return BigDecimal(bd + ((10-feedback_offset_bench)))
//        if (exercise == "Deadlift" && !feedback_offset_deadl.isNaN())return BigDecimal(bd + ((10-feedback_offset_deadl)))
//        if (exercise == "Squat"&& !feedback_offset_squat.isNaN()) return BigDecimal(bd + +(5-(feedback_offset_squat))/2)
//        if (exercise == "Bench"&& !feedback_offset_bench.isNaN()) return BigDecimal(bd + +(5-(feedback_offset_bench))/2)
//        if (exercise == "Deadlift" && !feedback_offset_deadl.isNaN()) return BigDecimal(bd + +(5-(feedback_offset_deadl))/2)
        if (exercise == "Squat"&& !feedback_offset_squat.isNaN()) return BigDecimal((bd +(5-(feedback_offset_squat))/1.5))
        if (exercise == "Bench"&& !feedback_offset_bench.isNaN()) return BigDecimal((bd +(5-(feedback_offset_bench))/1.5))
        if (exercise == "Deadlift" && !feedback_offset_deadl.isNaN()) return BigDecimal((bd +(5-(feedback_offset_deadl))/1.5))

        else return BigDecimal(bd)

    }

    fun applyIncrement(exercise: String, bd: BigDecimal) : BigDecimal
    {
//        Log.d ("FATAL", "bd with multiplier${bd + applyMultiplier(exercise,increment  * passesComplete)}")
//        Log.d ("FATAL", "bd ${bd}")
        return bd + applyMultiplier(exercise,increment  * passesComplete)
    }

}