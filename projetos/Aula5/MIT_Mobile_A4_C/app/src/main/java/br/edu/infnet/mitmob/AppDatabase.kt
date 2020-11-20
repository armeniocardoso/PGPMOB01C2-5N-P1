package br.edu.infnet.mitmob

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contato::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getContatoDAO() : ContatoDAO
}