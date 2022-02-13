package di

import api.Api
import di.instances.ApiImpl
import di.instances.TaxaCalcImpl
import domain.calc.taxa.TaxaCalc
import org.kodein.di.*

object DiProvider {
    val di = DI {
        bindSingleton<Api> { ApiImpl() }
        bindSingleton<TaxaCalc> { TaxaCalcImpl(instance()) }
    }
}