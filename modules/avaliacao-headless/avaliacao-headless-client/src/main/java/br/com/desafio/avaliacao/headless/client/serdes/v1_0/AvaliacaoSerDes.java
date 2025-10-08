package br.com.desafio.avaliacao.headless.client.serdes.v1_0;

import br.com.desafio.avaliacao.headless.client.dto.v1_0.Avaliacao;
import br.com.desafio.avaliacao.headless.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author sea
 * @generated
 */
@Generated("")
public class AvaliacaoSerDes {

	public static Avaliacao toDTO(String json) {
		AvaliacaoJSONParser avaliacaoJSONParser = new AvaliacaoJSONParser();

		return avaliacaoJSONParser.parseToDTO(json);
	}

	public static Avaliacao[] toDTOs(String json) {
		AvaliacaoJSONParser avaliacaoJSONParser = new AvaliacaoJSONParser();

		return avaliacaoJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Avaliacao avaliacao) {
		if (avaliacao == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (avaliacao.getAreaAtuacao() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"areaAtuacao\": ");

			sb.append(avaliacao.getAreaAtuacao());
		}

		if (avaliacao.getAvaliacaoId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"avaliacaoId\": ");

			sb.append(avaliacao.getAvaliacaoId());
		}

		if (avaliacao.getDataAvaliacao() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataAvaliacao\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(avaliacao.getDataAvaliacao()));

			sb.append("\"");
		}

		if (avaliacao.getFuncionarioId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"funcionarioId\": ");

			sb.append(avaliacao.getFuncionarioId());
		}

		if (avaliacao.getObservacoesGerais() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"observacoesGerais\": ");

			sb.append("\"");

			sb.append(_escape(avaliacao.getObservacoesGerais()));

			sb.append("\"");
		}

		if (avaliacao.getPeriodoDesafio() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"periodoDesafio\": ");

			sb.append(avaliacao.getPeriodoDesafio());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AvaliacaoJSONParser avaliacaoJSONParser = new AvaliacaoJSONParser();

		return avaliacaoJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Avaliacao avaliacao) {
		if (avaliacao == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (avaliacao.getAreaAtuacao() == null) {
			map.put("areaAtuacao", null);
		}
		else {
			map.put("areaAtuacao", String.valueOf(avaliacao.getAreaAtuacao()));
		}

		if (avaliacao.getAvaliacaoId() == null) {
			map.put("avaliacaoId", null);
		}
		else {
			map.put("avaliacaoId", String.valueOf(avaliacao.getAvaliacaoId()));
		}

		if (avaliacao.getDataAvaliacao() == null) {
			map.put("dataAvaliacao", null);
		}
		else {
			map.put(
				"dataAvaliacao",
				liferayToJSONDateFormat.format(avaliacao.getDataAvaliacao()));
		}

		if (avaliacao.getFuncionarioId() == null) {
			map.put("funcionarioId", null);
		}
		else {
			map.put(
				"funcionarioId", String.valueOf(avaliacao.getFuncionarioId()));
		}

		if (avaliacao.getObservacoesGerais() == null) {
			map.put("observacoesGerais", null);
		}
		else {
			map.put(
				"observacoesGerais",
				String.valueOf(avaliacao.getObservacoesGerais()));
		}

		if (avaliacao.getPeriodoDesafio() == null) {
			map.put("periodoDesafio", null);
		}
		else {
			map.put(
				"periodoDesafio",
				String.valueOf(avaliacao.getPeriodoDesafio()));
		}

		return map;
	}

	public static class AvaliacaoJSONParser extends BaseJSONParser<Avaliacao> {

		@Override
		protected Avaliacao createDTO() {
			return new Avaliacao();
		}

		@Override
		protected Avaliacao[] createDTOArray(int size) {
			return new Avaliacao[size];
		}

		@Override
		protected boolean parseMaps(String jsonParserFieldName) {
			if (Objects.equals(jsonParserFieldName, "areaAtuacao")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "avaliacaoId")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "dataAvaliacao")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "funcionarioId")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "observacoesGerais")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "periodoDesafio")) {
				return false;
			}

			return false;
		}

		@Override
		protected void setField(
			Avaliacao avaliacao, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "areaAtuacao")) {
				if (jsonParserFieldValue != null) {
					avaliacao.setAreaAtuacao(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "avaliacaoId")) {
				if (jsonParserFieldValue != null) {
					avaliacao.setAvaliacaoId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dataAvaliacao")) {
				if (jsonParserFieldValue != null) {
					avaliacao.setDataAvaliacao(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "funcionarioId")) {
				if (jsonParserFieldValue != null) {
					avaliacao.setFuncionarioId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "observacoesGerais")) {
				if (jsonParserFieldValue != null) {
					avaliacao.setObservacoesGerais(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "periodoDesafio")) {
				if (jsonParserFieldValue != null) {
					avaliacao.setPeriodoDesafio(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
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
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			sb.append(_toJSON(value));

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static String _toJSON(Object value) {
		if (value instanceof Map) {
			return _toJSON((Map)value);
		}

		Class<?> clazz = value.getClass();

		if (clazz.isArray()) {
			StringBuilder sb = new StringBuilder("[");

			Object[] values = (Object[])value;

			for (int i = 0; i < values.length; i++) {
				sb.append(_toJSON(values[i]));

				if ((i + 1) < values.length) {
					sb.append(", ");
				}
			}

			sb.append("]");

			return sb.toString();
		}

		if (value instanceof String) {
			return "\"" + _escape(value) + "\"";
		}

		return String.valueOf(value);
	}

}