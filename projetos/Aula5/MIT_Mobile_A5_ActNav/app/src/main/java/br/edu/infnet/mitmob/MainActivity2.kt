package br.edu.infnet.mitmob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val frase = intent.getStringExtra("frase")
        val lblFrase = this.findViewById<TextView>(R.id.lblFrase)
        lblFrase.setText(frase)
    }
}