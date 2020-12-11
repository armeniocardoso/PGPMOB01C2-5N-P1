package br.edu.infnet.mit_mobile_a8_cep

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CepAPI {

    @GET("{CEP}/json/")
    fun obterEndereco(@Path("CEP") cep : String) : Call<Endereco?>?
}