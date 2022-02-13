package di.instances

import api.Api
import api.Indice

internal class ApiImpl : Api {
    override fun getValorIndice(indice: Indice): Double {
        return when (indice) {
            Indice.Ipca -> 0.07
            Indice.Cdi -> 0.1
        }
    }
}