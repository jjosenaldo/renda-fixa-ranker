package domain

import di.DiProvider
import domain.calc.imposto.ImpostoCalc
import domain.calc.taxa.TaxaCalc
import org.kodein.di.instance
import java.time.LocalDate
import java.time.Period

abstract class AtivoRendaFixa {
    abstract val dataVencimento: LocalDate
    abstract val impostoCalc: ImpostoCalc
    abstract val taxaAnual: Double
    protected val taxaCalc: TaxaCalc by DiProvider.di.instance()

    fun getTaxaLiquidaAteVencimento(dataInvestimento: LocalDate): Double {
        val intervalo = Period.between(dataInvestimento, dataVencimento)

        return taxaCalc.calcTaxaMensalFromAnual(taxaAnual) * intervalo.toTotalMonths() * (1 - impostoCalc.calcImposto(
            intervalo
        ))
    }
}