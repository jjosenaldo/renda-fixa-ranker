package factory.ativo

import domain.AtivoRendaFixa
import factory.ativo.instances.*
import factory.ativo.params.TipoAtivo
import factory.ativo.params.TipoRendimento
import java.time.LocalDate

object AtivoFactory {
    fun createAtivo(
        tipoAtivo: TipoAtivo,
        tipoRendimento: TipoRendimento,
        porcentagemIndice: Double,
        taxaPrefixada: Double,
        banco: String,
        dataVencimento: LocalDate
    ): AtivoRendaFixa {
        return when (tipoAtivo) {
            TipoAtivo.Lcx -> when (tipoRendimento) {
                TipoRendimento.Ipca -> LcxIpca(
                    porcentagemIndice,
                    taxaPrefixada,
                    banco,
                    dataVencimento
                )
                TipoRendimento.Cdi -> LcxCdi(porcentagemIndice, banco, dataVencimento)
                TipoRendimento.Pre -> LcxPre(taxaPrefixada, banco, dataVencimento)
            }
            TipoAtivo.Cdb -> when (tipoRendimento) {
                TipoRendimento.Ipca -> CdbIpca(porcentagemIndice, taxaPrefixada, banco, dataVencimento)
                TipoRendimento.Cdi -> CdbCdi(porcentagemIndice, banco, dataVencimento)
                TipoRendimento.Pre -> CdbPre(taxaPrefixada, banco, dataVencimento)
            }
        }
    }
}