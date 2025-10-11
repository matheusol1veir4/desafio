package br.com.desafio.avaliacao.headless.internal.converter;

import br.com.desafio.avaliacao.headless.dto.v1_0.Avaliacao;
import br.com.desafio.avaliacao.headless.dto.v1_0.AvaliacaoCompleta;
import br.com.desafio.avaliacao.headless.dto.v1_0.AvaliacaoDetalhe;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe utilitária para conversão entre Entities do Service Layer e DTOs do REST.
 *
 * Centraliza toda a lógica de mapeamento para manter os Resources limpos
 * e garantir consistência nas conversões.
 *
 * @author sea
 */
public class ConverterDto {

    // ========================================
    // AVALIACAO CONVERSIONS - APENAS OS USADOS
    // ========================================

    /**
     * Converte entity Avaliacao para DTO.
     */
    public static Avaliacao entityToDto(br.com.example.model.avaliacao.model.Avaliacao entity) {
        if (entity == null) {
            return null;
        }

        Avaliacao dto = new Avaliacao();  // Cria novo DTO
        dto.setAvaliacaoId(entity.getAvaliacaoId());        // Mapeia ID
        dto.setFuncionarioId(entity.getFuncionarioId());    // Mapeia funcionário
        dto.setDataAvaliacao(entity.getDataAvaliacao());    // Date direto, sem conversão
        dto.setPeriodoDesafio(entity.getPeriodoDesafio());  // Mapeia período
        dto.setObservacoesGerais(entity.getObservacoesGerais()); // Mapeia observações
        dto.setAreaAtuacao(entity.getAreaAtuacao());        // Mapeia área
        return dto;  // Retorna DTO preenchido
    }

    /**
     * Converte lista de entities para lista de DTOs.
     */
    public static List<Avaliacao> entityListToDtoList(
            List<br.com.example.model.avaliacao.model.Avaliacao> entities) {

        if (entities == null) {
            return null;
        }

        return entities.stream()
                .map(ConverterDto::entityToDto)
                .collect(Collectors.toList());
    }

    // ========================================
    // AVALIACAO DETALHE CONVERSIONS - APENAS OS USADOS
    // ========================================

    /**
     * Converte entity AvaliacaoDetalhe para DTO.
     */
    public static AvaliacaoDetalhe detalheEntityToDto(
            br.com.example.model.avaliacao.model.AvaliacaoDetalhe entity) {

        if (entity == null) {
            return null;
        }

        AvaliacaoDetalhe dto = new AvaliacaoDetalhe();  // Cria novo DTO
        dto.setAvaliacaoDetalheId(entity.getAvaliacaoDetalheId()); // Mapeia ID do detalhe
        dto.setAvaliacaoId(entity.getAvaliacaoId());               // Mapeia ID da avaliação pai
        dto.setTipoAvaliador(entity.getTipoAvaliador());           // Mapeia tipo avaliador
        dto.setNomeAvaliador(entity.getNomeAvaliador());           // Mapeia nome avaliador
        dto.setObservacoesAvaliador(entity.getObservacoesAvaliador()); // Mapeia observações
        dto.setDesempenho(entity.getDesempenho());                 // Mapeia nota desempenho
        return dto;  // Retorna DTO preenchido
    }

    /**
     * Converte lista de entities AvaliacaoDetalhe para lista de DTOs.
     */
    public static List<AvaliacaoDetalhe> detalheEntityListToDtoList(
            List<br.com.example.model.avaliacao.model.AvaliacaoDetalhe> entities) {

        if (entities == null) {
            return null;
        }

        return entities.stream()
                .map(ConverterDto::detalheEntityToDto)
                .collect(Collectors.toList());
    }

    /**
     * Converte lista de entities AvaliacaoDetalhe para array de DTOs.
     */
    public static AvaliacaoDetalhe[] detalheEntityListToDtoArray(
            List<br.com.example.model.avaliacao.model.AvaliacaoDetalhe> entities) {

        if (entities == null || entities.isEmpty()) {
            return new AvaliacaoDetalhe[0];
        }

        return entities.stream()
                .map(ConverterDto::detalheEntityToDto)
                .toArray(AvaliacaoDetalhe[]::new);
    }

    // ========================================
    // AVALIACAO COMPLETA CONVERSIONS - APENAS O USADO
    // ========================================

    /**
     * Converte entities para DTO AvaliacaoCompleta (formulário completo).
     *
     * @param avaliacaoEntity Entity da avaliação principal
     * @param detalhesEntities Lista de entities dos detalhes
     * @return DTO completo com avaliação e detalhes
     */
    public static AvaliacaoCompleta toAvaliacaoCompleta(
            br.com.example.model.avaliacao.model.Avaliacao avaliacaoEntity,
            List<br.com.example.model.avaliacao.model.AvaliacaoDetalhe> detalhesEntities) {

        if (avaliacaoEntity == null) {
            return null;
        }

        AvaliacaoCompleta dto = new AvaliacaoCompleta();

        // Mapear dados da avaliação
        dto.setAvaliacaoId(avaliacaoEntity.getAvaliacaoId());
        dto.setFuncionarioId(avaliacaoEntity.getFuncionarioId());
        dto.setDataAvaliacao(avaliacaoEntity.getDataAvaliacao());
        dto.setPeriodoDesafio(avaliacaoEntity.getPeriodoDesafio());
        dto.setObservacoesGerais(avaliacaoEntity.getObservacoesGerais());
        dto.setAreaAtuacao(avaliacaoEntity.getAreaAtuacao());

        // Mapear detalhes
        dto.setAvaliacaoDetalhes(detalheEntityListToDtoArray(detalhesEntities));

        return dto;
    }
}
