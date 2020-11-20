package br.edu.infnet.mitmob

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Tela2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val frase = arguments?.get("frase").toString()
        Log.i("MIT", frase)
        return inflater.inflate(R.layout.fragment_tela2, container, false)
    }
}