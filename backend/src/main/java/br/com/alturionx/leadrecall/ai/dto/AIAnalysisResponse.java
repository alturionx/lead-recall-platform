package br.com.alturionx.leadrecall.ai.dto;

import java.math.BigDecimal;

import br.com.alturionx.leadrecall.lead.enums.Intencao;
import br.com.alturionx.leadrecall.lead.enums.Transmissao;

public record AIAnalysisResponse(

        Intencao intencao,

        String nome,

        String veiculoInteresse,

        String marca,

        String modelo,

        Integer ano,

        BigDecimal orcamento,

        Transmissao transmissao,

        String resumo,

        Integer confianca

) {

}