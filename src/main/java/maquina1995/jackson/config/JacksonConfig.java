package maquina1995.jackson.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import maquina1995.jackson.deserializer.GuerreroDeserializer;
import maquina1995.jackson.domain.ClaseMmo;
import maquina1995.jackson.domain.Guerrero;
import maquina1995.jackson.mixin.ClaseMmoMixIn;

@SpringBootConfiguration
public class JacksonConfig {

	@Primary
	@Bean("serializador")
	public ObjectMapper jacksonBuilder() {
		return new Jackson2ObjectMapperBuilder().indentOutput(false)
		        .serializationInclusion(JsonInclude.Include.NON_NULL)
		        .serializationInclusion(JsonInclude.Include.NON_EMPTY)
		        .mixIn(ClaseMmo.class, ClaseMmoMixIn.class)
		        .build();
	}

	@Bean("serializadorMixIn")
	public ObjectMapper jacksonBuilderconMixIn() {
		return new Jackson2ObjectMapperBuilder().indentOutput(true)
		        .serializationInclusion(JsonInclude.Include.NON_NULL)
		        .serializationInclusion(JsonInclude.Include.NON_EMPTY)
		        .build();
	}

	@Bean("serializadorDeserializadorCustom")
	public ObjectMapper jacksonBuilderConDeserializadorCustom() {

		ObjectMapper objectMapper = new Jackson2ObjectMapperBuilder().indentOutput(true)
		        .serializationInclusion(JsonInclude.Include.NON_NULL)
		        .serializationInclusion(JsonInclude.Include.NON_EMPTY)
		        .build();

		this.registrarDeserializador(objectMapper);

		return objectMapper;
	}

	private void registrarDeserializador(ObjectMapper objectMapper) {
		SimpleModule module = new SimpleModule("CustomGuerreroDeserializer", new Version(1, 0, 0, null, null, null));
		module.addDeserializer(Guerrero.class, new GuerreroDeserializer());
		objectMapper.registerModule(module);
	}

}
