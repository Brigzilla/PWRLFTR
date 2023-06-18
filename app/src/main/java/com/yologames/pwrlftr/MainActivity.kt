package com.yologames.pwrlftr
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        _session_feedback_left = loadBooleanListFromPrefs("session_feedback_list") as ArrayList<Boolean>
//        _passesAllowable = loadIntFromPrefs("passes_allowable", 1)
//        _sessions_reviewed = loadIntFromPrefs("sessions_reviewed", 5)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun saveIntToPrefs(key: String, value: Int) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        // Save the integer to preferences
        editor.putInt(key, value)
        editor.apply()
    }

    fun loadIntFromPrefs(key: String, defaultValue: Int): Int {
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Retrieve the integer from preferences
        return sharedPreferences.getInt(key, defaultValue)
    }



    fun saveBooleanListToPrefs(key: String, booleanList: List<Boolean>) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        // Convert the boolean list to a comma-separated string
        val booleanString = booleanList.joinToString(",")

        // Save the string to preferences
        editor.putString(key, booleanString)
        editor.apply()
    }

    fun loadBooleanListFromPrefs(key: String): List<Boolean> {
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Retrieve the string from preferences
        val booleanString = sharedPreferences.getString(key, "")

        // Convert the string back to a list of booleans
        val booleanList = booleanString?.split(",")?.map { it.toBoolean() } ?: emptyList()
        return booleanList
    }




}