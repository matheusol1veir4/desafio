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
	description = "Detalhe de avaliação feita por TechLead, Gerente ou RH",
	value = "AvaliacaoDetalhe"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "AvaliacaoDetalhe")
public class AvaliacaoDetalhe implements Serializable {

	public static AvaliacaoDetalhe toDTO(String json) {
		return ObjectMapperUtil.readValue(AvaliacaoDetalhe.class, json);
	}

	public static AvaliacaoDetalhe unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(AvaliacaoDetalhe.class, json);
	}

	@Schema(description = "ID único do detalhe")
	public Long getAvaliacaoDetalheId() {
		if (_avaliacaoDetalheIdSupplier != null) {
			avaliacaoDetalheId = _avaliacaoDetalheIdSupplier.get();

			_avaliacaoDetalheIdSupplier = null;
		}

		return avaliacaoDetalheId;
	}

	public void setAvaliacaoDetalheId(Long avaliacaoDetalheId) {
		this.avaliacaoDetalheId = avaliacaoDetalheId;

		_avaliacaoDetalheIdSupplier = null;
	}

	@JsonIgnore
	public void setAvaliacaoDetalheId(
		UnsafeSupplier<Long, Exception> avaliacaoDetalheIdUnsafeSupplier) {

		_avaliacaoDetalheIdSupplier = () -> {
			try {
				return avaliacaoDetalheIdUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "ID único do detalhe")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long avaliacaoDetalheId;

	@JsonIgnore
	private Supplier<Long> _avaliacaoDetalheIdSupplier;

	@Schema(description = "ID da avaliação pai")
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

	@GraphQLField(description = "ID da avaliação pai")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long avaliacaoId;

	@JsonIgnore
	private Supplier<Long> _avaliacaoIdSupplier;

	@Schema(
		description = "Nota: 1=Insatisfatório, 2=Regular, 3=Bom, 4=Ótimo, 5=Excelente"
	)
	public Integer getDesempenho() {
		if (_desempenhoSupplier != null) {
			desempenho = _desempenhoSupplier.get();

			_desempenhoSupplier = null;
		}

		return desempenho;
	}

	public void setDesempenho(Integer desempenho) {
		this.desempenho = desempenho;

		_desempenhoSupplier = null;
	}

	@JsonIgnore
	public void setDesempenho(
		UnsafeSupplier<Integer, Exception> desempenhoUnsafeSupplier) {

		_desempenhoSupplier = () -> {
			try {
				return desempenhoUnsafeSupplier.get();
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
		description = "Nota: 1=Insatisfatório, 2=Regular, 3=Bom, 4=Ótimo, 5=Excelente"
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer desempenho;

	@JsonIgnore
	private Supplier<Integer> _desempenhoSupplier;

	@Schema(description = "Nome completo do avaliador")
	public String getNomeAvaliador() {
		if (_nomeAvaliadorSupplier != null) {
			nomeAvaliador = _nomeAvaliadorSupplier.get();

			_nomeAvaliadorSupplier = null;
		}

		return nomeAvaliador;
	}

	public void setNomeAvaliador(String nomeAvaliador) {
		this.nomeAvaliador = nomeAvaliador;

		_nomeAvaliadorSupplier = null;
	}

	@JsonIgnore
	public void setNomeAvaliador(
		UnsafeSupplier<String, Exception> nomeAvaliadorUnsafeSupplier) {

		_nomeAvaliadorSupplier = () -> {
			try {
				return nomeAvaliadorUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Nome completo do avaliador")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String nomeAvaliador;

	@JsonIgnore
	private Supplier<String> _nomeAvaliadorSupplier;

	@Schema(description = "Comentários do avaliador sobre o colaborador")
	public String getObservacoesAvaliador() {
		if (_observacoesAvaliadorSupplier != null) {
			observacoesAvaliador = _observacoesAvaliadorSupplier.get();

			_observacoesAvaliadorSupplier = null;
		}

		return observacoesAvaliador;
	}

	public void setObservacoesAvaliador(String observacoesAvaliador) {
		this.observacoesAvaliador = observacoesAvaliador;

		_observacoesAvaliadorSupplier = null;
	}

	@JsonIgnore
	public void setObservacoesAvaliador(
		UnsafeSupplier<String, Exception> observacoesAvaliadorUnsafeSupplier) {

		_observacoesAvaliadorSupplier = () -> {
			try {
				return observacoesAvaliadorUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Comentários do avaliador sobre o colaborador")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String observacoesAvaliador;

	@JsonIgnore
	private Supplier<String> _observacoesAvaliadorSupplier;

	@Schema(description = "Tipo: 1=TechLead, 2=Gerente, 3=RH")
	public Integer getTipoAvaliador() {
		if (_tipoAvaliadorSupplier != null) {
			tipoAvaliador = _tipoAvaliadorSupplier.get();

			_tipoAvaliadorSupplier = null;
		}

		return tipoAvaliador;
	}

	public void setTipoAvaliador(Integer tipoAvaliador) {
		this.tipoAvaliador = tipoAvaliador;

		_tipoAvaliadorSupplier = null;
	}

	@JsonIgnore
	public void setTipoAvaliador(
		UnsafeSupplier<Integer, Exception> tipoAvaliadorUnsafeSupplier) {

		_tipoAvaliadorSupplier = () -> {
			try {
				return tipoAvaliadorUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Tipo: 1=TechLead, 2=Gerente, 3=RH")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer tipoAvaliador;

	@JsonIgnore
	private Supplier<Integer> _tipoAvaliadorSupplier;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		Long avaliacaoDetalheId = getAvaliacaoDetalheId();

		if (avaliacaoDetalheId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"avaliacaoDetalheId\": ");

			sb.append(avaliacaoDetalheId);
		}

		Long avaliacaoId = getAvaliacaoId();

		if (avaliacaoId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"avaliacaoId\": ");

			sb.append(avaliacaoId);
		}

		Integer desempenho = getDesempenho();

		if (desempenho != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"desempenho\": ");

			sb.append(desempenho);
		}

		String nomeAvaliador = getNomeAvaliador();

		if (nomeAvaliador != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nomeAvaliador\": ");

			sb.append("\"");

			sb.append(_escape(nomeAvaliador));

			sb.append("\"");
		}

		String observacoesAvaliador = getObservacoesAvaliador();

		if (observacoesAvaliador != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"observacoesAvaliador\": ");

			sb.append("\"");

			sb.append(_escape(observacoesAvaliador));

			sb.append("\"");
		}

		Integer tipoAvaliador = getTipoAvaliador();

		if (tipoAvaliador != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tipoAvaliador\": ");

			sb.append(tipoAvaliador);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "br.com.desafio.avaliacao.headless.dto.v1_0.AvaliacaoDetalhe",
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