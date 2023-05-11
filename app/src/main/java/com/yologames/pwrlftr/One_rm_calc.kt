package com.yologames.pwrlftr

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.*
import android.widget.*
import androidx.core.view.isVisible
import java.math.BigDecimal
import java.math.RoundingMode

class One_rm_calc: Fragment() {



    lateinit var calculateMaxButton: Button
    lateinit var inputMaxBox: TextView


    lateinit var string_02 : String
    lateinit var overrideString : String


    //Please for the love of fuck make the below into a list somehow. 13/11/2022 - Mat
    lateinit var outputBox_01 : TextView
    lateinit var outputBox_02 : TextView
    lateinit var outputBox_03 : TextView
    lateinit var outputBox_04 : TextView
    lateinit var outputBox_05 : TextView
    lateinit var outputBox_06 : TextView
    lateinit var outputBox_07 : TextView
    lateinit var outputBox_08 : TextView
    lateinit var outputBox_09 : TextView
    lateinit var outputBox_10 : TextView
    lateinit var outputBox_12 : TextView

    lateinit var overrideSwitch : Switch
    var localOverrideSwitch : Boolean = false


    var offsetValue: Double = 0.0
    lateinit var overrideExplainTextBox : TextView
    lateinit var overrideTextInputBox : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one_rm_calc, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calculateMaxButton = view.findViewById(R.id.calculate_1rm_button)
        inputMaxBox = view.findViewById(R.id.enter_1rm_textbox)

        overrideSwitch = view.findViewById(R.id.switch1)
        overrideExplainTextBox = view.findViewById(R.id.overrideTextExplain)
        overrideExplainTextBox.isVisible = false
        overrideTextInputBox = view.findViewById(R.id.overrideTextInput)
        overrideTextInputBox.isVisible = false



        outputBox_01 = view.findViewById(R.id.output_text_view_1)
        outputBox_02 = view.findViewById(R.id.output_text_view_2)
        outputBox_03 = view.findViewById(R.id.output_text_view_3)
        outputBox_04 = view.findViewById(R.id.output_text_view_4)
        outputBox_05 = view.findViewById(R.id.output_text_view_5)
        outputBox_06 = view.findViewById(R.id.output_text_view_6)
        outputBox_07 = view.findViewById(R.id.output_text_view_7)
        outputBox_08 = view.findViewById(R.id.output_text_view_8)
        outputBox_09 = view.findViewById(R.id.output_text_view_9)
        outputBox_10 = view.findViewById(R.id.output_text_view_10)
        outputBox_12 = view.findViewById(R.id.output_text_view_12)

        outputBox_01.visibility = View.INVISIBLE
        outputBox_02.visibility = View.INVISIBLE
        outputBox_03.visibility = View.INVISIBLE
        outputBox_04.visibility = View.INVISIBLE
        outputBox_05.visibility = View.INVISIBLE
        outputBox_06.visibility = View.INVISIBLE
        outputBox_07.visibility = View.INVISIBLE
        outputBox_08.visibility = View.INVISIBLE
        outputBox_09.visibility = View.INVISIBLE
        outputBox_10.visibility = View.INVISIBLE
        outputBox_12.visibility = View.INVISIBLE

        calculateMaxButton.setOnClickListener {
            ToggleOverride()
            if (inputMaxBox.text.isNotEmpty()) {
                calculateMax()
            }
        }

        //Below is very important for checking switch status. Thanks to this top G on SO https://stackoverflow.com/questions/11278507/android-widget-switch-on-off-event-listener
        //isChecked is true if the switch is currently checked (ON), and false otherwise.
        overrideSwitch.setOnCheckedChangeListener {_, isChecked ->
            ToggleOverride()
        }




