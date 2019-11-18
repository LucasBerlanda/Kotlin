package br.edu.unoesc

import java.lang.Math.round
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Divida() {

    fun getParcelas(total: Double, qtParcelas: Int, qtDiasEntreParcelas: Int) {

        var dataHoje = LocalDate.now()
        var valorParcela =  total / qtParcelas
        val formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        for (i in 1..qtParcelas) {
            var dias = i * qtDiasEntreParcelas
            println("Data da parcela: " + dataHoje.plusDays(dias.toLong()).format(formataData))
            println("Valor: " + (round(valorParcela)))
            println("Parcela nº: " + i)
            println("------------------")
        }
    }

}