 # 🎓 Realistic QA Problem: “User Input Validator & Formatter for Support Ticket System”

---

### 🧪 🧾 **Scenario**:

You are automating a QA test for a system where users submit support tickets via a form. Each ticket entry is received as a **raw string** from the frontend, and your job is to:

1. Validate the content.
2. Clean, normalize, and parse it.
3. Extract fields.
4. Assert their validity.
5. Format them for backend processing or UI display.

---

### 🧠 👩‍💻 Your mission:

Write a Java program that receives **one raw ticket line**, like this:

```
"  name:   Amanda Estevez  ; email: AMANDA.Estevez@GMAIL.com   ; message:    My App Crashed 💥💥   "
```

You must:

1. **Clean** the input
2. **Extract** fields (`name`, `email`, `message`)
3. **Validate** them
4. **Normalize** values (lowercase email, trim names, clean symbols)
5. **Assert** rules (e.g., name must be only letters, email must be valid, message must not be blank)
6. **Rebuild** the final string as:
   `"amanda estevez | amanda.estevez@gmail.com | my app crashed 💥💥"`

---

### 🧩 🔧 Concepts You'll Use:

* String declaration & comparison
* `.trim()`, `.strip()`, `.replaceAll()`
* `.substring()`, `.indexOf()`, `.charAt()`
* `.equals()`, `.equalsIgnoreCase()`, `.contains()`
* `.toUpperCase()`, `.toLowerCase()`
* `String.split()`, `String.join()`
* `StringBuilder`
* Regex match for email, letters only
* Null/empty/blank checks
* Assertion-style logic
* Unicode-safe emoji handling

---

### ✅ ✨ Your Goal Output:

```java
"amanda estevez | amanda.estevez@gmail.com | my app crashed 💥💥"
```

---

### 🔁 Bonus Variation:

Add a second raw input like this:

```
" name:   1111 ; email: invalid@email ; message:    "
```

This should **fail validation** with appropriate error messages:

* Name must contain only letters
* Email must be valid
* Message cannot be blank

---

## 🧪 🧱 Code Skeleton (Start Here)

```java
package ForgeGuard;

import java.util.regex.*;
import java.text.Normalizer;

public class TicketValidator {

    public static void main(String[] args) {
        String rawTicket = "  name:   Amanda Estevez  ; email: AMANDA.Estevez@GMAIL.com   ; message:    My App Crashed 💥💥   ";
        String cleanedTicket = processTicket(rawTicket);
        System.out.println(cleanedTicket);
    }

    public static String processTicket(String raw) {
        if (raw == null || raw.isBlank()) {
            return "Invalid input: blank or null";
        }

        // TODO: 1. Clean and split input
        // TODO: 2. Extract fields
        // TODO: 3. Validate with regex
        // TODO: 4. Normalize with trim(), lowercase, replaceAll(), etc.
        // TODO: 5. Return final string or error message
        return "You’ll fill this in as you go 🧠";
    }
}
```
