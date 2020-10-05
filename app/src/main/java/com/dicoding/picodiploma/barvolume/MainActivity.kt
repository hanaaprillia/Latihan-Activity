package com.dicoding.picodiploma.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object{
        private const val STATE_RESULT = "state_result"
    }

    private lateinit var edWidth: EditText
    private lateinit var edHeight: EditText
    private lateinit var edLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        tvResult = findViewById(R.id.tv_result)
        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT) as String
            tvResult.text = result
        }

        edWidth = findViewById(R.id.edt_width)
        edHeight = findViewById(R.id.edt_height)
        edLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)

        btnCalculate.setOnClickListener(this)
    }
    override fun onSaveInstanceState(outstate:Bundle){
        super.onSaveInstanceState(outstate)
        outstate.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.btn_calculate) {
                val inputLength = edLength.text.toString().trim()
                val inputWidth = edWidth.text.toString().trim()
                val inputHeight = edHeight.text.toString().trim()

                var isEmptyFields = false

                if (inputLength.isEmpty()) {
                    isEmptyFields = true
                    edLength.error = "Field ini tidak boleh kosong"
                }

                if (inputWidth.isEmpty()) {
                    isEmptyFields = true
                    edWidth.error = "Field ini tidak boleh kosong"
                }

                if (inputHeight.isEmpty()) {
                    isEmptyFields = true
                    edHeight.error = "Field ini tidak boleh kosong"
                }

                if (!isEmptyFields) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
            }
        }
    }
}
}