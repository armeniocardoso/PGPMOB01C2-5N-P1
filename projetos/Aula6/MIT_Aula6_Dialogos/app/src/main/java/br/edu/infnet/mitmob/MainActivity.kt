package br.edu.infnet.mitmob

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //------------------------------------
        val btnAlertDialog = this.findViewById<Button>(R.id.btnAlertDialog)
        btnAlertDialog.setOnClickListener {

            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Exemplo de Dialog")
            alertDialog.setMessage("Quer adquirir um carro?")
            alertDialog.setNegativeButton("Não", DialogInterface.OnClickListener { dialogInterface, i ->

                Toast.makeText(this, "Você clicou em \"Não\" - Que Pena!", Toast.LENGTH_SHORT).show()
            })
            alertDialog.setPositiveButton("Sim", DialogInterface.OnClickListener { dialogInterface, i ->

                Toast.makeText(this, "Você clicou em \"Sim\" - Que Legal!", Toast.LENGTH_SHORT).show()
            })
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        val btnProgressBar = this.findViewById<Button>(R.id.btnProgressBar)
        btnProgressBar.setOnClickListener {

            val prgProgressBar = this.findViewById<ProgressBar>(R.id.prgProgressBar)
            val lblProgressBar = this.findViewById<TextView>(R.id.lblProgressBar)
            Thread({

                for(i in 0..100) {

                    this@MainActivity.runOnUiThread {

                        prgProgressBar.progress = i
                        lblProgressBar.text = i.toString() + "%"
                    }
                    Thread.sleep(200)
                }
            }).start()
        }
        val btnDatePicker = this.findViewById<Button>(R.id.btnDatePicker)
        btnDatePicker.setOnClickListener {
            
            val calendar = Calendar.getInstance()
            val dia = calendar.get(Calendar.DAY_OF_MONTH)
            val mes = calendar.get(Calendar.MONTH)
            val ano = calendar.get(Calendar.YEAR)
            
            val datePicker = DatePickerDialog(this, {
                    datePicker: DatePicker, ano: Int, mes: Int, dia: Int ->

                val mensagem = "Data Selecionada = $dia/${mes+1}/$ano"
                Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()

            }, ano, mes, dia).show()
        }
        val btnSnackbar = this.findViewById<Button>(R.id.btnSnackBar)
        btnSnackbar.setOnClickListener {

            val pnlMain = this.findViewById<ConstraintLayout>(R.id.pnlMain)
            val snackbar = Snackbar.make(pnlMain, "Teste de SnackBar", Snackbar.LENGTH_LONG)
                .setActionTextColor(Color.RED)
                .setAction("Clique Aqui", {

                    Toast.makeText(this, "Você clicou no SnackBar", Toast.LENGTH_SHORT).show()
                }).show()
        }
    }
}