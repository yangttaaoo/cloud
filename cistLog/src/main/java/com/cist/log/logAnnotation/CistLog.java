package com.cist.log.logAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CistLog {

	String module() default "";
	String action() default "";
	String system() default "";
	LogType type() default LogType.DEFAULT;
	String content() default "";
	
}
