package com.e.shoppingreciptfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var v = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val chk1 = findViewById<CheckBox>(R.id.checkbox1)
        val chk2 = findViewById<CheckBox>(R.id.checkbox2)
        val chk3 = findViewById<CheckBox>(R.id.checkbox3)
        val chk4 = findViewById<CheckBox>(R.id.checkbox4)
        val chk5 = findViewById<CheckBox>(R.id.checkbox5)
        val gst1 = findViewById<CheckBox>(R.id.gst1)
        val gst2 = findViewById<CheckBox>(R.id.gst2)
        val btn = findViewById<Button>(R.id.btn)
        val txt = findViewById<TextView>(R.id.recipt)
        var amount = 0.0
        var sum = 0.0
        var gst = 0
        var temp = 0.0

        gst1.setOnClickListener(this)
        gst2.setOnClickListener(this)

        btn.setOnClickListener{
            if (chk1.isChecked)
                sum += 50
            if (chk2.isChecked)
                sum += 50
            if (chk3.isChecked)
                sum += 90
            if (chk4.isChecked)
                sum += 45
            if (chk5.isChecked)
                sum += 100
            if (gst1.isChecked){
                gst = 6
            }
            if (gst2.isChecked){
                gst = 18
            }

            //calculating gst
            temp = sum / 100 * gst
            amount = sum + temp

            txt.text = "Total : Rs. $amount ($temp GST)"
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.gst1 -> {
            if (gst1.isChecked)
                gst2.isChecked = false
            }
            R.id.gst2 -> {
                if (gst2.isChecked)
                    gst1.isChecked = false
            }
        }
    }
}

