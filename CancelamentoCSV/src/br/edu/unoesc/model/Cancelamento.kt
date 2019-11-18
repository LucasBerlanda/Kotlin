package br.edu.unoesc.model

class Cancelamento(val cliente_id: Long,
                   val usuario_responsavel_id: Long,
                   val data_cadastro: String,
                   val classificacao_cliente: String,
                   val quantidade_usuario_pagante: Int,
                   val data_inicio: String,
                   val data_cancelamento: String,
                   val motivo_cancelamento_id: Int,
                   val motivo: String) {
}