package br.edu.infnet.mit_mobile_a8_cep

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CepService {

    lateinit var api : CepAPI
    lateinit var listener : CepServiceListener

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://viacep.com.br/ws/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(CepAPI::class.java)
    }

    public fun setCepServiceListener(listener: CepServiceListener) {

        this.listener = listener
    }

    public fun obterEndereco(cep : String) {

        val call = api.obterEndereco(cep)
        call!!.enqueue(object : Callback<Endereco?> {

            override fun onResponse(call: Call<Endereco?>, response: Response<Endereco?>) {

                if(response.isSuccessful && listener != null) {

                    listener.obterEnderecoTerminou(response.body())
                }
            }

            override fun onFailure(call: Call<Endereco?>, t: Throwable) {

                if(listener != null) {

                    listener.falhaReportada(t.message)
                }
            }
        })
    }
}

















