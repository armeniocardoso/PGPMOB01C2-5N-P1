package br.edu.infnet.mit_mobile_a8_cep

interface CepServiceListener {

    fun obterEnderecoTerminou(endereco: Endereco?)

    fun falhaReportada(falha : String?)
}