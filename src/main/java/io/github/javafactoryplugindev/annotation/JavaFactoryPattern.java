package io.github.javafactoryplugindev.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;




/**
 * Defines a set of code generation patterns for batch execution.
 *
 * <p>This annotation is used to group multiple code generation tasks
 * under a common pattern name.</p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JavaFactoryPattern {

    /**
     * List of pattern names for LLM code generation.
     */
    String[] value();
}

