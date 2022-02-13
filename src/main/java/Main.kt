import factory.ativo.AtivoFactory
import factory.ativo.params.TipoAtivo
import factory.ativo.params.TipoRendimento
import domain.Investimento
import java.time.LocalDate

fun main() {
    val investimentos = listOf(
        Investimento(
            1000.0,
            AtivoFactory.createAtivo(
                TipoAtivo.Lcx,
                TipoRendimento.Cdi,
                1.02,
                0.0,
                "Sofisa Direto",
                dataVencimento = LocalDate.now().plusYears(2)
            ),
            LocalDate.now()
        ),
        Investimento(
            1000.0,
            AtivoFactory.createAtivo(
                TipoAtivo.Cdb,
                TipoRendimento.Cdi,
                1.15,
                0.0,
                "Sofisa Direto",
                dataVencimento = LocalDate.now().plusYears(2)
            ),
            LocalDate.now()
        )
    )

    investimentos.sorted().forEach {
        println(it)
    }
}