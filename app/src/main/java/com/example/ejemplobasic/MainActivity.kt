package com.example.ejemplobasic

import android.app.Activity
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
import android.content.pm.PackageManager
import android.widget.EditText
import kotlinx.android.synthetic.main.content_main.view.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest
import android.graphics.Bitmap
import android.provider.MediaStore


const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"


const val sumaRequest = 1
val REQUEST_IMAGE_CAPTURE = 1


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
        bSuma.setOnClickListener {
            val intent = Intent(this, DisplayMessageActivity::class.java)
            var num1 = numero1.text
            var num2 = numero2.text
            intent.putExtra("num1",Integer.parseInt(num1.toString()))
            intent.putExtra("num2",Integer.parseInt(num2.toString()))
            startActivityForResult(intent, sumaRequest)
        }


        }


    /** Called when the user taps the Send button */


    fun colorRojo(view: View){
        startActivity(intentFor<DisplayMessageActivity>("color" to "rojo"))
    }

    fun colorAmarillo(view: View){
        startActivity(intentFor<DisplayMessageActivity>("color" to "amarillo"))
    }

    fun startCamara(it: View?){
        camara()
    }

    fun internete(view: View){
        browse("https://www.20minutos.es/")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

            if (requestCode == 1){
                if(resultCode== Activity.RESULT_OK){
                    miTexto.setText(data?.getIntExtra("suma",0).toString())
                }
                else{
                    miTexto.setText("Hubo un error a la hora de pasar los datos")
                }
            }

        }

    private fun camara(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    1)
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                   0)

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }

        }

         fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                val imageBitmap = data.extras?.get("data") as Bitmap
                imageView.setImageBitmap(imageBitmap)
            }
        }



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
