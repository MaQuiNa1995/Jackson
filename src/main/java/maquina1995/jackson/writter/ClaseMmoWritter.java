package maquina1995.jackson.writter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import com.fasterxml.jackson.databind.util.Annotations;

import lombok.NoArgsConstructor;
import maquina1995.jackson.domain.Bruja;
import maquina1995.jackson.domain.ClaseMmo;
import maquina1995.jackson.domain.Kunoichi;

@NoArgsConstructor
public class ClaseMmoWritter extends VirtualBeanPropertyWriter {

	public ClaseMmoWritter(final BeanPropertyDefinition propDef, final Annotations contextAnnotations,
	        final JavaType declaredType) {
		super(propDef, contextAnnotations, declaredType);
	}

	@Override
	protected Object value(final Object bean, final JsonGenerator gen, final SerializerProvider prov) {
		final ClaseMmo typeDto = (ClaseMmo) bean;

		String type = "";

		if (typeDto instanceof Kunoichi) {
			type = "Kunoichi";
		} else if (typeDto instanceof Bruja) {
			type = "Bruja";
		}

		return type;
	}

	@Override
	public VirtualBeanPropertyWriter withConfig(final MapperConfig<?> config, final AnnotatedClass declaringClass,
	        final BeanPropertyDefinition propDef, final JavaType type) {
		return new ClaseMmoWritter(propDef, declaringClass.getAnnotations(), type);
	}

}
