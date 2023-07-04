package com.yologames.pwrlftr

import com.yologames.pwrlftr.room.Session

val cardioList = ArrayList<Session>()

class CardioSessionGenerator {


    fun generateCardio(): Session{
        buildList()
        return cardioList.random()
    }

    private fun buildList() {
        cardioList.add(Session(0,
            "-NULL-",
            "Row",
            "10 Minutes, 22 s/m",
            "5 Intervals of 500m - 1 Minute rest",
            "5 Minutes, 20 s/m",
            "3 Minutes, 15 s/m",
            "",
            "",
            "",
            "",
            "",
            ""
        ))

        cardioList.add(Session(0,
            "-NULL-",
            "Cycle",
            "10 Minutes, Low intensity - Warm-up",
            "40 Minutes, Steady pace",
            "10 minutes, Low intensity - Cool-down",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
        ))
    }

}