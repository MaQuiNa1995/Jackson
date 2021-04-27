package maquina1995.jackson.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import maquina1995.jackson.domain.ClaseMmo;
import maquina1995.jackson.domain.Guerrero;

@Slf4j
@Service
public class JacksonService {

	@Resource(name = "serializador")
	private ObjectMapper objectMapper;

	@Resource(name = "serializadorMixIn")
	private ObjectMapper objectMapperConMixIn;

	@Resource(name = "serializadorDeserializadorCustom")
	private ObjectMapper objectMapperConDeserializadorCustom;

	public void serializacion(ClaseMmo claseMmo) throws JsonProcessingException {

		String json = objectMapper.writeValueAsString(claseMmo);
		this.mostrarEnPantalla(claseMmo, json);
	}

	public void serializacionConMixIn(ClaseMmo claseMmo) throws JsonProcessingException {

		String json = objectMapperConMixIn.writeValueAsString(claseMmo);
		this.mostrarEnPantalla(claseMmo, json);
	}

	public void deserializarjson(String json) throws JsonProcessingException {

		log.info("Deserializando JSON...");
		log.info(objectMapperConDeserializadorCustom.readValue(json, Guerrero.class)
		        .toString());

	}

	private void mostrarEnPantalla(ClaseMmo claseMmo, String json) {
		log.info("Serializando: {} ", claseMmo.getClass()
		        .getSimpleName());
		log.info("JSON Procesado:\n{}", json);
	}

}
