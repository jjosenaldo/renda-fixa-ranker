package factory.ativo.instances

import domain.AtivoRendaFixa
import domain.calc.imposto.CdbImpostoCalc
import java.time.LocalDate

internal class CdbIpca(
    val porcentagemIpca: Double,
    val taxaPrefixada: Double,
    val banco: String,
    override val dataVencimento: LocalDate
) : AtivoRendaFixa() {
    override val taxaAnual get() = taxaCalc.calcTaxaAnualIpca(porcentagemIpca, taxaPrefixada)
    override val impostoCalc get() = CdbImpostoCalc()

    override fun toString(): String {
        return "CDB $banco ${porcentagemIpca * 100}% IPCA + ${taxaPrefixada * 100}%"
    }
}