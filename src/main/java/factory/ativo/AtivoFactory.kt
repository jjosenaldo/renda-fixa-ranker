package factory.ativo

import factory.ativo.params.TipoAtivo
import factory.ativo.params.TipoRendimento
import factory.ativo.instances.CdbCdi
import factory.ativo.instances.LcxCdi
import factory.ativo.instances.LcxIpca
import factory.ativo.instances.LcxPre
import domain.AtivoRendaFixa
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
                TipoRendimento.Ipca -> TODO("CDB ipca não implementado")
                TipoRendimento.Cdi -> CdbCdi(porcentagemIndice, banco, dataVencimento)
                TipoRendimento.Pre -> TODO("CDB pré-fixado não implementado")
            }
        }
    }
}