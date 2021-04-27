package maquina1995.jackson.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import maquina1995.jackson.domain.ClaseMmo;
import maquina1995.jackson.mixin.ClaseMmoMixIn;

@SpringBootConfiguration
public class JacksonConfig {

	@Primary
	@Bean("serializador")
	public ObjectMapper jacksonBuilder() {
		return new Jackson2ObjectMapperBuilder().indentOutput(true)
		        .serializationInclusion(JsonInclude.Include.NON_NULL)
		        .serializationInclusion(JsonInclude.Include.NON_EMPTY)
		        .mixIn(ClaseMmo.class, ClaseMmoMixIn.class)
		        .build();
	}

	@Bean("serializadorMixIn")
	public ObjectMapper jacksonBuilderWithMixIn() {
		return new Jackson2ObjectMapperBuilder().indentOutput(true)
		        .serializationInclusion(JsonInclude.Include.NON_NULL)
		        .serializationInclusion(JsonInclude.Include.NON_EMPTY)
		        .build();
	}

}
