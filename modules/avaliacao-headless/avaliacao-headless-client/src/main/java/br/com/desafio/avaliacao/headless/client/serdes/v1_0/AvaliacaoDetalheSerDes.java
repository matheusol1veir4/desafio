package br.com.desafio.avaliacao.headless.client.serdes.v1_0;

import br.com.desafio.avaliacao.headless.client.dto.v1_0.AvaliacaoDetalhe;
import br.com.desafio.avaliacao.headless.client.json.BaseJSONParser;

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
public class AvaliacaoDetalheSerDes {

	public static AvaliacaoDetalhe toDTO(String json) {
		AvaliacaoDetalheJSONParser avaliacaoDetalheJSONParser =
			new AvaliacaoDetalheJSONParser();

		return avaliacaoDetalheJSONParser.parseToDTO(json);
	}

	public static AvaliacaoDetalhe[] toDTOs(String json) {
		AvaliacaoDetalheJSONParser avaliacaoDetalheJSONParser =
			new AvaliacaoDetalheJSONParser();

		return avaliacaoDetalheJSONParser.parseToDTOs(json);
	}

	public static String toJSON(AvaliacaoDetalhe avaliacaoDetalhe) {
		if (avaliacaoDetalhe == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (avaliacaoDetalhe.getAvaliacaoDetalheId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"avaliacaoDetalheId\": ");

			sb.append(avaliacaoDetalhe.getAvaliacaoDetalheId());
		}

		if (avaliacaoDetalhe.getAvaliacaoId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"avaliacaoId\": ");

			sb.append(avaliacaoDetalhe.getAvaliacaoId());
		}

		if (avaliacaoDetalhe.getDesempenho() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"desempenho\": ");

			sb.append(avaliacaoDetalhe.getDesempenho());
		}

		if (avaliacaoDetalhe.getNomeAvaliador() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nomeAvaliador\": ");

			sb.append("\"");

			sb.append(_escape(avaliacaoDetalhe.getNomeAvaliador()));

			sb.append("\"");
		}

		if (avaliacaoDetalhe.getObservacoesAvaliador() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"observacoesAvaliador\": ");

			sb.append("\"");

			sb.append(_escape(avaliacaoDetalhe.getObservacoesAvaliador()));

			sb.append("\"");
		}

		if (avaliacaoDetalhe.getTipoAvaliador() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tipoAvaliador\": ");

			sb.append(avaliacaoDetalhe.getTipoAvaliador());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AvaliacaoDetalheJSONParser avaliacaoDetalheJSONParser =
			new AvaliacaoDetalheJSONParser();

		return avaliacaoDetalheJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(AvaliacaoDetalhe avaliacaoDetalhe) {
		if (avaliacaoDetalhe == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (avaliacaoDetalhe.getAvaliacaoDetalheId() == null) {
			map.put("avaliacaoDetalheId", null);
		}
		else {
			map.put(
				"avaliacaoDetalheId",
				String.valueOf(avaliacaoDetalhe.getAvaliacaoDetalheId()));
		}

		if (avaliacaoDetalhe.getAvaliacaoId() == null) {
			map.put("avaliacaoId", null);
		}
		else {
			map.put(
				"avaliacaoId",
				String.valueOf(avaliacaoDetalhe.getAvaliacaoId()));
		}

		if (avaliacaoDetalhe.getDesempenho() == null) {
			map.put("desempenho", null);
		}
		else {
			map.put(
				"desempenho", String.valueOf(avaliacaoDetalhe.getDesempenho()));
		}

		if (avaliacaoDetalhe.getNomeAvaliador() == null) {
			map.put("nomeAvaliador", null);
		}
		else {
			map.put(
				"nomeAvaliador",
				String.valueOf(avaliacaoDetalhe.getNomeAvaliador()));
		}

		if (avaliacaoDetalhe.getObservacoesAvaliador() == null) {
			map.put("observacoesAvaliador", null);
		}
		else {
			map.put(
				"observacoesAvaliador",
				String.valueOf(avaliacaoDetalhe.getObservacoesAvaliador()));
		}

		if (avaliacaoDetalhe.getTipoAvaliador() == null) {
			map.put("tipoAvaliador", null);
		}
		else {
			map.put(
				"tipoAvaliador",
				String.valueOf(avaliacaoDetalhe.getTipoAvaliador()));
		}

		return map;
	}

	public static class AvaliacaoDetalheJSONParser
		extends BaseJSONParser<AvaliacaoDetalhe> {

		@Override
		protected AvaliacaoDetalhe createDTO() {
			return new AvaliacaoDetalhe();
		}

		@Override
		protected AvaliacaoDetalhe[] createDTOArray(int size) {
			return new AvaliacaoDetalhe[size];
		}

		@Override
		protected boolean parseMaps(String jsonParserFieldName) {
			if (Objects.equals(jsonParserFieldName, "avaliacaoDetalheId")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "avaliacaoId")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "desempenho")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "nomeAvaliador")) {
				return false;
			}
			else if (Objects.equals(
						jsonParserFieldName, "observacoesAvaliador")) {

				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "tipoAvaliador")) {
				return false;
			}

			return false;
		}

		@Override
		protected void setField(
			AvaliacaoDetalhe avaliacaoDetalhe, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "avaliacaoDetalheId")) {
				if (jsonParserFieldValue != null) {
					avaliacaoDetalhe.setAvaliacaoDetalheId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "avaliacaoId")) {
				if (jsonParserFieldValue != null) {
					avaliacaoDetalhe.setAvaliacaoId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "desempenho")) {
				if (jsonParserFieldValue != null) {
					avaliacaoDetalhe.setDesempenho(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nomeAvaliador")) {
				if (jsonParserFieldValue != null) {
					avaliacaoDetalhe.setNomeAvaliador(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "observacoesAvaliador")) {

				if (jsonParserFieldValue != null) {
					avaliacaoDetalhe.setObservacoesAvaliador(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tipoAvaliador")) {
				if (jsonParserFieldValue != null) {
					avaliacaoDetalhe.setTipoAvaliador(
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