package di.instances

import api.Api
import api.Indice
import domain.calc.taxa.TaxaCalc

internal class TaxaCalcImpl(val api: Api) : TaxaCalc {
    override fun calcTaxaMensalFromAnual(taxaAnual: Double): Double {
        return Math.pow(1 + taxaAnual, 1 / 12.0) - 1.0
    }

    override fun calcTaxaAnualIpca(porcentagemIpca: Double, taxaPrefixada: Double): Double {
        return porcentagemIpca * api.getValorIndice(Indice.Ipca) + taxaPrefixada
    }

    override fun calcTaxaAnualCdi(porcentagemCdi: Double): Double {
        return porcentagemCdi * api.getValorIndice(Indice.Cdi)
    }

    override fun calcTaxaAnualPre(taxaPrefixada: Double): Double {
        return taxaPrefixada
    }
}