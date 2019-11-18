package br.edu.unoesc

import br.edu.unoesc.model.Cancelamento
import br.edu.unoesc.model.CancelamentoCliente
import java.io.File
import java.io.InputStream


fun main(args:Array<String>) {
    // exercicio cancelamento

    val arquivo: InputStream = File("C:\\Users\\Berlanda\\Desktop\\cancelamentos.csv").inputStream();
    val str = arquivo.bufferedReader().use { it.readText() }

    var lista = ArrayList<Cancelamento>()

    for(i in 1..str.length) {
        lista.add(
            Cancelamento(
                cliente_id = str[0].toLong(),
                usuario_responsavel_id = str[1].toLong(),
                data_cadastro = str[2].toString(),
                classificacao_cliente = str[3].toString(),
                quantidade_usuario_pagante = str[4].toInt(),
                data_inicio = str[5].toString(),
                data_cancelamento = str[6].toString(),
                motivo_cancelamento_id = str[7].toInt(),
                motivo = str[8].toString()
            )
        )
    }

    var cancelamentoPorCliente = ArrayList<CancelamentoCliente>()

    lista.forEach {
        val cla = it.classificacao_cliente
        var count = 0
        lista.forEach{
            if (it.classificacao_cliente == cla){
                count += 1
            }
        }
        cancelamentoPorCliente.add(CancelamentoCliente(total = count, classificacao = cla))
    }

    var nova = cancelamentoPorCliente.distinctBy { it.classificacao }.sortedByDescending { it.total }
    nova.forEach {
        print(it.total)
        print(" - ")
        println(it.classificacao)
    }

}