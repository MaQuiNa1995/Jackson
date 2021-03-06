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
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonTypeInfo(use = Id.NAME,
        include = As.PROPERTY,
        property = "propertyAnotación")
@JsonSubTypes({ @Type(value = Bruja.class,
        name = "Bruja"),
        @Type(value = Kunoichi.class,
                name = "Kunoichi"),
        @Type(value = Guerrero.class,
                name = "Guerrero") })
public abstract class ClaseMmo {

	private Long id;
	private String armaPrincipal;
}
