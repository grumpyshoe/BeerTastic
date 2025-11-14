<h1 align="center">🍺 BeerTastic</h1>

<p align="center">
  <a href="https://opensource.org/licenses/MIT"><img alt="License" src="https://img.shields.io/badge/License-MIT-purple.svg"/></a>
  <a href="https://android-arsenal.com/api?level=26"><img alt="API" src="https://img.shields.io/badge/API-26%2B-brightgreen.svg"/></a>
  <a href="https://github.com/grumpyshoe/BeerTastic/actions"><img alt="Build Status" src="https://github.com/grumpyshoe/BeerTastic/workflows/Android%20CI/badge.svg"/></a>
</p>

<p align="center">
  <em>An Android showcase app built with Clean Architecture, Jetpack Compose, and the Punk API.</em>
</p>

---

<div align="center">
  <img src="documentation/preview/splashscreen.png" width="23%"/>
  <img src="documentation/preview/beerOverview.png" width="23%"/>
  <img src="documentation/preview/beerDetails.png" width="23%"/>
</div>

---

## 🏁 Introduction

**BeerTastic** is a showcase Android app that demonstrates how to build scalable, maintainable, and testable projects following **Clean Architecture** principles.  
It serves as a practical example of modern Android development with **Jetpack Compose** and **Kotlin**.

---

## 🍻 App Overview

The app fetches data from the [Punk API](https://punkapi.com/documentation/v2) to display a variety of beers.

### ✨ Features
- Infinite scrolling beer list on the home screen
- Option to display a **random beer**
- Detailed view for each beer with extended information
- Mark beers as **favorites** — favorites are highlighted and displayed at the top of the list for quick access

---

## 🧱 Architecture

The project follows the **Clean Architecture** pattern to ensure high testability, separation of concerns, and modularity.  
At the top level, the project consists of the following modules:

### Project Structure
```
:app                 → Main application module  
:data                → Handles API calls, repositories, and data sources  
:domain              → Contains use cases and business logic  
:presentation        → UI layer (Jetpack Compose, ViewModels)
  ├─ :common         → Shared UI components, themes, and resources  
  ├─ :features
  │   ├─ :home       → Beer list and random beer screen  
  │   ├─ :details    → Detailed beer information screen  
  │   └─ :splashscreen → App startup screen  
```

The UI is fully built with **Jetpack Compose**.

---

## ⚙️ Tech Stack

| Category | Technology |
|-----------|-------------|
| **Language** | [Kotlin](https://kotlinlang.org/) |
| **UI Framework** | [Jetpack Compose](https://developer.android.com/jetpack/compose) |
| **Architecture** | Clean Architecture |
| **Async Programming** | [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html), [Flow](https://kotlinlang.org/docs/flow.html) |
| **Dependency Injection** | [Koin](https://insert-koin.io/) |
| **Networking** | [Retrofit](https://square.github.io/retrofit/) |
| **Build System** | Gradle (Modularized Setup) |

---

## 🚀 Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/grumpyshoe/BeerTastic.git
cd BeerTastic
```

### 2. Open the project
Open the project in **Android Studio**.

### 3. Build and run
The should start on click `Run` in **Android Studio**. There is no API-Key needed for this app.

You can now explore the app on an emulator or physical device (API level 26+).

---
### Run unit tests
```bash
./gradlew testDebug
```

---

## 📜 License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

---

## 👨‍💻 About the Author

**Thomas Cirksena**  
📧 [thomas.cirksena@gmail.com](mailto:thomas.cirksena@gmail.com)  
🌐 [github.com/grumpyshoe](https://github.com/grumpyshoe)  
💼 [linkedin.com/in/thomas-cirksena](https://www.linkedin.com/in/thomas-cirksena)

---

> _“Code is like beer — it’s best when it’s clean and well-crafted.”_ 😉
  
