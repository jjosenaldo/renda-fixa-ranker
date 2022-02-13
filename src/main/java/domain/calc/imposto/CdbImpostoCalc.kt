package domain.calc.imposto

import java.time.Period

class CdbImpostoCalc : ImpostoCalc {
    override fun calcImposto(intervalo: Period): Double {
        return when {
            intervalo.years >= 2 -> 0.15
            intervalo.years >= 1 -> 0.175
            intervalo.months >= 6 -> 0.2
            else -> 0.225
        }
    }
}