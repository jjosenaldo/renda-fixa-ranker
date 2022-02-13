package domain

import java.time.LocalDate

class Investimento(
    val valorInicial: Double,
    val ativo: AtivoRendaFixa,
    val data: LocalDate
) : Comparable<Investimento> {
    val valorNoVencimento: Double
        get() = valorInicial * (1 + ativo.getTaxaLiquidaAteVencimento(
            data
        ))

    override fun toString(): String {
        return "Investimento de $valorInicial em $ativo na data $data: fica $valorNoVencimento no vencimento"
    }

    override fun compareTo(other: Investimento): Int {
        return valorNoVencimento.compareTo(other.valorNoVencimento)
    }
}