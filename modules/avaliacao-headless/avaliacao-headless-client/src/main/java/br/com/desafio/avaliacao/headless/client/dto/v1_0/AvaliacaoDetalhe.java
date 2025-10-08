package br.com.desafio.avaliacao.headless.client.dto.v1_0;

import br.com.desafio.avaliacao.headless.client.function.UnsafeSupplier;
import br.com.desafio.avaliacao.headless.client.serdes.v1_0.AvaliacaoDetalheSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author sea
 * @generated
 */
@Generated("")
public class AvaliacaoDetalhe implements Cloneable, Serializable {

	public static AvaliacaoDetalhe toDTO(String json) {
		return AvaliacaoDetalheSerDes.toDTO(json);
	}

	public Long getAvaliacaoDetalheId() {
		return avaliacaoDetalheId;
	}

	public void setAvaliacaoDetalheId(Long avaliacaoDetalheId) {
		this.avaliacaoDetalheId = avaliacaoDetalheId;
	}

	public void setAvaliacaoDetalheId(
		UnsafeSupplier<Long, Exception> avaliacaoDetalheIdUnsafeSupplier) {

		try {
			avaliacaoDetalheId = avaliacaoDetalheIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long avaliacaoDetalheId;

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

	public Integer getDesempenho() {
		return desempenho;
	}

	public void setDesempenho(Integer desempenho) {
		this.desempenho = desempenho;
	}

	public void setDesempenho(
		UnsafeSupplier<Integer, Exception> desempenhoUnsafeSupplier) {

		try {
			desempenho = desempenhoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer desempenho;

	public String getNomeAvaliador() {
		return nomeAvaliador;
	}

	public void setNomeAvaliador(String nomeAvaliador) {
		this.nomeAvaliador = nomeAvaliador;
	}

	public void setNomeAvaliador(
		UnsafeSupplier<String, Exception> nomeAvaliadorUnsafeSupplier) {

		try {
			nomeAvaliador = nomeAvaliadorUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String nomeAvaliador;

	public String getObservacoesAvaliador() {
		return observacoesAvaliador;
	}

	public void setObservacoesAvaliador(String observacoesAvaliador) {
		this.observacoesAvaliador = observacoesAvaliador;
	}

	public void setObservacoesAvaliador(
		UnsafeSupplier<String, Exception> observacoesAvaliadorUnsafeSupplier) {

		try {
			observacoesAvaliador = observacoesAvaliadorUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String observacoesAvaliador;

	public Integer getTipoAvaliador() {
		return tipoAvaliador;
	}

	public void setTipoAvaliador(Integer tipoAvaliador) {
		this.tipoAvaliador = tipoAvaliador;
	}

	public void setTipoAvaliador(
		UnsafeSupplier<Integer, Exception> tipoAvaliadorUnsafeSupplier) {

		try {
			tipoAvaliador = tipoAvaliadorUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer tipoAvaliador;

	@Override
	public AvaliacaoDetalhe clone() throws CloneNotSupportedException {
		return (AvaliacaoDetalhe)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AvaliacaoDetalhe)) {
			return false;
		}

		AvaliacaoDetalhe avaliacaoDetalhe = (AvaliacaoDetalhe)object;

		return Objects.equals(toString(), avaliacaoDetalhe.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return AvaliacaoDetalheSerDes.toJSON(this);
	}

}