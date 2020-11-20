package br.edu.infnet.mitmob

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import br.edu.infnet.mitmob.databinding.ActivityMainBinding
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity(), RecycleViewItemListener {

    lateinit var binding: ActivityMainBinding
    lateinit var viewmodel: MainActivityViewModel
    lateinit var dao: ContatoDAO

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodel = ViewModelProvider(this, MainActivityViewModelFactory(this.application)).get(MainActivityViewModel::class.java)
        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this
        //------------------------------------------------------
        binding.lstContatos.layoutManager = LinearLayoutManager(this)
        val adapter = ListaContatoAdapter()
        adapter.setRecycleViewItemListener(this)
        binding.lstContatos.adapter = adapter
        if(viewmodel.contatos.value != null) {

            adapter.listaContatos = viewmodel.contatos.value!!
        }
        viewmodel.contatos.observe(this, Observer {

            it.let {

                adapter.listaContatos = it
            }
        })
        //------------------------------------------------------
        binding.btnSalvar.setOnClickListener {

            var contato = Contato(
                0,
                binding.txtNome.text.toString(),
                binding.txtEmail.text.toString(),
                binding.txtFone.text.toString()
            )
            viewmodel.salvarContato(contato)
            binding.txtNome.setText("")
            binding.txtEmail.setText("")
            binding.txtFone.setText("")
        }
        //------------------------------------------------------
        binding.btnExcluir.setOnClickListener {

            viewmodel.excluirContato()
            binding.txtNome.setText("")
            binding.txtEmail.setText("")
            binding.txtFone.setText("")
        }
    }

    override fun recyclerViewItemClicked(view: View, id: Int) {

        viewmodel.contato.value = viewmodel.obterPorId(id)
    }
}