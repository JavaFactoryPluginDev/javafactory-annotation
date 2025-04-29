package io.github.javafactoryplugindev.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Marks a data class for LLM-based code generation.
 *
 * <p>This annotation is intended for JPA entities, domain specifications,
 * and other core data models that need to be referenced in code generation.</p>
 *
 * <p>When referenced, nested data references are collected recursively.</p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JavaFactoryData {


    /**
     * Other data classes referenced by this data class.
     * Recursive traversal is applied.
     */
    Class<?>[] referencedData() default {};

    /**
     * General support classes (e.g., DTOs, utilities) referenced by this data class.
     */
    Class<?>[] referencedClass() default {};
}
