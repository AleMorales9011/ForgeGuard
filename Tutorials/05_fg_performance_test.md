# ForgeGuard - Performance Testing - Login
Estimated Time: 2 hours<br>
Tech Stack: Jmeter CLI<br>
Keywords: Automation - Testing - QA - Apache Jmeter<br>
Experience Level: Beginner - Advanced

This guide documents the steps to create, execute, and interpret a performance test using JMeter for 
the `/authenticate` endpoint of the site [https://practice.expandtesting.com](https://practice.expandtesting.com).

# About Apache Jmeter:
**Apache JMeter** is an open-source tool designed to simulate real-world load on web applications, APIs, and services,
allowing teams to measure performance, stability, and scalability under various traffic conditions. Its primary
use cases include **load testing**, **stress testing**, **spike testing**, and **performance regression validation**
— especially for REST APIs and backend endpoints. JMeter answers critical questions like: *"How many users can this 
system handle?"*, *"Where does performance degrade?"*, and *"Did our latest update impact response time?"*. It is an 
essential tool in any QA strategy because it helps prevent crashes, poor user experience, and costly downtime before
production releases. When using **Java and Cucumber** for test automation, running JMeter via the 
**command line interface (CLI)** is the best practice — it keeps performance testing **decoupled**, **repeatable**, 
and **easily integrated** into CI/CD pipelines, without bloating your core functional testing code.

## 📁 Folder Structure

```
jmeter-tests/
├── plans/
│   └── jmeter_login_test_authenticate.jmx       # Test plan (.jmx)
├── results/
│   └── login.jtl                                # Raw results (JTL file)
└── reports/
    └── login/
        ├── index.html                           # HTML report
        ├── statistics.json                      # Underlying metrics
        ├── content/                             # Report assets (JS/CSS)
        └── sbadmin2-1.0.7/                       # Admin theme for reports
```

## ✅ Steps to Build and Run the Test

### 1. Create the Test Plan (`.jmx`)

🧠 Most people:

* Build a base `.jmx` with the **GUI**
* Then tweak or automate small edits **by script or token substitution**

### 🔹 1. **Nobody writes full `.jmx` files from scratch by hand**

* They’re complex XML files
* They’re full of nested structures (`hashTree` inside `hashTree`...)
* Even JMeter’s own developers use the **GUI to generate them**
* Writing by hand is error-prone, and one tag out of place can break everything

---
### 🔹 2. **Understanding the components gives you power**

When you recognize:

| Component                    | Purpose                                |
|------------------------------|----------------------------------------|
| `ThreadGroup`                | Simulates users and timing             |
| `HTTPSamplerProxy`           | Represents an HTTP request             |
| `HeaderManager`              | Adds headers like `Content-Type`       |
| `Arguments`                  | Sends form or query parameters         |
| `ResponseAssertion`          | Checks if the server replied correctly |
| `ViewResultsTree` (GUI only) | Lets you debug visually                |
| `BackendListener`            | Sends metrics to Grafana or InfluxDB   |

✅ You’ll know how to:

* Modify the request without breaking the XML
* Debug a failing test by checking what’s missing
* Write shell scripts to swap out data (e.g. users or URLs)
* Spot problems in CI (e.g., JMeter complaining about bad structure)

---
## 🧠 Smart Strategy

| Focus Area                        | How to Learn                                                       |
|-----------------------------------|--------------------------------------------------------------------|
| 🧩 Understand `.jmx` structure    | Open files in text editor and GUI side by side                     |
| 🛠 Build in GUI, inspect XML      | Make changes, compare the output                                   |
| ⚙️ Learn the XML for key elements | Practice editing only the HTTP Request, ThreadGroup, and Headers   |
| 🚀 Automate with CLI              | Practice `jmeter -n -t ... -l ... -o ...` until it's second nature |

---
- Use JMeter to create a **Thread Group** with:
    - 10 users
    - 10-second ramp-up
    - 1 loop each
- Add an **HTTP Request**:
    - Method: `POST`
    - URL: `https://practice.expandtesting.com/authenticate`
    - Parameters:
        - `username = practice`
        - `password = SuperSecretPassword!`
    - Enable **Follow Redirects** = true
    - Disable **Auto Redirects** = false
- Add an **HTTP Header Manager** with:
    - `Content-Type: application/x-www-form-urlencoded`

Save it to: `jmeter-tests/plans/jmeter_login_test_authenticate.jmx`

---

### 2. Run the Test via CLI

```bash
jmeter -n   -t jmeter-tests/plans/jmeter_login_test_authenticate.jmx   -l jmeter-tests/results/login.jtl   -e -o jmeter-tests/reports/login
```

- `-n`: non-GUI mode
- `-t`: test plan to run
- `-l`: output raw results (JTL)
- `-e`: generate HTML report
- `-o`: output folder for the HTML report

---

### 3. Open the Report

Open in browser:
```
jmeter-tests/reports/login/index.html
```

It includes:
- Average/Min/Max response time
- Error %, Throughput, and latency charts
- Visual graphs for load and distribution

---

## 📌 Tips

- Use DevTools to inspect real POST request structure
- Avoid using JMeter for JS-heavy flows — it does not process JS or DOM
- Use assertions or follow-up samplers to check for redirect success (/secure)
- Store `.jmx` and results separately for clean versioning
- You can integrate this flow into CI/CD with Maven, GitHub Actions, or Jenkins

---

## ✍️ Author Notes

This test was created as part of the ForgeScale QA automation strategy and follows a modular folder
layout for performance testing. Ideal for expanding to other endpoints or scaling up.




