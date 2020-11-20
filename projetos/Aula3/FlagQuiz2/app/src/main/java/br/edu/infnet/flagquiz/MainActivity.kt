package br.edu.infnet.flagquiz

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var paises: ArrayList<Locale>
    private lateinit var botoes: Array<Button>
    private var botaoRespostaCerta = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //------------------------------------------------------------------------------------------
        //for each ---> para cada elemento da coleção atribuído à variável
        paises = ArrayList()
        for (locale in Locale.getAvailableLocales()) {

            if (locale.country.length == 2) {

                paises.add(locale)
            }
        }
        //------------------------------------------------------------------------------------------
        botoes = arrayOf(
            this.findViewById(R.id.btn1), this.findViewById(R.id.btn2),
            this.findViewById(R.id.btn3)
        )
        //for i = 0 to 2 step 1 ---> para i começando em zero até 2, conte de 1 em 1
        for (i in 0..2) {

            botoes[i].setText("")
            botoes[i].setOnClickListener(this)
        }
        //------------------------------------------------------------------------------------------
        this.sorteiaPais()
    }

    override fun onClick(view: View?) {

        //Estou fazendo um "cast" da view para botão porque eu sei que ali tem
        //um botão
        val button : Button = view as Button
        val lblResposta = this.findViewById<TextView>(R.id.lblResposta)
        if(botoes[botaoRespostaCerta] == button) {

            lblResposta.setTextColor(Color.GREEN)
            lblResposta.setText(button.text.toString() + " - CORRETO!")
        } else {

            lblResposta.setTextColor(Color.RED)
            lblResposta.setText(button.text.toString() + " - ERRADO!")
        }
        this.sorteiaPais()
    }

    private fun sorteiaPais() {

        //------------------------------------------------------------------------------------------
        //Uma rodada de jogo consiste em sortear 3 países
        var rodada = IntArray(3)
        for (i in 0..2) {

            var numero = 0
            var ok = false
            while (!ok) {

                //Math.random() * paises.size - 1 ---> número de 0 até comprimento do array de paises - 1
                //Quero gerar o índice do vetor de países
                numero = (Math.random() * paises.size - 1).roundToInt()
                ok = true
                //Percorrer o vetor de numeros aleatorios para ver se tem repetido
                for (j in 0..2) {

                    if (rodada[j] == numero) {

                        ok = false
                        break;
                    }
                }
                if (ok) {

                    val uri = "@drawable/" + paises.get(numero).country.toLowerCase()
                    val imageResourceId = this.resources.getIdentifier(uri, "drawable", packageName)
                    if (imageResourceId == 0) {

                        ok = false
                    }
                }
            }
            rodada[i] = numero
        }
        //------------------------------------------------------------------------------------------
        botaoRespostaCerta = (Math.random() * 2).roundToInt()
        val uri = "@drawable/" + paises.get(rodada[botaoRespostaCerta]).country.toLowerCase()
        val imageResource = this.resources.getIdentifier(uri, null, packageName)
        var imgBandeira = this.findViewById<ImageView>(R.id.imgBandeira)
        imgBandeira.setImageDrawable(resources.getDrawable(imageResource))
        //------------------------------------------------------------------------------------------
        for (i in 0..2) {

            botoes[i].setText(paises[rodada[i]].displayCountry)
        }
    }
}