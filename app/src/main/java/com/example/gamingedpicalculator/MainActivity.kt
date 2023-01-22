package com.example.gamingedpicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dpi = findViewById<TextInputEditText>(R.id.dpi)
        val sens = findViewById<TextInputEditText>(R.id.sens)
        val edpi = findViewById<TextInputEditText>(R.id.edpi)

        val calculate = findViewById<Button>(R.id.calculate)

        val rdpi = findViewById<TextView>(R.id.resultdpi)
        val rsens = findViewById<TextView>(R.id.resultsens)
        val redpi = findViewById<TextView>(R.id.resultedpi)

        calculate.setOnClickListener {
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

            rdpi.text = dpiVal.toString()
            rsens.text = sensVal.toString()
            redpi.text = edpiVal.toString()
        }
    }
}