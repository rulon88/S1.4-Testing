

# 🧪 Java Testing Exercises – Levels 1, 2 & 3

This repository contains a collection of Java exercises focused on **software testing** using **JUnit 5**, **AssertJ**, and **TDD (Test-Driven Development)**.  
Each level is designed to progressively introduce testing concepts — from basic assertions to complete TDD methodology.

The goal of this project is to learn how to write **clean, modular, and testable Java code**, following professional testing practices and IT Academy guidelines.

---

## 📋 Project Overview

This repository includes three levels of testing:

| Level | Focus | Technologies / Concepts |
|-------|-------|---------------------------|
| Level 1 | Basic unit testing with JUnit 5 | `@Test`, `assertEquals`, `assertThrows`, `@Nested`, `@DisplayName` |
| Level 2 | More expressive assertions using AssertJ | `assertThat`, `isEqualTo`, `containsExactly`, `doesNotHaveDuplicates`, `assertThatThrownBy`, `Optional` |
| Level 3 | TDD methodology (Red → Green → Refactor) | Write test first, then code, then refactor; use of parametrized tests, Given/When/Then style |

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

Starting DniCalculator Test Suite...
INFO: New DniCalculator instance created.
WARNING: Testing invalid DNI...
INFO: Test completed.
DniCalculator Test Suite finished.

## 📖 Summary by Level

### Level 1: JUnit Basics

Exercises include:
- **Library** management (add, remove, sort, get by position)
- **DNI calculation** using `@ParameterizedTest` and `@CsvSource`
- Throwing and catching `ArrayIndexOutOfBoundsException`

This level ensures you understand how to write unit tests in JUnit 5, how to group tests, and how to use lifecycle annotations.

### Level 2: AssertJ Assertions

Exercises include:
- Comparing integers, object references
- Verifying two arrays are identical
- ArrayLists with different data types: verifying order, duplicates, containment
- Maps: verifying presence of keys and entries
- Exception testing with `assertThatThrownBy`
- Optional: verifying empty or present Optional

This level adds fluency and readability to your tests via AssertJ.

### Level 3: TDD – Calculator Example

You’ll build a `Calculator` class following **TDD cycles**:

- Write tests first (fail intentionally)
- Implement just enough code to make tests pass
- Refactor the implementation without breaking tests

Tests include addition, subtraction, multiplication, division, and division by zero.

---

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
