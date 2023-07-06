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

