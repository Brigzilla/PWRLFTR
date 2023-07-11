package com.yologames.pwrlftr

import com.yologames.pwrlftr.room.Session

var _passesAllowable : Int = 1

var _weeks : Int = 0

var _sessions_reviewed : Int = 0

var _session_feedback_left = ArrayList<Boolean>()

var _1rms = arrayListOf<Float>(0.0f,0.0f,0.0f)

var feedback_offset_squat: Float = 0.1f
var feedback_offset_bench: Float = 0.1f
var feedback_offset_deadl: Float = 0.1f

val s_session_feedback_list = "session_feedback_list"
val s_week = "weeks"
val s_complete = "complete"
val s_day = "day"
val s_s1rm = "s1rm"
val s_b1rm = "b1rm"
val s_d1rm = "d1rm"
val s_sgenerated = "sgenerated"
val s_fbo_s = "feedbackoffset_s"
val s_fbo_b = "feedbackoffset_b"
val s_fbo_d = "feedbackoffset_d"

var tutorial_Progesssion = 0
val tutorial_String = listOf(
    "Have Fun",
    "When you've finished giving feedback for the week, the next week will be generated",
    "Note, your response can't be edited once you've submitted it",
    "Once you've reviewed the whole session, click the tick button",
    "Left is easy, Right is hard, but try not to use extremes",
    "Move the slider to adjust how difficult you found the set",
    "Each set has a slider which lets you rate the set out of 10",
    "Once you've finished a session, click the feedback button",
    "Next time you open the app, you'll go straight to your program",
    "Once you're happy, click the pen below",
    "If in doubt, undershoot slightly",
    "Enter your current one rep maxes above",
    "Hello, and welcome to PWRLFTR")