        inputMaxBox.setOnKeyListener(View.OnKeyListener({v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN){
                if (inputMaxBox.text.isNotEmpty()) {
                    calculateMax()
                }

                return@OnKeyListener true
            }
            false
        }))

        overrideTextInputBox.setOnKeyListener(View.OnKeyListener({v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN){
                if (overrideTextInputBox.text.isNotEmpty()) {
                    calculateMax()
                }
                if (!overrideTextInputBox.text.isNotEmpty()) {
                    offsetValue = 0.0
                    calculateMax()
                }
                return@OnKeyListener true
            }
            false
        }))
    }

    fun ToggleOverride()
    {
        if (!overrideSwitch.isChecked) {
            overrideExplainTextBox.isVisible = false
            overrideTextInputBox.isVisible = false
            offsetValue = 0.0

        }

        if (overrideSwitch.isChecked) {
            overrideExplainTextBox.isVisible = true
            overrideTextInputBox.isVisible = true
            if (overrideTextInputBox.text.isNotEmpty()) {
                overrideString = overrideTextInputBox.text.toString()
                offsetValue = overrideString.toDouble()/100
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    fun calculateMax()
    {

        if (inputMaxBox.text.toString().toFloat() > 3000) {
            string_02 = inputMaxBox.text.toString()
            // outputBox_01.text = " (Error) \n Please use a number < 3000"
            Toast.makeText(requireContext(), "Error 1\n Value cannot exceed 3000", Toast.LENGTH_SHORT).show()

            // outputBox_01.visibility = View.VISIBLE
            setAllInVisible()
        }

        if (offsetValue > 0.05|| offsetValue < -0.05)
        {
            //outputBox_01.text = " (Error) \n Offset cannot exceed 5%"
            Toast.makeText(requireContext(), "Error 2\n Offset cannot exceed 5%", Toast.LENGTH_SHORT).show()
            //outputBox_01.visibility = View.VISIBLE
            setAllInVisible()
        }

        if (inputMaxBox.text.toString().toFloat() <= 3000)
        {

            ToggleOverride()
            if (offsetValue <= 0.05 && offsetValue > -0.05){
                string_02 = inputMaxBox.text.toString()

                outputBox_01.text = " 1 Rep Max - "+(string_02).toString()
                outputBox_02.text = " 2 Rep Max - "+(BigDecimal(string_02.toDouble()*0.95f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
                outputBox_03.text = " 3 Rep Max - "+(BigDecimal(string_02.toDouble()*0.92f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
                outputBox_04.text = " 4 Rep Max - "+(BigDecimal(string_02.toDouble()*0.90f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
                outputBox_05.text = " 5 Rep Max - "+(BigDecimal(string_02.toDouble()*0.86f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
                outputBox_06.text = " 6 Rep Max - "+(BigDecimal(string_02.toDouble()*0.84f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
                outputBox_07.text = " 7 Rep Max - "+(BigDecimal(string_02.toDouble()*0.82f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
                outputBox_08.text = " 8 Rep Max - "+(BigDecimal(string_02.toDouble()*0.80f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
                outputBox_09.text = " 9 Rep Max - "+(BigDecimal(string_02.toDouble()*0.775f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
                outputBox_10.text = "10 Rep Max - "+(BigDecimal(string_02.toDouble()*0.75f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
                outputBox_12.text = "12 Rep Max - "+(BigDecimal(string_02.toDouble()*0.69f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()

                setAllVisible()
            }

        }
    }



    fun setAllInVisible()
    {
        outputBox_01.visibility = View.INVISIBLE
        outputBox_02.visibility = View.INVISIBLE
        outputBox_03.visibility = View.INVISIBLE
        outputBox_04.visibility = View.INVISIBLE
        outputBox_05.visibility = View.INVISIBLE
        outputBox_06.visibility = View.INVISIBLE
        outputBox_07.visibility = View.INVISIBLE
        outputBox_08.visibility = View.INVISIBLE
        outputBox_09.visibility = View.INVISIBLE
        outputBox_10.visibility = View.INVISIBLE
        outputBox_12.visibility = View.INVISIBLE
    }

    fun setAllVisible()
    {
        outputBox_01.visibility = View.VISIBLE
        outputBox_02.visibility = View.VISIBLE
        outputBox_03.visibility = View.VISIBLE
        outputBox_04.visibility = View.VISIBLE
        outputBox_05.visibility = View.VISIBLE
        outputBox_06.visibility = View.VISIBLE
        outputBox_07.visibility = View.VISIBLE
        outputBox_08.visibility = View.VISIBLE
        outputBox_09.visibility = View.VISIBLE
        outputBox_10.visibility = View.VISIBLE
        outputBox_12.visibility = View.VISIBLE
    }


}