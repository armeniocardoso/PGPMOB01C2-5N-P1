package br.edu.infnet.mitmob

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContatoDAO {

    @Query(value = "SELECT * FROM contatos")
    suspend fun listar():List<Contato>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun inserir(contato : Contato)
}