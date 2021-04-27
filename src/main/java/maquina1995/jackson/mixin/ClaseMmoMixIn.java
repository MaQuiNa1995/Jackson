package maquina1995.jackson.mixin;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import maquina1995.jackson.writter.ClaseMmoWritter;

@JsonAppend(props = { @Prop(value = ClaseMmoWritter.class,
        name = "propertyMixIn",
        type = String.class) })
public interface ClaseMmoMixIn {

}
