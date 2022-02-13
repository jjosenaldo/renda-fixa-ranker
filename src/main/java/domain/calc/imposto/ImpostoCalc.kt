package domain.calc.imposto

import java.time.Period

interface ImpostoCalc {
    fun calcImposto(intervalo: Period): Double
}