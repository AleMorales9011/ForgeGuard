# 🧪 **Challenge Statement: "The QA Shield for Mission-Critical Search"**

🔍 **Scenario:**
You just joined a high-stakes QA automation team responsible for testing **critical user journeys** on
a search-driven government portal that millions rely on daily. Your mission? Build a bulletproof Page Object for 
the search page — ensuring every interaction, delay, alert, and failure is gracefully handled and traceable.

🎯 **Mission Objective:**
Implement a **resilient, reusable automation module** that:

* Validates that the search field and logo render correctly (layout sanity check).
* Waits for the search field using multiple strategies (explicit and fluent).
* Submits search terms and handles alerts that might pop up.
* Takes a screenshot when things go wrong, so no bug escapes untraced.

🛠️ **You’ll Master Along the Way:**

| Skill                   | Why it Matters                 | What You'll Practice                                                   |
|-------------------------|--------------------------------|------------------------------------------------------------------------|
| Page Object Model (POM) | Organizes UI test logic        | Creating a `AllInOnePage` class that encapsulates locators and actions |
| Selenium PageFactory    | Efficient element discovery    | Using `@FindBy` annotations to define elements                         |
| Explicit & Fluent Waits | Handle dynamic content loading | Implementing waits for elements that might not load immediately        |
| Java Exception Handling | Build robust test flows        | Prevents test crashes from unexpected alerts                           |
| Screenshot Capture      | Debugging visual bugs          | Automatically capturing evidence when assertions fail                  |

Screenshot Capture	Debugging visual bugs	Automatically capturing evidence when assertions fail

# 💥 Final Test:
Simulate a broken search by purposely checking for the wrong page title and triggering the screenshot method. 
If you see the file fail.png appear in your project folder, your automation worked — and your QA shield is active. 🛡️
