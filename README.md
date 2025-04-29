# JavaFactory Annotations

A lightweight set of annotations designed to assist in Java LLM-based code generation workflows.

This library provides structured metadata that enables intelligent code generation tools to analyze domain models and APIs effectively.

---

## 📦 Available Annotations

### `@JavaFactoryApi`

Marks a domain-level API interface for LLM-based code generation.

- Defines the references required to generate implementations, fixtures, and test classes. (All fields are optional; specify only what is relevant.)
- Specifies data classes and dependent APIs needed by the implementation.
- Declares the default implementation and fixture classes.
- Marks general supporting classes for code generation.

🔹 **Referenced data** will be recursively explored if it is annotated with `@JavaFactoryData`.

---

### `@JavaFactoryData`

Marks a domain-level data class for LLM-based code generation.

- Intended for JPA entities, domain specifications, and other core models.
- Declares related data classes and support classes.
- Enables recursive traversal when referenced by other APIs or data models.

---

### `@JavaFactoryPattern`

Declares a set of LLM code generation patterns for batch execution.

- Organizes multiple generation tasks under a common pattern name.
- Helps automate grouped code generation operations.

---

## 🚀 Example Usage

```java
@JavaFactoryApi(
    defaultImpl = DefaultUserReader.class,      // optional
    defaultFixture = FakeUserReader.class,      // optional
    referencedData = {UserEntity.class},        // optional
    referencedApi = {NotificationReader.class},  // optional
    referencedClass = {UserMapper.class}        // optional
)
public interface UserReader {
    User findById(Long id);
}
```


```java
@JavaFactoryData(
    referencedData = {Address.class},       // optional
    referencedClass = {PhoneNumber.class}   // optional
)
public class UserEntity { }

```


## 📜 License
This project is licensed under the MIT License.


