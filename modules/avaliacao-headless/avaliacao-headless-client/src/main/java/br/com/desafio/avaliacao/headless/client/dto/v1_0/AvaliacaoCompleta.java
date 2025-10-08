package br.com.desafio.avaliacao.headless.client.dto.v1_0;

import br.com.desafio.avaliacao.headless.client.dto.v1_0.AvaliacaoDetalhe;
import br.com.desafio.avaliacao.headless.client.function.UnsafeSupplier;
import br.com.desafio.avaliacao.headless.client.serdes.v1_0.AvaliacaoCompletaSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author sea
 * @generated
 */
@Generated("")
public class AvaliacaoCompleta implements Cloneable, Serializable {

	public static AvaliacaoCompleta toDTO(String json) {
		return AvaliacaoCompletaSerDes.toDTO(json);
	}

	public Integer getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(Integer areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public void setAreaAtuacao(
		UnsafeSupplier<Integer, Exception> areaAtuacaoUnsafeSupplier) {

		try {
			areaAtuacao = areaAtuacaoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer areaAtuacao;

	public AvaliacaoDetalhe[] getAvaliacaoDetalhes() {
		return avaliacaoDetalhes;
	}

	public void setAvaliacaoDetalhes(AvaliacaoDetalhe[] avaliacaoDetalhes) {
		this.avaliacaoDetalhes = avaliacaoDetalhes;
	}

	public void setAvaliacaoDetalhes(
		UnsafeSupplier<AvaliacaoDetalhe[], Exception>
			avaliacaoDetalhesUnsafeSupplier) {

		try {
			avaliacaoDetalhes = avaliacaoDetalhesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected AvaliacaoDetalhe[] avaliacaoDetalhes;

	public Long getAvaliacaoId() {
		return avaliacaoId;
	}

	public void setAvaliacaoId(Long avaliacaoId) {
		this.avaliacaoId = avaliacaoId;
	}

	public void setAvaliacaoId(
		UnsafeSupplier<Long, Exception> avaliacaoIdUnsafeSupplier) {

		try {
			avaliacaoId = avaliacaoIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long avaliacaoId;

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public void setDataAvaliacao(
		UnsafeSupplier<Date, Exception> dataAvaliacaoUnsafeSupplier) {

		try {
			dataAvaliacao = dataAvaliacaoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dataAvaliacao;

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public void setFuncionarioId(
		UnsafeSupplier<Long, Exception> funcionarioIdUnsafeSupplier) {

		try {
			funcionarioId = funcionarioIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long funcionarioId;

	public String getObservacoesGerais() {
		return observacoesGerais;
	}

	public void setObservacoesGerais(String observacoesGerais) {
		this.observacoesGerais = observacoesGerais;
	}

	public void setObservacoesGerais(
		UnsafeSupplier<String, Exception> observacoesGeraisUnsafeSupplier) {

		try {
			observacoesGerais = observacoesGeraisUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String observacoesGerais;

	public Integer getPeriodoDesafio() {
		return periodoDesafio;
	}

	public void setPeriodoDesafio(Integer periodoDesafio) {
		this.periodoDesafio = periodoDesafio;
	}

	public void setPeriodoDesafio(
		UnsafeSupplier<Integer, Exception> periodoDesafioUnsafeSupplier) {

		try {
			periodoDesafio = periodoDesafioUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer periodoDesafio;

	@Override
	public AvaliacaoCompleta clone() throws CloneNotSupportedException {
		return (AvaliacaoCompleta)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AvaliacaoCompleta)) {
			return false;
		}

		AvaliacaoCompleta avaliacaoCompleta = (AvaliacaoCompleta)object;

		return Objects.equals(toString(), avaliacaoCompleta.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return AvaliacaoCompletaSerDes.toJSON(this);
	}

}