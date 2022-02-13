package factory.ativo.instances

import domain.AtivoRendaFixa
import domain.calc.imposto.LcxImpostoCalc
import java.time.LocalDate

internal class LcxCdi(
    val porcentagemCdi: Double,
    val banco: String,
    override val dataVencimento: LocalDate
) : AtivoRendaFixa() {
    override val taxaAnual get() = taxaCalc.calcTaxaAnualCdi(porcentagemCdi)
    override val impostoCalc get() = LcxImpostoCalc()

    override fun toString(): String {
        return "LCX $banco ${porcentagemCdi * 100}% CDI"
    }
}