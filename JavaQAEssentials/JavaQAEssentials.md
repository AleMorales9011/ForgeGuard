# Java QA Essentials

### ✅ 1. **String Manipulation**

📌 *Categoria*: Alta frequência em entrevistas QA.

**Exemplos típicos:**

* Verificar se uma string é palíndromo.
* Validar e-mails ou senhas com expressões regulares.
* Contar frequência de caracteres.
* Remover caracteres duplicados.

**Conceitos aplicados**: `String`, `StringBuilder`, `Pattern`, `Matcher`, `Character`, `substring()`, `equals()`.

🧠 *Por que é cobrado?*
Testar entradas é uma tarefa do dia a dia de um QA (como validar se campos aceitam certas regras), então saber manipular e filtrar strings mostra domínio da linguagem e aplicabilidade prática.

---

### ✅ 2. **Input Validation / Regex Problems**

📌 *Categoria*: Muito comum em testes para QA.

**Exemplos típicos:**

* Validar CPF, IP, URL, telefone, etc.
* Usar `Pattern.matches()` ou `Matcher.find()`.

**Conceitos aplicados**: Expressões Regulares (`regex`), `Pattern`, `Matcher`.

🧠 *Por que é cobrado?*
Porque você precisa garantir que seu sistema **não aceite entradas inválidas ou perigosas** (ex: XSS, SQL Injection, etc). Além disso, regex é poderosa e aparece em várias ferramentas como Selenium, Cucumber, Postman, JMeter.

---

### ✅ 3. **Filtering and Predicate Logic**

📌 *Categoria*: Cobrado para ver se você entende **Streams e Lógica condicional**.

**Exemplos típicos:**

* Dada uma lista, filtre apenas os válidos com base em alguma regra.
* Use `filter`, `map`, `collect` no estilo Java 8+.

**Conceitos aplicados**: `Stream`, `filter`, `Predicate`, `Optional`, `Collectors`.

🧠 *Por que é cobrado?*
Em testes de regressão, você muitas vezes recebe uma lista de dados e precisa filtrar somente os que devem aparecer no front-end. Esse tipo de lógica é idêntica ao que você vai usar na vida real com Selenium ou APIs.

---

### ✅ 4. **Control Flow / If-Else Decision Making**

📌 *Categoria*: Fundamentos de programação.

**Exemplos típicos:**

* Se input começa com "A", retorne "Aceito", senão "Rejeitado".
* Faça diferentes ações dependendo do conteúdo da string.

**Conceitos aplicados**: `if/else`, `switch`, `boolean logic`.

🧠 *Por que é cobrado?*
Simples: você precisa saber **tomar decisões no código**, especialmente em testes automatizados onde o comportamento muda com base na entrada.

---

### ✅ 5. **Data Filtering in Collections**

📌 *Categoria*: Java Collections

**Exemplos típicos:**

* Remover entradas inválidas de uma lista.
* Agrupar strings por um critério.
* Criar Mapas com `Collectors.groupingBy(...)`.

**Conceitos aplicados**: `List`, `Set`, `Map`, `Streams`, `Collectors`.

🧠 *Por que é cobrado?*
Porque em QA você vai trabalhar com listas de dados de bancos, arquivos, APIs... e filtrar é essencial para validações precisas.

---

### ✅ Como isso aparece em entrevistas de QA?

| Tipo de Pergunta                                                  | Categoria envolvida       |
| ----------------------------------------------------------------- | ------------------------- |
| "Escreva um método que valide um CPF."                            | Regex + String            |
| "Dada uma lista de emails, filtre apenas os válidos."             | Regex + Streams           |
| "Como você faria para garantir que o campo aceita apenas letras?" | Input Validation + Regex  |
| "Escreva um teste que rejeite inputs inválidos."                  | Control Flow + Assertions |
| "Filtre os elementos de uma lista de usuários com idade > 18"     | Streams + Filtering       |


### ✅ 6. **Array and List Operations**

🎯 *Why it matters*: You often get lists of data (from APIs, UI tables, DBs) to validate.

**Common Questions:**

* Find duplicates in an array.
* Remove an element from a list.
* Find the max/min number.
* Compare two lists for equality.
* Rotate an array.

**Core APIs**: `int[]`, `List<T>`, `Arrays`, `Collections`

---

### ✅ 7. **Collections Framework**

🎯 *Why it matters*: Data from the app or backend comes in the form of `List`, `Map`, or `Set`.

**Common Questions:**

* What’s the difference between `ArrayList` and `LinkedList`?
* When do you use `Set`?
* Iterate through a `Map` and print key-value pairs.
* Remove duplicates using `Set`.
* Sort a `List` of custom objects.

**Core APIs**: `ArrayList`, `LinkedList`, `HashMap`, `HashSet`, `TreeMap`, `Stream`

---

### ✅ 8. **Java 8+ Features (Streams, Lambdas)**

🎯 *Why it matters*: Filtering data is crucial in test validation and assertions.

**Common Questions:**

* Use `stream().filter()` to filter based on condition.
* Convert a list to a map.
* Count occurrences using `Collectors.groupingBy()`.
* Write a lambda to process a collection.

**Core APIs**: `Stream`, `filter()`, `map()`, `collect()`, `forEach()`

### ✅ 9. **OOP Concepts (Object-Oriented Programming)**

🎯 *Why it matters*: Helps you design test frameworks and page objects in Selenium.

**Common Questions:**

* Difference between `class` and `object`.
* What is inheritance? Polymorphism?
* Interface vs Abstract class.
* What are constructors? Method overloading vs overriding.

---

### ✅ 10. **Exception Handling**

🎯 *Why it matters*: Robust test automation handles exceptions gracefully.

**Common Questions:**

* Difference between `checked` and `unchecked` exceptions.
* Try-catch-finally usage.
* Custom exception creation.
* What happens if you throw inside a try block?

---

### ✅ 11. **File Handling**

🎯 *Why it matters*: Many test cases involve reading from or writing to files (logs, CSV, JSON, etc.).

**Common Questions:**

* Read a file line-by-line.
* Write text to a file.
* Read JSON or properties file.
* Count lines or words in a file.

---

### ✅ 12. **Date and Time APIs**

🎯 *Why it matters*: Validating timestamps, logs, or deadlines is part of QA.

**Common Questions:**

* Get current date and time.
* Format a date.
* Add/subtract days from a date.
* Compare two dates.

**Core APIs**: `LocalDate`, `LocalDateTime`, `DateTimeFormatter`

---

### ✅ 13. **Multithreading (for senior QA roles)**

🎯 *Why it matters*: Sometimes QA automation involves parallel execution or thread-safe validations.

**Common Questions:**

* What is a thread?
* Difference between `Runnable` and `Thread`.
* What is synchronization?
* Simple producer-consumer problem.

