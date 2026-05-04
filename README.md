# 📚 Personal Student Grade Tracker - CLI Edition

A console-based Java application for German students to track academic performance across school years, using state-specific grading rules for all 16 Bundesländer.

![Java](https://img.shields.io/badge/Java-17+-orange.svg)
![Version](https://img.shields.io/badge/Version-1.0--CLI-blue.svg)
![Status](https://img.shields.io/badge/Status-In%20Development-yellow.svg)

> 📖 **Anleitung auf Deutsch**: See [ANLEITUNG.md](ANLEITUNG.md)
> 📖 **English How-To**: See [HOW_TO_USE.md](HOW_TO_USE.md)

## 🎯 Project Overview

**CLI Edition — Part 1 of a 3-part project series:**

| Version | Interface | Storage | Status |
|---------|-----------|---------|--------|
| **v1.x (Current)** | CLI | CSV | In Development |
| v2.0 | JavaFX GUI | CSV | Planned |
| v3.0 | Spring Boot REST API | Database + AWS | Planned |

This CLI version focuses on core business logic, state-specific grading rules, and clean object-oriented design without the complexity of a GUI framework. Core model classes developed here are carried forward into all future versions.

---

## 📌 Version Roadmap (CLI Edition)

### v1.0 — Core School Tracks
Implements the following school tracks across all 16 Bundesländer:
- **Gymnasium** — Years 5–12 or 5–13 (state dependent), full NC calculation
- **Realschule** — Years 5–10, 1-6 grading scale throughout
- **Mittelschule** — Years 5–10, with optional Quali exit at year 9

### v1.1 — Extended School Tracks
Extends v1.0 with:
- **FOS** (Fachoberschule) — Years 11–12 (Fachhochschulreife) or 11–13 (Hochschulreife, state dependent)
- **BOS** (Berufsoberschule) — Years 12–13, or 11–13 with Vorkurs, diploma-dependent
- FOS/BOS specific NC calculations per Bundesland

### Why split v1.0 and v1.1?

FOS and BOS introduce significant additional complexity beyond the core school tracks. Each requires:
- Diploma-type selection (Fachhochschulreife vs. Hochschulreife) which determines available year ranges
- BOS Vorkurs handling at year 11
- Separate NC calculation logic that differs meaningfully from Gymnasium Abitur
- State-specific rules that vary more widely across Bundesländer for vocational tracks than for Gymnasium

Rushing this into v1.0 would risk producing an incomplete or inaccurate implementation of rules that directly affect real students' university applications. A clean, fully correct v1.0 with well-tested core tracks is more valuable — both as a portfolio piece and as a tool — than an overloaded v1.0 with partially implemented FOS/BOS logic.

Both versions live in the same repository. See [Branch Strategy](#-branch-strategy) below.

---

## 🌟 Key Features (v1.0)

### Setup & Profile
- Select your Bundesland (all 16 supported)
- Select your school track (Gymnasium, Realschule, Mittelschule)
- Select your diploma target (Gymnasium only, where applicable)
- Configure grading scale transition year (state-specific)
- Single-student profile, one track per profile

### School Year Management
- Track grades across multiple Jahrgangsstufen
- Years 5–13 available depending on school track and state
- Each school year is fully independent with its own classes and grades
- Mittelschule: optional exit at year 9 with Quali

### Class Management
- Add and remove classes per school year
- Each class belongs to exactly one school year
- View all classes with summary statistics per year

### Grade Entry & Tracking
- Add grades with description and weight
- Edit and delete existing grades
- Full grade history per class
- Input validation against correct grading scale per year

### Grading Scale Support
- **1–6 scale**: All tracks for years below transition year
- **0–15 points scale**: Gymnasium from transition year onward (year 11 or 12, state dependent)
- Transition year is configured at setup based on Bundesland

### GPA & NC Calculation
- Weighted and unweighted GPA per class
- GPA per school year
- Overall GPA across all years
- **NC calculation** for Gymnasium (state-specific rules per Bundesland)

### Statistics
- Best and worst performing classes
- Grade distribution per class and per year
- Performance trend per class (improving / stable / declining)

### Data Persistence
- CSV-based storage split across three files:
    - `student_profile.csv`
    - `school_years_classes.csv`
    - `grades.csv`
- Auto-load on startup, auto-save on exit
- Manual save available at any time
- Export grade report as formatted text file

---

## 🖥️ German Grading Systems

### 1–6 Scale (Sekundarstufe I & pre-transition years)
| Grade | Description | Meaning |
|-------|-------------|---------|
| 1 | Sehr gut | Excellent |
| 2 | Gut | Good |
| 3 | Befriedigend | Satisfactory |
| 4 | Ausreichend | Sufficient |
| 5 | Mangelhaft | Poor |
| 6 | Ungenügend | Insufficient |

### 0–15 Points Scale (Oberstufe)
| Points | Description | Meaning |
|--------|-------------|---------|
| 15–13 | Sehr gut | Excellent |
| 12–10 | Gut | Good |
| 9–7 | Befriedigend | Satisfactory |
| 6–5 | Ausreichend | Sufficient |
| 4–1 | Mangelhaft | Poor |
| 0 | Ungenügend | Insufficient |

---

## 🛠️ Technologies Used

- **Java 17+** — Core language
- **Apache Commons CSV** — CSV file parsing and writing
- **JUnit 5** — Unit testing

## 📋 Prerequisites

- Java Development Kit (JDK) 17 or higher
- Command line / Terminal
- IDE (optional): IntelliJ IDEA, Eclipse, or VS Code

## 🚀 Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/student-grade-tracker-cli.git
   cd student-grade-tracker-cli
   ```

2. **Checkout the desired version**
   ```bash
   # For v1.0 (Gymnasium, Realschule, Mittelschule)
   git checkout release/v1.0

   # For v1.1 (adds FOS and BOS)
   git checkout release/v1.1
   ```

3. **Compile and run**
   ```bash
   javac -d bin src/**/*.java
   java -cp bin Main
   ```

---

## 🏗️ Project Structure

```
student-grade-tracker-cli/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── model/
│   │       │   ├── Student.java
│   │       │   ├── Bundesland.java
│   │       │   ├── SchoolYear.java
│   │       │   ├── SchoolClass.java
│   │       │   ├── Grade.java
│   │       │   ├── GradeCalculator.java
│   │       │   └── NCCalculator.java
│   │       ├── service/
│   │       │   ├── DataManager.java
│   │       │   ├── CSVHandler.java
│   │       │   └── ValidationService.java
│   │       ├── ui/
│   │       │   ├── ConsoleUI.java
│   │       │   └── MenuHandler.java
│   │       └── Main.java
│   └── test/
│       └── java/
│           ├── model/
│           └── service/
├── data/
│   ├── student_profile.csv
│   ├── school_years_classes.csv
│   └── grades.csv
├── exports/
├── HOW_TO_USE.md
├── ANLEITUNG.md
└── README.md
```

---

## 🌿 Branch Strategy

```
main                → latest stable release
develop             → active development
feature/*           → individual feature branches
release/v1.0        → locked, complete v1.0 (Gymnasium, Realschule, Mittelschule)
release/v1.1        → locked, complete v1.1 (adds FOS and BOS)
```

---

## 🎓 Learning Outcomes

- **OOP Design**: Multi-level class hierarchy (Student → SchoolYear → SchoolClass → Grade)
- **Enum Design**: Type-safe state configuration via `Bundesland` enum with fields and methods
- **File I/O**: CSV read/write with Apache Commons CSV
- **Business Logic**: State-specific grading rules and NC calculation
- **Exception Handling**: Robust input validation and file error handling
- **Data Structures**: ArrayLists and HashMaps for structured data management
- **Testing**: JUnit tests for model classes and calculation logic
- **Code Organization**: Clean separation of model, service, and UI layers

---

## 🔄 Development Status

### v1.0
- [x] Project specification
- [x] Class design documentation
- [ ] Core model classes
- [ ] SchoolYear implementation
- [ ] State ruleset configuration
- [ ] CSV persistence
- [ ] Console UI and menu system
- [ ] GPA calculation logic
- [ ] NC calculation (Gymnasium)
- [ ] Quali calculation (Mittelschule)
- [ ] Input validation
- [ ] Export functionality
- [ ] JUnit test suite

### v1.1
- [ ] FOS implementation
- [ ] BOS implementation (incl. Vorkurs)
- [ ] FOS/BOS diploma selection logic
- [ ] FOS/BOS NC calculation (state-specific)
- [ ] Extended test suite

---

## 🚧 Full Project Roadmap

| Version | Description | Repo |
|---------|-------------|------|
| v1.0 | CLI — Core tracks | This repo |
| v1.1 | CLI — FOS & BOS | This repo |
| v2.0 | JavaFX GUI | Separate repo (planned) |
| v3.0 | Spring Boot + AWS | Separate repo (planned) |

---

## 👨‍💻 Author

**[Your Name]**
- Portfolio: [your-portfolio.com](https://your-portfolio.com)
- LinkedIn: [linkedin.com/in/yourprofile](https://linkedin.com/in/yourprofile)
- GitHub: [@yourusername](https://github.com/yourusername)

## 🔗 Related Projects
- [Student Grade Tracker — JavaFX GUI (v2.0)](https://github.com/yourusername/student-grade-tracker-gui) *(Coming Soon)*
- [Student Grade Tracker — Spring Boot API (v3.0)](https://github.com/yourusername/student-grade-tracker-api) *(Coming Soon)*

---

*CLI Edition of a three-part portfolio project series. Each version builds on the last, demonstrating progressive complexity across different Java technologies and architectural patterns.*