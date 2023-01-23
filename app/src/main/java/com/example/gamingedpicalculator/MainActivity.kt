package com.example.gamingedpicalculator

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dpi = findViewById<TextInputEditText>(R.id.dpi)
        val sens = findViewById<TextInputEditText>(R.id.sens)
        val edpi = findViewById<TextInputEditText>(R.id.edpi)

        val calculate = findViewById<Button>(R.id.calculate)

        calculate.setOnClickListener {
            if (((dpi.text.toString().isEmpty() && sens.text.toString().isEmpty()) ||
                (dpi.text.toString().isEmpty() && edpi.text.toString().isEmpty()) ||
                (sens.text.toString().isEmpty() && edpi.text.toString().isEmpty())) ||
                (dpi.text.toString().isNotEmpty() && sens.text.toString().isNotEmpty() && edpi.text.toString().isNotEmpty())) {
                restart()
            } else find()
        }
    }

    private fun find() {
        val hello = findViewById<TextView>(R.id.fill)

        val dpi = findViewById<TextInputEditText>(R.id.dpi)
        val sens = findViewById<TextInputEditText>(R.id.sens)
        val edpi = findViewById<TextInputEditText>(R.id.edpi)

        val rdpi = findViewById<TextView>(R.id.resultdpi)
        val rsens = findViewById<TextView>(R.id.resultsens)
        val redpi = findViewById<TextView>(R.id.resultedpi)

        var dpiVal: Int
        var sensVal: Double
        var edpiVal: Int

        if (edpi.text.toString().isNotEmpty()) {
            edpiVal = edpi.text.toString().toInt()
        } else {
            dpiVal = dpi.text.toString().toInt()
            sensVal = sens.text.toString().toDouble()
            edpiVal = (dpiVal*sensVal).toInt()
        }

        if (dpi.text.toString().isNotEmpty()) {
            dpiVal = dpi.text.toString().toInt()
        } else {
            sensVal = sens.text.toString().toDouble()
            dpiVal = (edpiVal/sensVal).toInt()
        }

        if (sens.text.toString().isNotEmpty()) {
            sensVal = sens.text.toString().toDouble()
        } else {
            edpiVal = edpi.text.toString().toInt()
            dpiVal = dpi.text.toString().toInt()
            sensVal = (edpiVal.toDouble()/dpiVal * 10000).roundToInt().toDouble() / 10000
        }
        hello.setTextColor(Color.WHITE)

        closeKeyBoard()

        dpi.setText("")
        sens.setText("")
        edpi.setText("")

        rdpi.text = "Your DPI: $dpiVal"
        rsens.text = "Your sensitivity: $sensVal"
        redpi.text = "Your eDPI: $edpiVal"
    }

    private fun restart() {
        val hello = findViewById<TextView>(R.id.fill)

        val dpi = findViewById<TextInputEditText>(R.id.dpi)
        val sens = findViewById<TextInputEditText>(R.id.sens)
        val edpi = findViewById<TextInputEditText>(R.id.edpi)

        val rdpi = findViewById<TextView>(R.id.resultdpi)
        val rsens = findViewById<TextView>(R.id.resultsens)
        val redpi = findViewById<TextView>(R.id.resultedpi)

        closeKeyBoard()

        hello.setTextColor(Color.RED)

        dpi.setText("")
        sens.setText("")
        edpi.setText("")

        rdpi.text = "Your DPI:"
        rsens.text = "Your sensitivity:"
        redpi.text = "Your eDPI:"
    }

    private fun closeKeyBoard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}