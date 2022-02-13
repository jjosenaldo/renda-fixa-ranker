package factory.ativo.instances

import domain.AtivoRendaFixa
import domain.calc.imposto.LcxImpostoCalc
import java.time.LocalDate

internal class LcxPre(
    val taxaPrefixada: Double, val banco: String, override val dataVencimento: LocalDate
) : AtivoRendaFixa() {
    override val taxaAnual get() = taxaCalc.calcTaxaAnualPre(taxaPrefixada)
    override val impostoCalc get() = LcxImpostoCalc()

    override fun toString(): String {
        return "LCX $banco ${taxaPrefixada * 100}% a.a."
    }
}