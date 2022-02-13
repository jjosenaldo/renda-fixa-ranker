package factory.ativo.instances

import domain.AtivoRendaFixa
import domain.calc.imposto.LcxImpostoCalc
import java.time.LocalDate

internal class LcxIpca(
    val porcentagemIpca: Double,
    val taxaPrefixada: Double,
    val banco: String,
    override val dataVencimento: LocalDate
) : AtivoRendaFixa() {
    override val taxaAnual
        get() = taxaCalc.calcTaxaAnualIpca(
            porcentagemIpca,
            taxaPrefixada
        )
    override val impostoCalc get() = LcxImpostoCalc()

    override fun toString(): String {
        return "LCX $banco ${porcentagemIpca * 100}% IPCA + ${taxaPrefixada * 100}%"
    }
}