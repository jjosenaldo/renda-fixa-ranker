package domain.calc.imposto

import domain.calc.imposto.ImpostoCalc
import java.time.Period

class LcxImpostoCalc : ImpostoCalc {
    override fun calcImposto(intervalo: Period): Double {
        return 0.0
    }
}