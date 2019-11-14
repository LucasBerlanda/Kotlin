package br.edu.unoesc

import java.io.File
import java.io.InputStream

fun main(args:Array<String>) {

    val p2 = DividaParcela()
    println("Parcelas: " + p2.getValorParcela(total = 100.0, qtParcelas = 3, qtDiasEntreParcelas = 30))

//    val inputStream: InputStream = File("C:\\Users\\Berlanda\\Desktop\\cancelamentos.csv").inputStream()
//
//    val inputString = inputStream.bufferedReader().use { it.readText() }
//    println(inputString)
//
//    val sheet = inputString.get(0)




}
