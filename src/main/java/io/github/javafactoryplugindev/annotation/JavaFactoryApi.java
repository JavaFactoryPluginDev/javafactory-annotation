package io.github.javafactoryplugindev.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Marks a domain-level API interface for LLM-based code generation.
 *
 * <p>This annotation defines reference information necessary to generate
 * the implementation, fixture, and test classes related to the API.</p>
 *
 * <p>Key roles:</p>
 * <ul>
 *   <li>Defines the reference points for automatic code generation.</li>
 *   <li>Specifies related data classes and dependent APIs required by the implementation.</li>
 *   <li>Declares the default implementation and fixture classes of the API.</li>
 *   <li>Marks general supporting classes required for code generation.</li>
 * </ul>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JavaFactoryApi {

    /**
     * Default implementation class for this API (e.g., DefaultXxx).
     */
    Class<?> defaultImpl() default Void.class;

    /**
     * Default fixture class for testing this API (e.g., FakeXxx).
     */
    Class<?> defaultFixture() default Void.class; // default fixture class , this flag can be used making user prompt

    /**
     * Data classes referenced by this API.
     *
     * <p>Normally, referenced classes are collected with one-level traversal only.
     * However, if a referenced class is annotated with {@link JavaFactoryData},
     * its nested references are recursively collected as well.</p>
     */
    Class<?>[] referencedData() default {}; // mark other data classes that this implementation should use

    /**
     * Other API interfaces referenced by this API's Implementation or test.
     */
    Class<?>[] referencedApi() default {}; // mark other api classes that this implementation should use

    /**
     * General support classes (e.g., utility classes, converters) referenced by this API.
     */
    Class<?>[] referencedClass() default {}; // ✅ 일반 참조 클래스
}

