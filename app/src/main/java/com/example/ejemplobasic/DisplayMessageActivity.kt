package com.example.ejemplobasic

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_display_message.*
import kotlinx.android.synthetic.main.content_main.*


class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val valor = intent.getStringExtra("color")
        pruebaTexto.setText(valor)

       val a = intent.getIntExtra("num1",0)
       val b = intent.getIntExtra("num2",0)
       val suma = a+b

        numeroSuma.setText(suma.toString())

        volver.setOnClickListener {
            val data = Intent()
            data.putExtra("suma",suma)
            setResult(Activity.RESULT_OK,data)
            finish()
        }

    }

}
