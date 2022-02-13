package domain.calc.taxa

interface TaxaCalc {
    fun calcTaxaMensalFromAnual(taxaAnual: Double): Double
    fun calcTaxaAnualIpca(porcentagemIpca: Double, taxaPrefixada: Double): Double
    fun calcTaxaAnualCdi(porcentagemCdi: Double): Double
    fun calcTaxaAnualPre(taxaPrefixada: Double): Double
}