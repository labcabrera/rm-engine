package org.lab.rm.engine.core.model.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Anotacion para determinar que atributos no se serializaran por defecto.
 * 
 * @see Serializer
 */
@Retention(RUNTIME)
@Target({ FIELD, METHOD, TYPE })
public @interface NotSerializable {

}
