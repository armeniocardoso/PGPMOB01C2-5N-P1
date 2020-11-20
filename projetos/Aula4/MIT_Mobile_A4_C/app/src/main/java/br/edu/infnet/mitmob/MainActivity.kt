package br.edu.infnet.mitmob

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import br.edu.infnet.mitmob.databinding.ActivityMainBinding
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewmodel: MainActivityViewModel
    lateinit var dao: ContatoDAO

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this
        //------------------------------------------------------
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "db_contatos"
        ).build()
        dao = db.getContatoDAO()
        //------------------------------------------------------
        binding.btnSalvar.setOnClickListener {

            var contato = Contato(
                0,
                binding.txtNome.text.toString(),
                binding.txtEmail.text.toString(),
                binding.txtFone.text.toString()
            )
            binding.txtNome.setText("")
            binding.txtEmail.setText("")
            binding.txtFone.setText("")
            runBlocking {

                dao.inserir(contato)

                val lista = dao.listar()
                for(contato in lista) {

                    Log.i("MIT","${contato.id} - ${contato.nome}")
                }
            }
        }
    }
}