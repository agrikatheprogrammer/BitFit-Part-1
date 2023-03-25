package com.example.bitfitpart1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class secondactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondactivity)
        val qsedit=findViewById<EditText>(R.id.editfood)
        val ans1=findViewById<EditText>(R.id.editcalories)
        val save=findViewById<Button>(R.id.secondbutton)
        save.setOnClickListener {
            val qsString = qsedit.text.toString()
            val ans1s = ans1.text.toString()
            val data= Intent()
            data.putExtra("FOOD", qsString)
            data.putExtra("CALORIES", ans1s)
            setResult(RESULT_OK, data)
            finish()
        }
    }
}