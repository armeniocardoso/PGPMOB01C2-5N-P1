package br.edu.infnet.mitmob

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val CAMERA_PERMISSION_CODE = 100
    val CAMERA_REQUEST = 1888

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //---------------------------------------------------------------
        val txtTexto = this.findViewById<EditText>(R.id.txtTexto)
        //---------------------------------------------------------------
        val btnActivity = this.findViewById<Button>(R.id.btnActivity)
        btnActivity.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("frase", txtTexto.text.toString())
            this.startActivity(intent)
        }
        //---------------------------------------------------------------
        val btnTelefone = this.findViewById<Button>(R.id.btnTelefone)
        btnTelefone.setOnClickListener {

            val callIntent: Intent = Uri.parse("tel:${txtTexto.text.toString()}").let {

                Intent(Intent.ACTION_DIAL, it)
            }
            this.startActivity(callIntent)
        }
        //---------------------------------------------------------------
        val btnMapa = this.findViewById<Button>(R.id.btnMapa)
        btnMapa.setOnClickListener {

            val mapIntent: Intent = Uri.parse("geo:0,0?q=${txtTexto.text.toString()}").let {

                Intent(Intent.ACTION_VIEW, it)
            }
            this.startActivity(mapIntent)
        }
        //---------------------------------------------------------------
        val btnCompartilhar = this.findViewById<Button>(R.id.btnCompartilhar)
        btnCompartilhar.setOnClickListener {

            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.setType("text/plain")
            shareIntent.putExtra(Intent.EXTRA_TEXT, txtTexto.text.toString())
            this.startActivity(shareIntent)
        }
        //---------------------------------------------------------------
        val btnChooser = this.findViewById<Button>(R.id.btnChooser)
        btnChooser.setOnClickListener {

            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.setType("text/plain")
            shareIntent.putExtra(Intent.EXTRA_TEXT, txtTexto.text.toString())
            val title = "Selecione uma Opção de Compartilhamento"
            val chooser = Intent.createChooser(shareIntent, title)
            this.startActivity(chooser)
        }
        //---------------------------------------------------------------
        val btnCamera = this.findViewById<Button>(R.id.btnCamera)
        btnCamera.setOnClickListener {

            if (this.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                this.requestPermissions(arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_CODE)
            } else {

                val cameraIntnet = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                this.startActivityForResult(cameraIntnet, CAMERA_REQUEST)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
        grantResults: IntArray) {

        if(requestCode == CAMERA_PERMISSION_CODE) {

            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, "Permissão Concedida", Toast.LENGTH_SHORT).show()
                val cameraIntnet = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                this.startActivityForResult(cameraIntnet, CAMERA_REQUEST)
            } else {

                Toast.makeText(this, "Permissão Negada", Toast.LENGTH_SHORT).show()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {

            val foto = data?.extras!!["data"] as Bitmap?
            val imgCamera = this.findViewById<ImageView>(R.id.imgCamera)
            imgCamera.setImageBitmap(foto)
        }
    }
}












