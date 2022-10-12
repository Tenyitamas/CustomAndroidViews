package com.tenyitamas.customviews

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.paris.extensions.style
import com.tenyitamas.customviews.ColorObject.Companion.basicColors
import com.tenyitamas.customviews.ColorObject.Companion.defaultColor
import com.tenyitamas.customviews.adapter.ColorSpinnerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpSecondChoiceLayout()
        setUpColorSpinner()
    }

    private fun setUpColorSpinner() {
        var selectedColor = defaultColor

        colorSpinner.apply {
            adapter = ColorSpinnerAdapter(applicationContext, ColorObject.basicColors)
            setSelection(ColorObject.colorPosition(selectedColor), false)

            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    selectedColor = basicColors[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    // Do nothing
                }
            }

        }
    }

    private fun setUpSecondChoiceLayout() {
        for (i in 1..6) {
            val textView = TextView(this)
            textView.text = "Valami $i"
            textView.style(R.style.ChoiceOptionStyle)
            textView.setTextColor(resources.getColor(
                R.color.primaryColor,
                null
            ))

            clSecond.addView(
                child = textView,
                params = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            )
        }
    }
}