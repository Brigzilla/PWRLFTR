package com.yologames.pwrlftr

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Rep_Max_Calc : Fragment() {

    lateinit var input_reps_box : TextView
    lateinit var input_weight_box: TextView

    lateinit var output_text_view: TextView
    lateinit var calculate_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rep__max__calc, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        calculate_button  = view.findViewById(R.id.calculate_button)
        input_reps_box = view.findViewById(R.id.enter_reps_textbox)
        input_weight_box = view.findViewById(R.id.enter_weight_textbox)
        output_text_view = view.findViewById(R.id.output_text_view_1)

        output_text_view.visibility = View.INVISIBLE

        calculate_button.setOnClickListener{
           output_text_view.text = calculateOneRepMax(input_weight_box.text.toString().toFloat(), input_reps_box.text.toString().toFloat()).toString()

        }

        input_weight_box.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                if (input_weight_box.text.isNotEmpty() || input_reps_box.text.isNotEmpty()) {
                    output_text_view.text = calculateOneRepMax(
                        input_weight_box.text.toString().toFloat(),
                        input_reps_box.text.toString().toFloat()
                    ).toString()
                }

                return@OnKeyListener true
            }
            false
        })

        input_reps_box.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                if (input_weight_box.text.isNotEmpty() || input_reps_box.text.isNotEmpty()) {
                    output_text_view.text = calculateOneRepMax(
                        input_weight_box.text.toString().toFloat(),
                        input_reps_box.text.toString().toFloat()
                    ).toString()
                }

                return@OnKeyListener true
            }
            false
        })
        super.onViewCreated(view, savedInstanceState)

    }



    fun calculateOneRepMax(weight: Float, reps: Float): Float{
        if (reps > 12)
        {
            throwError()
            return 0.0f
        }
        else {
        var one_rm: Float = weight
        var t_reps = reps
        var offset : Float = 0.0f
        var multiplier: Float = 0.95f
        while (t_reps > 1)
        {
            multiplier -= offset
            one_rm /= multiplier
            offset -= 0.00085f
            t_reps--
        }
        output_text_view.visibility = View.VISIBLE
       return one_rm
        }
    }

    fun throwError(){

        Toast.makeText(requireContext(), "Error 3 - I do not have the facilities for that big man", Toast.LENGTH_SHORT).show()
    }
}
// Prev *.97
//outputBox_01.text = " 1 Rep Max - "+(string_02).toString()
//outputBox_02.text = " 2 Rep Max - "+(BigDecimal(string_02.toDouble()*0.95f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
//outputBox_03.text = " 3 Rep Max - "+(BigDecimal(string_02.toDouble()*0.92f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
//outputBox_04.text = " 4 Rep Max - "+(BigDecimal(string_02.toDouble()*0.90f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
//outputBox_05.text = " 5 Rep Max - "+(BigDecimal(string_02.toDouble()*0.86f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
//outputBox_06.text = " 6 Rep Max - "+(BigDecimal(string_02.toDouble()*0.84f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
//outputBox_07.text = " 7 Rep Max - "+(BigDecimal(string_02.toDouble()*0.82f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
//outputBox_08.text = " 8 Rep Max - "+(BigDecimal(string_02.toDouble()*0.80f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
//outputBox_09.text = " 9 Rep Max - "+(BigDecimal(string_02.toDouble()*0.775f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
//outputBox_10.text = "10 Rep Max - "+(BigDecimal(string_02.toDouble()*0.75f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()
//outputBox_12.text = "12 Rep Max - "+(BigDecimal(string_02.toDouble()*0.69f*(1+offsetValue)).setScale(2, RoundingMode.HALF_EVEN)).toString()