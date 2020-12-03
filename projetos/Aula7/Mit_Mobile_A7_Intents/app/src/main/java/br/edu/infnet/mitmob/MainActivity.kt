package br.edu.infnet.mitmob

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

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

            val callIntent : Intent = Uri.parse("tel:${txtTexto.text.toString()}").let {

                Intent(Intent.ACTION_DIAL, it)
            }
            this.startActivity(callIntent)
        }
    }
}












