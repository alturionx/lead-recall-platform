package br.com.alturionx.leadrecall.lead.enums;
public enum Intencao {

    COMPRAR_VEICULO("COMPRAR_VEICULO"),     // Quer comprar um veículo

    VENDER_VEICULO("VENDER_VEICULO"),       // Quer vender um veículo para a concessionária

    DAR_NA_TROCA("DAR_NA_TROCA"),           // Quer utilizar um veículo como entrada

    FINANCIAMENTO("FINANCIAMENTO"),         // Interesse em financiamento

    INFORMACOES_VEICULO("INFORMACOES_VEICULO"), // Busca informações sobre um veículo

    ORCAMENTO("ORCAMENTO"),                 // Solicita orçamento

    TEST_DRIVE("TEST_DRIVE"),               // Deseja agendar um test drive

    DESCONHECIDA("DESCONHECIDA");           // Não foi possível identificar

    private final String descricao;

    Intencao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
