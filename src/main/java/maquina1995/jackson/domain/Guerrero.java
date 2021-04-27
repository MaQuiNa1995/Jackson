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
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonTypeInfo(use = Id.NAME,
        include = As.EXISTING_PROPERTY,
        property = "magia")
@JsonSubTypes({ @Type(value = Valquiria.class,
        name = "Magia Blanca"),
        @Type(value = CaballeroOscuro.class,
                name = "Magia Negra") })
public abstract class Guerrero extends ClaseMmo {

	private String armaSecundaria;
}
