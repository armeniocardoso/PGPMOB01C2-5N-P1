package br.edu.infnet.mitmob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.text.isDigitsOnly
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import br.edu.infnet.mitmob.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var musicaController : MusicaController

    lateinit var binding : ActivityMainBinding
    lateinit var viewmodel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        Log.i("MIT", "MainActivity.onCreate")

        musicaController = MusicaController(this.lifecycle)

        viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this
//        binding.txtFrase.text = viewmodel.frase
        //--------------------------------------------------
//        viewmodel.nome.observe(this, { nome ->
//
//            binding.lblNome.setText(nome)
//        })
        //--------------------------------------------------
/*        binding.txtNome.setOnKeyListener { view, i, keyEvent ->

            viewmodel.nome.value = binding.txtNome.text.toString()
            if(binding.txtNome.text.toString().isDigitsOnly()) {

                viewmodel.numero.value = binding.txtNome.text.toString().toInt()
            }
            true
        }*/
        binding.txtNome.setOnFocusChangeListener { view, b ->

            viewmodel.nome.value = binding.txtNome.text.toString()
            if(binding.txtNome.text.toString().isNotBlank()
                && binding.txtNome.text.toString().isDigitsOnly()) {

                viewmodel.numero.value = binding.txtNome.text.toString().toInt()
            }
            true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MIT", "MainActivity.onDestroy")
    }

    override fun onStart() {
        super.onStart()
        Log.i("MIT", "MainActivity.onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MIT", "MainActivity.onStop")
    }
}