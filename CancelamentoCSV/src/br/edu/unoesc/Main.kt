package br.edu.unoesc

import br.edu.unoesc.model.Cancelamento
import java.io.File
import java.io.InputStream
import java.time.LocalDate
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.collections.ArrayList

fun main(args:Array<String>) {
    // exercicio cancelamento
    // ler o arquivo
    val arquivo: InputStream = File("C:\\Users\\Berlanda\\Desktop\\cancelamentos2.csv").inputStream();
    val cancelamentos = ArrayList<Cancelamento>()

    arquivo.bufferedReader().useLines() { l -> l.forEach {
        cancelamentos.add(Cancelamento(
                cliente_id = it.split( ',')[0].replace("\"", "").toLong(),
                usuario_responsavel_id = it.split(',')[1].replace("\"", "").toLong(),
                data_cadastro = LocalDate.parse(it.split(',')[2].replace("\"", "")),
                classificacao_cliente = it.split(',')[3].replace("\"", ""),
                quantidade_usuario_pagante = it.split(',')[4].replace("\"", "").toInt(),
                data_inicio = LocalDate.parse(it.split(',')[5].replace("\"", "")),
                data_cancelamento = LocalDate.parse(it.split(',')[6].replace("\"", "")),
                motivo_cancelamento_id = it.split(',')[7].replace("\"", "").toInt(),
                motivo = it.split(',')[8].replace("\"", "")
            ))
        }
    }

    println("1- Número de cancelamentos por classificação do cliente, ordenado pelo maior número DESC")
    Cancelamento.getCancelamentos(cancelamentos)

    println("-----------------------------------")
    println("2- Média de tempo de vida(dias entre início e cancelamento)")
    Cancelamento.getMediaTempoVida(cancelamentos)

    println("-----------------------------------")
    println("3- Número de cancelamentos por motivo de cancelamento, ordenado pelo maior número DESC")
    Cancelamento.getCancelamentoByMotivo(cancelamentos)

    println("------------------------------------")
    println("4- Quantidade de usuários cancelados por mês/ano, ordenado pelo mes/ano ASC")
    Cancelamento.getCanceladosMesAno(cancelamentos)

    println("------------------------------------")
    println("5- Quantidade de clientes cancelados por usuário responsável, ordenado por número DESC")
    Cancelamento.getCancelamentoByUserResponsavel(cancelamentos)


}





