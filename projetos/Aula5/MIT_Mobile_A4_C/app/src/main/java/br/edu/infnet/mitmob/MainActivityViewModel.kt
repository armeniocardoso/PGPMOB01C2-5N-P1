package br.edu.infnet.mitmob

import android.app.Application
import androidx.lifecycle.*

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var contatoRepository: ContatoRepository
    lateinit var contatos: LiveData<List<Contato>>
    lateinit var contato: MutableLiveData<Contato>

    init {

        contatoRepository = ContatoRepository(application)
        contatos = contatoRepository.listaContatosLiveData().asLiveData()
        contato = MutableLiveData(Contato(0,"", "", ""))
    }

    fun obterPorId(id : Int) : Contato {

        return contatoRepository.obterPorId(id)
    }

    fun salvarContato(contato : Contato) {

        return contatoRepository.salvarContato(contato)
    }

    fun excluirContato() {

        if (contato.value != null) {

            contatoRepository.excluirContato(contato.value!!)
        }
    }
}

class MainActivityViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {

            return MainActivityViewModel(application) as T
        }
        throw IllegalArgumentException("ViewModel não é compatível com essa Factory")
    }
}
