
# 🧠 Progressive Regex Cheat Sheet (for QA Ninjas)

## 🧩 LEVEL 1: What do you want to match? (Characters)

| Goal                      | Regex      | Meaning                     |
|---------------------------|------------|-----------------------------|
| A digit                   | `\d`       | Same as `[0-9]`             |
| A letter                  | `[a-zA-Z]` | Covers upper/lowercase      |
| A word character          | `\w`       | Letters, digits, underscore |
| A whitespace              | `\s`       | Space, tab, newline         |
| Anything (except newline) | `.`        | Wildcard match              |
| A specific character      | `.` or `-` | Escape special ones: `\.`   |

🧠 Think of this level as: *“What’s the content?”*

---

## 🔁 LEVEL 2: How many times? (Quantifiers)

| Goal                | Regex   | Meaning                   |
|---------------------|---------|---------------------------|
| Exactly one         | `a`     | The letter a              |
| Zero or more        | `*`     | Can be empty              |
| One or more         | `+`     | Must appear at least once |
| Optional            | `?`     | Appears 0 or 1 times      |
| Exactly N           | `{3}`   | Appears 3 times           |
| Between min and max | `{2,5}` | From 2 to 5 times         |

🧠 Think of this level as: *“How many repetitions do I allow?”*

---

## 🧱 LEVEL 3: In what structure/order? (Sequences & Groups)

| Goal                  | Regex Example | Meaning                       |                          |
|-----------------------|---------------|-------------------------------|--------------------------|
| Group things together | `(abc)`       | Treats as a unit              |                          |
| Combine patterns      | `a\d`         | Letter a followed by a digit  |                          |
| Capture part of match | `(abc)`       | Used later as `$1` in replace |                          |
| Alternatives (OR)     | \`abc         | xyz\`                         | Match "abc" **or** "xyz" |

🧠 This is the **glue** that lets you build smart patterns.

---

## 📌 LEVEL 4: Where in the string? (Anchors & Boundaries)

| Goal                    | Regex   | Meaning                           |
|-------------------------|---------|-----------------------------------|
| Start of string         | `^`     | Example: `^abc` = starts with abc |
| End of string           | `$`     | Example: `abc$` = ends with abc   |
| Whole string must match | `^abc$` | Exactly “abc”                     |
| Word boundary           | `\b`    | Start/end of a word               |
| Not a word boundary     | `\B`    | Inside a word                     |

🧠 Think of this as: *“Where should the match happen?”*

---

## 🔍 LEVEL 5: Practical QA Patterns

| Task                    | Regex                              | Purpose                       |                                  |
|-------------------------|------------------------------------|-------------------------------|----------------------------------|
| CPF: 11 digits          | `^\d{11}$`                         | Validate Brazilian CPF format |                                  |
| All digits same         | `(\d)\1{10}`                       | Ex: `00000000000`, `111...`   |                                  |
| Email (simple version)  | `^[\w.-]+@[\w.-]+\.[a-zA-Z]{2,6}$` | QA-style format check         |                                  |
| Phone (PT-BR mask)      | `^\(\d{2}\)\d{5}-\d{4}$`           | (99)99999-9999                |                                  |
| Trim punctuation at end | \`(\p{Punct})\1+(?=\s              | \$)\`                         | Reduce !!! to ! before space/end |

---

## ⚙️ LEVEL 6: Java-Specific Usage

| Goal            | Java Example                  |
|-----------------|-------------------------------|
| Match string    | `"abc123".matches("\\w{6}")`  |
| Replace pattern | `str.replaceAll("\\s+", " ")` |
| Capture groups  | `Matcher.group(1)`            |
| Compile pattern | `Pattern.compile("...")`      |
| Safe usage      | Always use `\\` in strings    |

---

## 🏆 LEVEL 7: Build from English

| Description                             | Regex                   |       |
|-----------------------------------------|-------------------------|-------|
| “Starts with 3 digits, then a dash”     | `^\d{3}-`               |       |
| “Ends with a letter and a digit”        | `[a-zA-Z]\d$`           |       |
| “Any 8-digit number”                    | `\d{8}`                 |       |
| “Email with at least one dot in domain” | `\w+@[\w-]+(\.[\w-]+)+` |       |
| “Remove repeating punctuation at end”   | \`(\p{Punct})\1+(?=\s   | \$)\` |

