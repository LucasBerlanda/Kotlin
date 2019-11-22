package br.edu.unoesc.model
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.math.roundToLong

class Cancelamento(
    val cliente_id: Long,
    val usuario_responsavel_id: Long,
    val data_cadastro: LocalDate,
    val classificacao_cliente: String,
    val quantidade_usuario_pagante: Int,
    val data_inicio: LocalDate,
    val data_cancelamento: LocalDate,
    val motivo_cancelamento_id: Int,
    val motivo: String) {

    companion object {

        fun getCancelamentos(cancelamentos: List<Cancelamento>) {

            val totalCancel = cancelamentos.groupBy { it.classificacao_cliente }

            totalCancel.toList().sortedByDescending { (key, value) -> value.size }.toMap().forEach {
                println("${it.value.get(0).classificacao_cliente }  -  ${it.value.size}")
            }
        }

        fun getMediaTempoVida(cancelamentos: List<Cancelamento>){
            val qtDias = ArrayList<Long>()

            cancelamentos.forEach {
                qtDias.add(ChronoUnit.DAYS.between(it.data_inicio, it.data_cancelamento))
            }
            println("Média de tempo de vida do usuário no sistema em dias= ${qtDias.average().roundToLong()}")
        }

        fun getCancelamentoByMotivo(cancelamentos: List<Cancelamento>) {

            val motivos = cancelamentos.groupBy { it.motivo }

             motivos.toList().sortedByDescending { (key, value) -> value.size }.toMap().forEach { println("${it.value.get(0).motivo } - ${it.value.size}")
            }

        }

        fun getCanceladosMesAno(cancelamentos: List<Cancelamento>) {

            val cancel = cancelamentos.groupBy { it.data_cancelamento.withDayOfMonth(1) }

            cancel.toList().sortedBy { (key, value) -> key  }.toMap().forEach {

                val ano = it.key.year
                val mes = it.key.month
                var count = it.value.count()

                println("$mes/$ano = $count")
            }

        }

        fun getCancelamentoByUserResponsavel(cancelamentos: List<Cancelamento>) {

            val cancel = cancelamentos.groupBy { it.usuario_responsavel_id }

            cancel.toList().sortedByDescending { (key, value) -> value.size }.toMap().forEach {
                println("Id do usuário: ${it.value.get(0).usuario_responsavel_id } - Qt: ${it.value.size}")
            }

        }

    }

    override fun toString(): String {
        return "Cancelamento(cliente_id=$cliente_id, usuario_responsavel_id=$usuario_responsavel_id, data_cadastro='$data_cadastro', classificacao_cliente='$classificacao_cliente', quantidade_usuario_pagante=$quantidade_usuario_pagante, data_inicio='$data_inicio', data_cancelamento=$data_cancelamento, motivo_cancelamento_id=$motivo_cancelamento_id, motivo='$motivo')"
    }


}