
## ✅ Enunciado:

**"Escreva um método em Java que valide se um CPF é válido."**

📌 *Regras principais do CPF*:

* Deve conter **11 dígitos numéricos**
* Pode vir com ou sem **pontuação** (`123.456.789-09` ou `12345678909`)
* O cálculo de validade é feito com base em **dois dígitos verificadores** (os dois últimos)

---

## ✅ Solução completa (explicada depois):

```java
public class CPFValidator {

    public static boolean isValidCPF(String cpf) {
        // Remove pontuação e espaços
        cpf = cpf.replaceAll("[^\\d]", "");

        // Verifica se tem 11 dígitos ou é uma sequência inválida
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Cálculo do primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int digit1 = (sum * 10) % 11;
        if (digit1 == 10) digit1 = 0;

        // Cálculo do segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int digit2 = (sum * 10) % 11;
        if (digit2 == 10) digit2 = 0;

        // Compara com os dígitos fornecidos
        return digit1 == Character.getNumericValue(cpf.charAt(9)) &&
               digit2 == Character.getNumericValue(cpf.charAt(10));
    }

    // Testando o método
    public static void main(String[] args) {
        String cpfValido = "123.456.789-09";
        String cpfInvalido = "111.111.111-11";

        System.out.println("CPF válido? " + isValidCPF(cpfValido));
        System.out.println("CPF inválido? " + isValidCPF(cpfInvalido));
    }
}
```

---

## 🧠 Linha a linha (com visual mental):

Vamos usar o seu formato preferido:

---

### `cpf = cpf.replaceAll("[^\\d]", "");`

📣 *Say it*: "Remove all characters that are not digits"

🧠 *Plain English*: Limpa o CPF, deixando só os números.

🧠 *Mental model*: Um funil que deixa passar apenas números.

---

### `cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")`

📣 *Say it*: "If the CPF doesn't have 11 digits or is all the same digit"

🧠 *Plain English*: CPF inválido se for curto demais ou tipo `111.111.111-11`.

🧠 *Mental model*: Filtro de lixo logo no início.

---

### Cálculo dos dígitos verificadores:

Para o **primeiro dígito**:

* Multiplica os 9 primeiros números por 10 a 2
* Soma os resultados
* `(soma * 10) % 11` define o dígito esperado

Para o **segundo dígito**:

* Usa os 10 primeiros números (já incluindo o primeiro verificador)
* Mesma lógica, multiplicando por 11 a 2

---

## 🧪 Casos de teste:

| Entrada            | Resultado Esperado |
| ------------------ | ------------------ |
| `"123.456.789-09"` | ✅ Válido           |
| `"111.111.111-11"` | ❌ Inválido         |
| `"52998224725"`    | ✅ Válido           |
| `"529.982.247-24"` | ❌ Inválido         |
| `"00000000000"`    | ❌ Inválido         |

---

Se quiser, posso transformar isso em um **teste automatizado com JUnit** ou um exercício do LeetCode customizado pra praticar com as mãos na massa! Vamos nessa? 🚀💡
