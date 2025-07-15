# 🧪 Problem Statement: Verify Google Search
## *From Start to Finish – "Headless & Automated"*

### 🌍 **Context:**

You work at **Google** on the **Search Reliability Team**. Your job? Build a smoke test that runs automatically every
time the search homepage is deployed. This test needs to verify that:

* The page loads successfully — even in headless mode.
* The search bar and logo are working.
* A query returns a valid title.
* No alerts break the experience.
* Failures are caught with screenshots for analysis.

This is your **“All-in-One” end-to-end test**, combining everything from browser setup to clean up.

## Summary 
This test should open Google in headless mode, wait for the search box, perform a search for "Selenium WebDriver",
verify the page elements and title, handle any alert, takes a screenshot if the title is wrong, and run locally or
via Selenium Grid. ✅🌐📸

---

# 🧠 Total Concepts Covered
- ✅ WebDriver
- ✅ Locators
- ✅ WebElements
- ✅ Waits (implicit, explicit, fluent)
- ✅ Page Object Model
- ✅ PageFactory
- ✅ Headless
- ✅ Screenshot on failure
- ✅ Alert handling
- ✅ Assertions
- ✅ Cross-browser & Grid-ready structure

---

## ✅ Test Requirements:

| Description                                          | Why It Matters                                                  |
|------------------------------------------------------|-----------------------------------------------------------------|
| Set Chrome options to configure the browser.         | Ensures you can run tests silently with `--headless`.           |
| Add logic to switch between local and Selenium Grid. | Makes the test flexible for local and distributed environments. |
| Launch the browser with the chosen options.          | Starts the browser in the environment you selected.             |
| Set a default implicit wait time.                    | Helps handle small delays in finding elements.                  |
| Navigate to the Google home page.                    | The test must start with a real user journey.                   |
| Use the Page Object pattern.                         | Keeps your code clean, reusable, and test-friendly.             |
| Verify the search box is present.                    | Confirms that the page loaded correctly.                        |
| Explicitly wait for the search box.                  | Ensures the element is interactable.                            |
| Add extra resilience using fluent waits.             | Handles slow page loads or flaky test timing.                   |
| Submit a real search term.                           | Simulates a genuine user action.                                |
| Check if Google’s logo is visible.                   | Validates that the page layout is intact.                       |
| Confirm that the page title matches expectations.    | This proves that the search worked correctly.                   |
| Safely dismiss alerts if they appear.                | Prevents your test from crashing due to pop-ups.                |
| Capture a screenshot if the title is wrong.          | Helps debug when something fails unexpectedly.                  |
| Cleanly close the browser.                           | Frees system resources and ends the session properly.           |

---

## ✅ Page Object Model Requirements

| Step                                               | Description                                                      | Why It Matters                                            |
|----------------------------------------------------|------------------------------------------------------------------|-----------------------------------------------------------|
| 1. `@FindBy` elements                              | Use PageFactory to find `searchBox` and `logo` elements.         | Reduces locator duplication and speeds up test writing.   |
| 2. `search(String keyword)`                        | Send text to the search box and submit the form.                 | Validates the core feature of Google Search: query input. |
| 3. `waitForSearchBoxExplicit()`                    | Wait explicitly up to 10s for the search box.                    | Handles dynamic loading – prevents flaky tests.           |
| 4. `waitForSearchBoxFluent()`                      | Use fluent wait to retry every 2s until visible.                 | Gives more control and resilience to slow loads.          |
| 5. `handleAlertIfExists()`                         | Catch and dismiss any alert that pops up.                        | Prevents test crashes from unexpected modal alerts.       |
| 6. `takeScreenshotOnFailure(String expectedTitle)` | If the page title doesn’t match the expected, take a screenshot. | Captures proof of failure for debugging.                  |

---

## 🧭 Motivation:

By completing this, you’ll be able to:

* Build robust Page Objects for real companies
* Handle dynamic waits like a pro
* Debug UI issues with screenshots
* Gain confidence for job interviews and project challenges




