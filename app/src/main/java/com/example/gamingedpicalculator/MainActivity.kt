package com.example.gamingedpicalculator

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dpi = findViewById<TextInputEditText>(R.id.dpi)
        val sens = findViewById<TextInputEditText>(R.id.sens)
        val edpi = findViewById<TextInputEditText>(R.id.edpi)

        val calculate = findViewById<Button>(R.id.calculate)

        val hello = findViewById<TextView>(R.id.fill)
        hello.setTextColor(Color.WHITE)

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
            sensVal = (edpiVal.toDouble()/dpiVal.toDouble())
        }
        hello.setTextColor(Color.WHITE)
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

        hello.setTextColor(Color.RED)

        dpi.setText("")
        sens.setText("")
        edpi.setText("")

        rdpi.text = "Your DPI:"
        rsens.text = "Your sensitivity:"
        redpi.text = "Your eDPI:"
    }
}