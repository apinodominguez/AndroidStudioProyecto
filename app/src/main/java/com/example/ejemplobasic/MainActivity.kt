package com.example.ejemplobasic

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.toast

import android.content.Intent
import android.widget.EditText
import org.jetbrains.anko.browse
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop


const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        botoncorreo.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        botonSaludo.setOnClickListener {
            textoSaludo.setText("Hola que tal")
            botonSaludo.setTextColor(Color.parseColor("#ffffff"))
            botonSaludo.setBackgroundColor(Color.parseColor("#1565c0"))
            toast("maldito pisacharcos")


        }


    }

    /** Called when the user taps the Send button */


    fun colorRojo(view: View){
        startActivity(intentFor<DisplayMessageActivity>("color" to "rojo"))
    }
    fun colorAmarillo(view: View){
        startActivity(intentFor<DisplayMessageActivity>("color" to "amarillo"))
    }

    fun internete(view: View){
        browse("https://www.20minutos.es/")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
