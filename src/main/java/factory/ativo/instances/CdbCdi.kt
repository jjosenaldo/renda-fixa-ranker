package factory.ativo.instances

import domain.AtivoRendaFixa
import domain.calc.imposto.CdbImpostoCalc
import java.time.LocalDate

internal class CdbCdi(
    val porcentagemCdi: Double,
    val banco: String,
    override val dataVencimento: LocalDate
) : AtivoRendaFixa() {
    override val taxaAnual get() = taxaCalc.calcTaxaAnualCdi(porcentagemCdi)
    override val impostoCalc get() = CdbImpostoCalc()

    override fun toString(): String {
        return "CDB $banco ${porcentagemCdi * 100}% CDI"
    }
}