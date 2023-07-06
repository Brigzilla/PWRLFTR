package com.yologames.pwrlftr

import com.yologames.pwrlftr.room.Session

//**
//TODO: Class should select each session before selecting the same one again
//**

class CardioSessionGenerator {
    private val cardioList = ArrayList<Session>()
    private var previousSession: Session? = null

    init {
        buildList()
    }

    fun generateCardio(): Session {
        val availableSessions = cardioList.filter { it != previousSession }

        if (availableSessions.isEmpty()) {
            // Handle the case where all sessions have been selected,
            // or there is only one session available
            return cardioList.random()
        }

        val selectedSession = availableSessions.random()
        previousSession = selectedSession
        return selectedSession
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
            "",
            false
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
            "",
            false
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
            "",
            false
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
            "",
            false
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
            "",
            false
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
            "",
            false
        ))
    }

}