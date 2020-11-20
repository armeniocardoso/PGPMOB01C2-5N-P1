package br.edu.infnet.mitmob

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ContatoDAO {

    @Query(value = "SELECT * FROM contatos WHERE id = :id")
    suspend fun obter(id : Int) : Contato

    @Query(value = "SELECT * FROM contatos")
    suspend fun listar():List<Contato>

    @Query(value = "SELECT * FROM contatos")
    fun listarLiveData() : Flow<List<Contato>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun inserir(contato : Contato)

    @Delete
    suspend fun excluir(contato : Contato)
}