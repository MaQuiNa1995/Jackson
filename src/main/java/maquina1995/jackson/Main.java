package maquina1995.jackson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import maquina1995.jackson.domain.Bruja;
import maquina1995.jackson.domain.Kunoichi;
import maquina1995.jackson.service.JacksonService;

@SpringBootApplication
public class Main implements CommandLineRunner {

	public static void main(String... args) {
		new SpringApplicationBuilder(Main.class).web(WebApplicationType.NONE)
		        .run();
	}

	@Autowired
	private JacksonService jacksonService;

	@Override
	public void run(String... args) throws Exception {

		Kunoichi kunoichi = new Kunoichi();
		kunoichi.setId(1L);
		kunoichi.setArmaPrincipal("Espada Corta");
		kunoichi.setArmaSecundaria("Kunai/Shuriken");

		jacksonService.serializacion(kunoichi);

		Bruja bruja = new Bruja();
		bruja.setId(2L);
		bruja.setArmaPrincipal("Bastón");
		bruja.setMagia("Magia Negra");

		jacksonService.serializacion(bruja);
	}

}
