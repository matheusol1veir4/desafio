package br.com.desafio.avaliacao.headless.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sea
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "Representa uma avaliação de desafio (30, 60 ou 90 dias)",
	value = "Avaliacao"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Avaliacao")
public class Avaliacao implements Serializable {

	public static Avaliacao toDTO(String json) {
		return ObjectMapperUtil.readValue(Avaliacao.class, json);
	}

	public static Avaliacao unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Avaliacao.class, json);
	}

	@Schema(
		description = "Área de atuação: 1=Analista Projeto, 2=Tester, 3=UI, 4=Front-end, 5=Back-end"
	)
	public Integer getAreaAtuacao() {
		if (_areaAtuacaoSupplier != null) {
			areaAtuacao = _areaAtuacaoSupplier.get();

			_areaAtuacaoSupplier = null;
		}

		return areaAtuacao;
	}

	public void setAreaAtuacao(Integer areaAtuacao) {
		this.areaAtuacao = areaAtuacao;

		_areaAtuacaoSupplier = null;
	}

	@JsonIgnore
	public void setAreaAtuacao(
		UnsafeSupplier<Integer, Exception> areaAtuacaoUnsafeSupplier) {

		_areaAtuacaoSupplier = () -> {
			try {
				return areaAtuacaoUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(
		description = "Área de atuação: 1=Analista Projeto, 2=Tester, 3=UI, 4=Front-end, 5=Back-end"
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer areaAtuacao;

	@JsonIgnore
	private Supplier<Integer> _areaAtuacaoSupplier;

	@Schema(description = "ID único da avaliação")
	public Long getAvaliacaoId() {
		if (_avaliacaoIdSupplier != null) {
			avaliacaoId = _avaliacaoIdSupplier.get();

			_avaliacaoIdSupplier = null;
		}

		return avaliacaoId;
	}

	public void setAvaliacaoId(Long avaliacaoId) {
		this.avaliacaoId = avaliacaoId;

		_avaliacaoIdSupplier = null;
	}

	@JsonIgnore
	public void setAvaliacaoId(
		UnsafeSupplier<Long, Exception> avaliacaoIdUnsafeSupplier) {

		_avaliacaoIdSupplier = () -> {
			try {
				return avaliacaoIdUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "ID único da avaliação")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long avaliacaoId;

	@JsonIgnore
	private Supplier<Long> _avaliacaoIdSupplier;

	@Schema(description = "Data em que a avaliação foi criada")
	public Date getDataAvaliacao() {
		if (_dataAvaliacaoSupplier != null) {
			dataAvaliacao = _dataAvaliacaoSupplier.get();

			_dataAvaliacaoSupplier = null;
		}

		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;

		_dataAvaliacaoSupplier = null;
	}

	@JsonIgnore
	public void setDataAvaliacao(
		UnsafeSupplier<Date, Exception> dataAvaliacaoUnsafeSupplier) {

		_dataAvaliacaoSupplier = () -> {
			try {
				return dataAvaliacaoUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Data em que a avaliação foi criada")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date dataAvaliacao;

	@JsonIgnore
	private Supplier<Date> _dataAvaliacaoSupplier;

	@Schema(description = "ID do usuário/funcionário sendo avaliado")
	public Long getFuncionarioId() {
		if (_funcionarioIdSupplier != null) {
			funcionarioId = _funcionarioIdSupplier.get();

			_funcionarioIdSupplier = null;
		}

		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;

		_funcionarioIdSupplier = null;
	}

	@JsonIgnore
	public void setFuncionarioId(
		UnsafeSupplier<Long, Exception> funcionarioIdUnsafeSupplier) {

		_funcionarioIdSupplier = () -> {
			try {
				return funcionarioIdUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "ID do usuário/funcionário sendo avaliado")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long funcionarioId;

	@JsonIgnore
	private Supplier<Long> _funcionarioIdSupplier;

	@Schema(
		description = "Observações gerais sobre o desempenho do colaborador"
	)
	public String getObservacoesGerais() {
		if (_observacoesGeraisSupplier != null) {
			observacoesGerais = _observacoesGeraisSupplier.get();

			_observacoesGeraisSupplier = null;
		}

		return observacoesGerais;
	}

	public void setObservacoesGerais(String observacoesGerais) {
		this.observacoesGerais = observacoesGerais;

		_observacoesGeraisSupplier = null;
	}

	@JsonIgnore
	public void setObservacoesGerais(
		UnsafeSupplier<String, Exception> observacoesGeraisUnsafeSupplier) {

		_observacoesGeraisSupplier = () -> {
			try {
				return observacoesGeraisUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(
		description = "Observações gerais sobre o desempenho do colaborador"
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String observacoesGerais;

	@JsonIgnore
	private Supplier<String> _observacoesGeraisSupplier;

	@Schema(description = "Período do desafio: 1=30 dias, 2=60 dias, 3=90 dias")
	public Integer getPeriodoDesafio() {
		if (_periodoDesafioSupplier != null) {
			periodoDesafio = _periodoDesafioSupplier.get();

			_periodoDesafioSupplier = null;
		}

		return periodoDesafio;
	}

	public void setPeriodoDesafio(Integer periodoDesafio) {
		this.periodoDesafio = periodoDesafio;

		_periodoDesafioSupplier = null;
	}

	@JsonIgnore
	public void setPeriodoDesafio(
		UnsafeSupplier<Integer, Exception> periodoDesafioUnsafeSupplier) {

		_periodoDesafioSupplier = () -> {
			try {
				return periodoDesafioUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(
		description = "Período do desafio: 1=30 dias, 2=60 dias, 3=90 dias"
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer periodoDesafio;

	@JsonIgnore
	private Supplier<Integer> _periodoDesafioSupplier;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Avaliacao)) {
			return false;
		}

		Avaliacao avaliacao = (Avaliacao)object;

		return Objects.equals(toString(), avaliacao.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		Integer areaAtuacao = getAreaAtuacao();

		if (areaAtuacao != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"areaAtuacao\": ");

			sb.append(areaAtuacao);
		}

		Long avaliacaoId = getAvaliacaoId();

		if (avaliacaoId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"avaliacaoId\": ");

			sb.append(avaliacaoId);
		}

		Date dataAvaliacao = getDataAvaliacao();

		if (dataAvaliacao != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataAvaliacao\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dataAvaliacao));

			sb.append("\"");
		}

		Long funcionarioId = getFuncionarioId();

		if (funcionarioId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"funcionarioId\": ");

			sb.append(funcionarioId);
		}

		String observacoesGerais = getObservacoesGerais();

		if (observacoesGerais != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"observacoesGerais\": ");

			sb.append("\"");

			sb.append(_escape(observacoesGerais));

			sb.append("\"");
		}

		Integer periodoDesafio = getPeriodoDesafio();

		if (periodoDesafio != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"periodoDesafio\": ");

			sb.append(periodoDesafio);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "br.com.desafio.avaliacao.headless.dto.v1_0.Avaliacao",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof Map) {
						sb.append(_toJSON((Map<String, ?>)valueArray[i]));
					}
					else if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

	private Map<String, Serializable> _extendedProperties;

}