

# 🧪 Java Testing Exercises – Levels 1, 2 & 3

This repository contains a collection of Java exercises focused on **software testing** using **JUnit 5**, **AssertJ**, and **TDD (Test-Driven Development)**.  
Each level is designed to progressively introduce testing concepts — from basic assertions to complete TDD methodology.

The goal of this project is to learn how to write **clean, modular, and testable Java code**, following professional testing practices and IT Academy guidelines.

---

## 📋 Project Overview

This repository includes three levels of testing:

| Level | Focus | Technologies / Concepts |
|-------|--------|--------------------------|
| **Level 1** | Basic unit testing with JUnit 5 | `@Test`, `assertEquals`, `assertThrows`, `@Nested`, `@DisplayName` |
| **Level 2** | More expressive assertions with AssertJ | `assertThat`, `isEqualTo`, `doesNotHaveDuplicates`, `assertThatThrownBy`, `Optional` |
| **Level 3** | TDD methodology (Red → Green → Refactor) | Write tests first → Implement → Refactor; Calculator example with exception handling |
---
## 🧩 Test Structure and Conventions

All tests follow a **consistent, professional structure** to ensure readability, isolation, and maintainability.

### 🧠 JUnit Annotations Used

| Annotation | Purpose |
|-------------|----------|
| `@BeforeAll` | Runs once before all tests — used to initialize shared resources or print a test suite header. |
| `@AfterAll` | Runs once after all tests — used to print a test suite summary or clean up. |
| `@BeforeEach` | Runs before every test — initializes fresh objects to ensure test isolation. |
| `@AfterEach` | Runs after every test — prints log messages or performs cleanup. |
| `@Test` | Marks a method as a test case. |
| `@DisplayName` | Provides a descriptive name for better readability in test reports. |
| `@Tag("happy") / @Tag("bad")` | Groups tests into categories: **Happy Path** (valid inputs) and **Bad Path** (invalid inputs or exceptions). |
| `@Nested` | Groups related test cases into inner classes for cleaner organization. |
| `@ParameterizedTest` | Runs the same test with multiple inputs. |
| `@CsvSource` | Supplies parameter sets to a parameterized test. |

## 🧾 Logger Implementation

All test classes include a `java.util.logging.Logger` instance to provide **structured console output**.  
This helps identify:
- Which test suite is running (`>>> Starting Library Test Suite…`)
- Which phase of the test lifecycle is active (`INFO`, `WARNING`)
- Which methods are being tested and their outcomes.

This makes the execution logs more readable and realistic for **professional QA workflows**.

Example console output:

-Starting DniCalculator Test Suite...

-INFO: New DniCalculator instance created.

-WARNING: Testing invalid DNI...

-INFO: Test completed.

-DniCalculator Test Suite finished.
## 📖 Summary by Level

### 🔹 Level 1 – JUnit Basics
Exercises include:
- **Library** management (add, remove, sort, get by position)
- **DNI calculation** using `@ParameterizedTest` and `@CsvSource`
- Exception handling (`ArrayIndexOutOfBoundsException`)
  Focus: learn test grouping, lifecycle annotations, and exception handling.

### 🔹 Level 2 – AssertJ Assertions
Exercises include:
- Integer and object comparisons
- ArrayList order, duplicates, containment
- Map key/value checks
- Exception testing with `assertThatThrownBy`
- Optional validation (`isEmpty`, `isPresent`)
  Focus: improve readability and fluency using AssertJ.

### 🔹 Level 3 – TDD Calculator
Follow the **TDD cycle** (Red → Green → Refactor):
- Write failing tests first
- Implement only what’s needed to pass
- Refactor safely  
  Covers: addition, subtraction, multiplication, division, and division-by-zero.

## Technologies Used

- **Java JDK 21**
- **IntelliJ IDEA Community Edition** (or Eclipse)
- **Git & GitHub**
- **Maven** for dependency management
- **AssertJ 3.25.3** for structured test output

---

## 📋 Requirements

- **Java Development Kit (JDK 21 or higher)**
- **Git** installed to clone the repository
- An IDE such as **IntelliJ IDEA** or **Eclipse**

---

## 🛠️ Installation & Repository

Clone the repository and open it in your IDE:

```bash
  git clone https://github.com/rulon88/S1.4-Testing.git
