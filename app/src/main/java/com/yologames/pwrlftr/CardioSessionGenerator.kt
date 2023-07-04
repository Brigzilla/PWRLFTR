package com.yologames.pwrlftr

import com.yologames.pwrlftr.room.Session



class CardioSessionGenerator {
    private val cardioList = ArrayList<Session>()

    fun generateCardio(): Session{
        buildList()
        return cardioList.random()
    }

    private fun buildList() {
        cardioList.add(Session(0,
            "-NULL-",
            "Row Intervals",
            "10 Minutes, 22 s/m - Warm-up",
            "500m Interval, High intensity",
            "1 Minute rest",
            "Repeat 5 times",
            "5 Minutes, 20 s/m - Pre-cool-down",
            "3 Minutes, 15 s/m - Cool-down",
            "",
            "",
            "",
            ""
        ))

        cardioList.add(Session(0,
            "-NULL-",
            "Cycle Steady",
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

        cardioList.add(Session(0,
            "-NULL-",
            "Run Steady",
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

        cardioList.add(Session(0,
            "-NULL-",
            "Cycle Intervals",
            "10 Minutes, Low intensity - Warm-up",
            "5 Minutes, High intensity",
            "2 Minutes, Low intensity",
            "Repeat 5 times",
            "10 minutes, Low intensity - Cool-down",
            "",
            "",
            "",
            "",
            ""
        ))

        cardioList.add(Session(0,
            "-NULL-",
            "Row Steady",
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

        cardioList.add(Session(0,
            "-NULL-",
            "Cycle Intervals",
            "15 Minutes, Low intensity - Warm-up",
            "20 Minutes, High intensity - Intervals",
            "10 Minutes - Steady Pace",
            "5 Minutes - Cool-down",
            "",
            "",
            "",
            "",
            "",
            ""
        ))
    }

}