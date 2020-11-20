package br.edu.infnet.mitmob

import android.app.Application
import androidx.room.Room
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking

class ContatoRepository (applicationContext : Application) {

    private lateinit var dao : ContatoDAO

    init {

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java,
            "db_contatos").build()
        dao = db.getContatoDAO()
    }

    fun obterPorId(id: Int) : Contato {

        return runBlocking {

            return@runBlocking dao.obter(id)
        }
    }

    fun listaContatosLiveData() : Flow<List<Contato>> {

        return runBlocking {

            return@runBlocking dao.listarLiveData()
        }
    }

    fun salvarContato(contato: Contato) {

        return runBlocking {

            return@runBlocking dao.inserir(contato)
        }
    }

    fun excluirContato(contato: Contato) {

        return runBlocking {

            return@runBlocking dao.excluir(contato)
        }
    }
}