package br.com.desafio.avaliacao.headless.client.serdes.v1_0;

import br.com.desafio.avaliacao.headless.client.dto.v1_0.AvaliacaoCompleta;
import br.com.desafio.avaliacao.headless.client.dto.v1_0.AvaliacaoDetalhe;
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
public class AvaliacaoCompletaSerDes {

	public static AvaliacaoCompleta toDTO(String json) {
		AvaliacaoCompletaJSONParser avaliacaoCompletaJSONParser =
			new AvaliacaoCompletaJSONParser();

		return avaliacaoCompletaJSONParser.parseToDTO(json);
	}

	public static AvaliacaoCompleta[] toDTOs(String json) {
		AvaliacaoCompletaJSONParser avaliacaoCompletaJSONParser =
			new AvaliacaoCompletaJSONParser();

		return avaliacaoCompletaJSONParser.parseToDTOs(json);
	}

	public static String toJSON(AvaliacaoCompleta avaliacaoCompleta) {
		if (avaliacaoCompleta == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (avaliacaoCompleta.getAreaAtuacao() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"areaAtuacao\": ");

			sb.append(avaliacaoCompleta.getAreaAtuacao());
		}

		if (avaliacaoCompleta.getAvaliacaoDetalhes() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"avaliacaoDetalhes\": ");

			sb.append("[");

			for (int i = 0; i < avaliacaoCompleta.getAvaliacaoDetalhes().length;
				 i++) {

				sb.append(
					String.valueOf(
						avaliacaoCompleta.getAvaliacaoDetalhes()[i]));

				if ((i + 1) < avaliacaoCompleta.getAvaliacaoDetalhes().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (avaliacaoCompleta.getAvaliacaoId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"avaliacaoId\": ");

			sb.append(avaliacaoCompleta.getAvaliacaoId());
		}

		if (avaliacaoCompleta.getDataAvaliacao() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataAvaliacao\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					avaliacaoCompleta.getDataAvaliacao()));

			sb.append("\"");
		}

		if (avaliacaoCompleta.getFuncionarioId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"funcionarioId\": ");

			sb.append(avaliacaoCompleta.getFuncionarioId());
		}

		if (avaliacaoCompleta.getObservacoesGerais() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"observacoesGerais\": ");

			sb.append("\"");

			sb.append(_escape(avaliacaoCompleta.getObservacoesGerais()));

			sb.append("\"");
		}

		if (avaliacaoCompleta.getPeriodoDesafio() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"periodoDesafio\": ");

			sb.append(avaliacaoCompleta.getPeriodoDesafio());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AvaliacaoCompletaJSONParser avaliacaoCompletaJSONParser =
			new AvaliacaoCompletaJSONParser();

		return avaliacaoCompletaJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		AvaliacaoCompleta avaliacaoCompleta) {

		if (avaliacaoCompleta == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (avaliacaoCompleta.getAreaAtuacao() == null) {
			map.put("areaAtuacao", null);
		}
		else {
			map.put(
				"areaAtuacao",
				String.valueOf(avaliacaoCompleta.getAreaAtuacao()));
		}

		if (avaliacaoCompleta.getAvaliacaoDetalhes() == null) {
			map.put("avaliacaoDetalhes", null);
		}
		else {
			map.put(
				"avaliacaoDetalhes",
				String.valueOf(avaliacaoCompleta.getAvaliacaoDetalhes()));
		}

		if (avaliacaoCompleta.getAvaliacaoId() == null) {
			map.put("avaliacaoId", null);
		}
		else {
			map.put(
				"avaliacaoId",
				String.valueOf(avaliacaoCompleta.getAvaliacaoId()));
		}

		if (avaliacaoCompleta.getDataAvaliacao() == null) {
			map.put("dataAvaliacao", null);
		}
		else {
			map.put(
				"dataAvaliacao",
				liferayToJSONDateFormat.format(
					avaliacaoCompleta.getDataAvaliacao()));
		}

		if (avaliacaoCompleta.getFuncionarioId() == null) {
			map.put("funcionarioId", null);
		}
		else {
			map.put(
				"funcionarioId",
				String.valueOf(avaliacaoCompleta.getFuncionarioId()));
		}

		if (avaliacaoCompleta.getObservacoesGerais() == null) {
			map.put("observacoesGerais", null);
		}
		else {
			map.put(
				"observacoesGerais",
				String.valueOf(avaliacaoCompleta.getObservacoesGerais()));
		}

		if (avaliacaoCompleta.getPeriodoDesafio() == null) {
			map.put("periodoDesafio", null);
		}
		else {
			map.put(
				"periodoDesafio",
				String.valueOf(avaliacaoCompleta.getPeriodoDesafio()));
		}

		return map;
	}

	public static class AvaliacaoCompletaJSONParser
		extends BaseJSONParser<AvaliacaoCompleta> {

		@Override
		protected AvaliacaoCompleta createDTO() {
			return new AvaliacaoCompleta();
		}

		@Override
		protected AvaliacaoCompleta[] createDTOArray(int size) {
			return new AvaliacaoCompleta[size];
		}

		@Override
		protected boolean parseMaps(String jsonParserFieldName) {
			if (Objects.equals(jsonParserFieldName, "areaAtuacao")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "avaliacaoDetalhes")) {
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
			AvaliacaoCompleta avaliacaoCompleta, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "areaAtuacao")) {
				if (jsonParserFieldValue != null) {
					avaliacaoCompleta.setAreaAtuacao(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "avaliacaoDetalhes")) {
				if (jsonParserFieldValue != null) {
					Object[] jsonParserFieldValues =
						(Object[])jsonParserFieldValue;

					AvaliacaoDetalhe[] avaliacaoDetalhesArray =
						new AvaliacaoDetalhe[jsonParserFieldValues.length];

					for (int i = 0; i < avaliacaoDetalhesArray.length; i++) {
						avaliacaoDetalhesArray[i] =
							AvaliacaoDetalheSerDes.toDTO(
								(String)jsonParserFieldValues[i]);
					}

					avaliacaoCompleta.setAvaliacaoDetalhes(
						avaliacaoDetalhesArray);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "avaliacaoId")) {
				if (jsonParserFieldValue != null) {
					avaliacaoCompleta.setAvaliacaoId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dataAvaliacao")) {
				if (jsonParserFieldValue != null) {
					avaliacaoCompleta.setDataAvaliacao(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "funcionarioId")) {
				if (jsonParserFieldValue != null) {
					avaliacaoCompleta.setFuncionarioId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "observacoesGerais")) {
				if (jsonParserFieldValue != null) {
					avaliacaoCompleta.setObservacoesGerais(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "periodoDesafio")) {
				if (jsonParserFieldValue != null) {
					avaliacaoCompleta.setPeriodoDesafio(
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