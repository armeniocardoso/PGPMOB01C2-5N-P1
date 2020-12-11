package br.edu.infnet.mit_mobile_a8_cep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), CepServiceListener {

    private val servico = CepService()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        servico.setCepServiceListener(this)

        val btnObter = this.findViewById<Button>(R.id.btnObter)
        btnObter.setOnClickListener {

            val txtCep = this.findViewById<EditText>(R.id.txtCep)
            servico.obterEndereco(txtCep.text.toString())
        }
    }

    override fun obterEnderecoTerminou(endereco: Endereco?) {

        if(endereco != null) {

            this.findViewById<TextView>(R.id.lblBairro).setText(endereco.bairro)
            this.findViewById<TextView>(R.id.lblComplemento).setText(endereco.complemento)
            this.findViewById<TextView>(R.id.lblGia).setText(endereco.gia)
            this.findViewById<TextView>(R.id.lblIbge).setText(endereco.ibge)
            this.findViewById<TextView>(R.id.lblLocalidade).setText(endereco.localidade)
            this.findViewById<TextView>(R.id.lblLogradouro).setText(endereco.logradouro)
            this.findViewById<TextView>(R.id.lblUf).setText(endereco.uf)
            this.findViewById<TextView>(R.id.lblUnidade).setText(endereco.unidade)
        }

    }

    override fun falhaReportada(falha: String?) {

        Toast.makeText(this, falha, Toast.LENGTH_SHORT).show()
    }
}
