package br.edu.unoesc

import java.util.*

fun main(args:Array<String>) {

    val p2 = Divida()

    val reader = Scanner(System.`in`)

    println("Digite o valor da divida: ")
    val valor :Double = reader.nextDouble()

    println("Dividido em quantas vezes? ")
    val qtParcelas :Int = reader.nextInt()

    println("Intervalo de dias para cada parcela: ")
    val diasEntreParcelas :Int = reader.nextInt()

    reader.close()
    println("Parcelas: " + p2.getParcelas(total = valor, qtParcelas = qtParcelas, qtDiasEntreParcelas = diasEntreParcelas))





}
