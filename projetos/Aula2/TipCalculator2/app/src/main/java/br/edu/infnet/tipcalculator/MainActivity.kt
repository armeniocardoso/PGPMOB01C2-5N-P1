package br.edu.infnet.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity(), View.OnFocusChangeListener, SeekBar.OnSeekBarChangeListener {

    private lateinit var txtTotalConta : EditText
    private lateinit var txtPessoas : EditText
    private lateinit var skGorjeta : SeekBar

    private val formatador = NumberFormat.getCurrencyInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTotalConta = this.findViewById<EditText>(R.id.txtTotalConta)
        txtTotalConta.setOnFocusChangeListener(this)
        txtPessoas = this.findViewById<EditText>(R.id.txtPessoas)
        txtPessoas.setOnFocusChangeListener(this)
        skGorjeta = this.findViewById<SeekBar>(R.id.skGorjeta)
        skGorjeta.setOnSeekBarChangeListener(this)
    }

    override fun onFocusChange(p0: View?, p1: Boolean) {

        this.atualizaDadosConta()
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

        val lblPercetual = this.findViewById<TextView>(R.id.lblPercentualGorjeta)
        lblPercetual.setText(skGorjeta.progress.toString() + "%")

        this.atualizaDadosConta()
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }

    private fun atualizaDadosConta() {

        if(txtTotalConta.text.toString().isNotBlank()
            && txtPessoas.text.toString().isNotBlank()) {

            val valorConta = txtTotalConta.text.toString().toDouble()
            val qtdPessoas = txtPessoas.text.toString().toInt()

            val valorRealGorjeta = valorConta * skGorjeta.progress / 100
            val lblValorRealGorjeta = this.findViewById<TextView>(R.id.lblValorRealGorjeta)
            lblValorRealGorjeta.setText(formatador.format(valorRealGorjeta))

            val totalRealConta = valorConta + valorRealGorjeta
            val lblValorRealConta = this.findViewById<TextView>(R.id.lblTotalReal)
            lblValorRealConta.setText(formatador.format(totalRealConta))

            val totalPorPessoa = totalRealConta / qtdPessoas
            val lblValorPorPessoa = this.findViewById<TextView>(R.id.lblTotalRealPessoa)
            lblValorPorPessoa.setText(formatador.format(totalPorPessoa))
        }
    }
}












