package br.edu.infnet.mitmob

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contatos")
data class Contato (

    @PrimaryKey(autoGenerate = true)
    var id : Int,
    @ColumnInfo(name = "nome")
    var nome: String,
    @ColumnInfo(name = "email")
    var email: String,
    @ColumnInfo(name = "fone")
    var fone: String) {
}