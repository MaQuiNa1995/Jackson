package maquina1995.jackson.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonTypeInfo(use = Id.NAME,
        include = As.PROPERTY,
        property = "tipoDeClase")
@JsonSubTypes({ @Type(value = Bruja.class,
        name = "Bruja"),
        @Type(value = Kunoichi.class,
                name = "Kunoichi"), })
public abstract class ClaseMmo {

	private Long id;
	private String armaPrincipal;
}
