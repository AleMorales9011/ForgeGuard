# 🧩 🧪 Practice Problem: **Feedback Form Processor**

---

### 🎯 Context:

You work in a QA team testing an **online feedback form** for a company's product review portal.

Each raw input string comes from the frontend and looks like this:

```
"  user:   JOHN DOE  ; rating:  5  ; comment:   Loved the product!!! 😍   "
```

Your job is to:

1. **Clean** and **split** the input.
2. **Extract** each field: `user`, `rating`, `comment`.
3. **Validate**:

    * User name must be **letters and spaces** only.
    * Rating must be a **number from 1 to 5**.
    * Comment cannot be empty or blank.
4. **Normalize**:

    * Convert name to **lowercase with only one space between words**.
    * Keep comment **as is**, but trim and remove excessive punctuation if needed.
5. **Format** the final result as:

```
"john doe | 5 | loved the product!!! 😍"
```

---

## ✅ Example Inputs and Outputs:

| Input                                                                       | Output                                                                  |   |                            |
| --------------------------------------------------------------------------- | ----------------------------------------------------------------------- | - | -------------------------- |
| `" user:   Jane Smith ; rating: 4 ; comment:    Very helpful product 👍  "` | \`"jane smith                                                           | 4 | very helpful product 👍"\` |
| `" user: 1234 ; rating: 7 ; comment:    "`                                  | `"Invalid user name: letters only"`, or `"Invalid rating: must be 1–5"` |   |                            |

---

## 🧱 Problem Skeleton

Create a new Java class `FeedbackValidator` with:

```java
package ForgeGuard;

public class FeedbackValidator {

    public static void main(String[] args) {
        String rawInput = "  user:   JOHN DOE  ; rating:  5  ; comment:   Loved the product!!! 😍   ";
        String result = processFeedback(rawInput);
        System.out.println(result);
    }

    public static String processFeedback(String raw) {
        // Step 1: Clean and split
        // Step 2: Extract fields and validate
        // Step 3: Normalize and format output
        return "You implement it step by step 😎";
    }
}
```

---

## ✅ Key Concepts You'll Practice Again:

| Category                | Examples you'll use again            |   |                      |
| ----------------------- | ------------------------------------ | - | -------------------- |
| Basic handling          | `String`, `equals()`, `length()`     |   |                      |
| String comparison       | `.equalsIgnoreCase()`, `.contains()` |   |                      |
| Trimming and replacing  | `.trim()`, `.replaceAll()`           |   |                      |
| Case conversion         | `.toLowerCase()`                     |   |                      |
| Splitting and joining   | `.split()`, `StringBuilder`          |   |                      |
| Substrings & positions  | `.indexOf()`, `.charAt()`            |   |                      |
| Regex matching          | `[a-zA-Z ]+`, `[1-5]`, etc.          |   |                      |
| Null/empty/blank checks | `isBlank()`                          |   |                      |
| Assertion-like logic    | Early `return` with error message    |   |                      |
| QA-style formatting     | \`"john doe                          | 5 | loved the product"\` |


