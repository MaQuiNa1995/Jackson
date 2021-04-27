package maquina1995.jackson.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import maquina1995.jackson.domain.Guerrero;

public class GuerreroDeserializer extends StdDeserializer<Guerrero> {

	public GuerreroDeserializer() {
		this(null);
	}

	public GuerreroDeserializer(Class<Guerrero> clazz) {
		super(clazz);
	}

	@Override
	public Guerrero deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {
		Guerrero guerrero;

		ObjectCodec codec = parser.getCodec();
		JsonNode node = codec.readTree(parser);

		JsonNode magiaPropertyNode = node.get("magia");
//		String magia = magiaPropertyNode.asText();
//		guerrero.setColor(color);

		return null;
	}

}
