package br.edu.infnet.mit_mobile_a7_storage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //-----------------------------------------------
        val btnSPSalvar = this.findViewById<Button>(R.id.btnSPSalvar)
        btnSPSalvar.setOnClickListener {

            val txtString = this.findViewById<EditText>(R.id.txtString)
            val txtInteiro = this.findViewById<EditText>(R.id.txtInteiro)

            val sp = this.getSharedPreferences("mainPrefs", MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString("dado1", txtString.text.toString())
            editor.putInt("dado2", txtInteiro.text.toString().toInt())
            editor.commit()
            Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show()
        }
        val btnSPLer = this.findViewById<Button>(R.id.btnSPLer)
        btnSPLer.setOnClickListener {

            val lblSPLido = this.findViewById<TextView>(R.id.lblSPLido)
            val sp = this.getSharedPreferences("mainPrefs", MODE_PRIVATE)
            lblSPLido.setText("Dado 1 = ${sp.getString("dado1", "Não Encontrado")} --- Dado 2 = ${sp.getInt("dado2", 0)}")
            Toast.makeText(this, "Lido", Toast.LENGTH_SHORT).show()
        }
        //-----------------------------------------------
        val btnAISalvar = this.findViewById<Button>(R.id.btnAISalvar)
        btnAISalvar.setOnClickListener {

            val txtString = this.findViewById<EditText>(R.id.txtString)
            val fos = this.openFileOutput("mainFile", MODE_PRIVATE)
            fos.write(txtString.text.toString().toByteArray())
            fos.close()
            Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show()
        }
        val btnAILer = this.findViewById<Button>(R.id.btnAILer)
        btnAILer.setOnClickListener {

            val fis = this.openFileInput("mainFile")
            val bytes = fis.readBytes()
            fis.close()
            val lblAILido = this.findViewById<TextView>(R.id.lblAILido)
            lblAILido.setText(String(bytes))
            Toast.makeText(this, "Lido", Toast.LENGTH_SHORT).show()
        }
        //-----------------------------------------------
        val btnAESalvar = this.findViewById<Button>(R.id.btnAESalvar)
        btnAESalvar.setOnClickListener {

            val file = File(this.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "mainExt")
            val fos = FileOutputStream(file)
            val txtString = this.findViewById<EditText>(R.id.txtString)
            fos.write(txtString.text.toString().toByteArray())
            fos.close()
            Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show()
        }
        val btnAELer = this.findViewById<Button>(R.id.btnAELer)
        btnAELer.setOnClickListener {

            val file = File(this.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "mainExt")
            val fis = FileInputStream(file)
            val bytes = fis.readBytes()
            fis.close()
            val lblAELido = this.findViewById<TextView>(R.id.lblAELido)
            lblAELido.setText(String(bytes))
            Toast.makeText(this, "Lido", Toast.LENGTH_SHORT).show()
        }
    }
}




