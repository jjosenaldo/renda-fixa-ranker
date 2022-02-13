package factory.ativo.instances

import domain.AtivoRendaFixa
import domain.calc.imposto.CdbImpostoCalc
import java.time.LocalDate

internal class CdbPre(
    val taxaPrefixada: Double,
    val banco: String,
    override val dataVencimento: LocalDate
) : AtivoRendaFixa() {
    override val taxaAnual get() = taxaCalc.calcTaxaAnualPre(taxaPrefixada)
    override val impostoCalc get() = CdbImpostoCalc()

    override fun toString(): String {
        return "CDB $banco ${taxaPrefixada * 100}%"
    }
}