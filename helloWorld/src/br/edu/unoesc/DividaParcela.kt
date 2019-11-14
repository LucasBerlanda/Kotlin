package br.edu.unoesc

import java.time.LocalDate

class DividaParcela() {

    fun getValorParcela(total: Double, qtParcelas: Int, qtDiasEntreParcelas: Int) {

        var dataHoje = LocalDate.now()
        var valorParcela =  total / qtParcelas

        for (i in 1..qtParcelas) {
            var dias = i * qtDiasEntreParcelas
            println("Data da parcela: " + dataHoje.plusDays(dias.toLong()))
            println("Valor: " + valorParcela)
            println("Parcela nº: " + i)
            println("------------------")
        }
    }

}