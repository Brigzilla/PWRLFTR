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
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.yologames.pwrlftr.recyclerview.PCardViewHolder
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity(), PCardViewHolder.PCardViewHolderListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        _session_feedback_left.clear()
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

    fun saveBooleanToPrefs(key: String, booleanList: List<Boolean>, index: Int) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        // Update the value at the specified index in the boolean list
        val updatedList = booleanList.toMutableList()
        updatedList[index] = true

        // Convert the updated boolean list to a comma-separated string
        val booleanString = updatedList.joinToString(",")

        // Save the string to preferences
        editor.putString(key, booleanString)
        editor.apply()
        Log.d("FATAL", "Saved")
    }


    fun loadBooleanListFromPrefs(key: String): List<Boolean> {
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Retrieve the string from preferences
        val booleanString = sharedPreferences.getString(key, "")

        // Convert the string back to a list of booleans
        val booleanList = booleanString?.split(",")?.map { it.toBoolean() } ?: emptyList()
        return booleanList
    }

    fun loadFloat(key: String): Float {
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getFloat(key, 0.1f)
    }

    fun saveFloat(key: String, value: Float) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    override fun onItemClicked() {
        saveBooleanListToPrefs(
            "session_feedback_list",
            _session_feedback_left
        )
    }

}