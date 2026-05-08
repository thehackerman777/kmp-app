# 👾 KMP App — Kotlin Multiplatform

[![Build](https://github.com/thehackerman777/kmp-app/actions/workflows/build-release.yml/badge.svg)](https://github.com/thehackerman777/kmp-app/actions)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-purple.svg)](https://kotlinlang.org)
[![Compose](https://img.shields.io/badge/Compose_Multiplatform-1.7.1-green.svg)](https://www.jetbrains.com/lp/compose-multiplatform/)
[![Ktor](https://img.shields.io/badge/Ktor-2.3.12-orange.svg)](https://ktor.io)
[![GitHub Pages](https://img.shields.io/badge/Web-GitHub_Pages-blue.svg)](https://thehackerman777.github.io/kmp-app)

---

**KMP App** es un proyecto full-stack construido con **Kotlin Multiplatform**, que demuestra una arquitectura moderna compartiendo lógica de negocio entre múltiples plataformas desde un solo código base.

```
┌─────────────────────────────────────────────────┐
│                Shared KMP Module                 │
│   Modelos · API Client · Lógica de negocio      │
└──────┬──────────────────────┬───────────────────┘
       │                      │
┌──────▼──────┐      ┌───────▼───────────┐
│   Android   │      │   Backend (Ktor)  │
│  Jetpack    │      │   API REST        │
│  Compose    │      │   Puerto 8080     │
└─────────────┘      └───────┬───────────┘
                             │
                      ┌──────▼───────┐
                      │   Web App    │
                      │  React+Vite  │
                      │  TypeScript  │
                      └──────────────┘
```

---

## 📱 Plataformas

| Plataforma | Tecnología | Estado |
|-----------|------------|--------|
| **Android** | Jetpack Compose + Material 3 | ✅ |
| **Desktop (Linux/Windows/Mac)** | Compose Multiplatform | ✅ |
| **Web** | React + Vite + TypeScript | ✅ |
| **Backend** | Ktor Server (Netty) | ✅ |

## 🧱 Stack Tecnológico

| Capa | Tecnología | Versión |
|------|-----------|---------|
| **Lenguaje** | Kotlin + TypeScript | 2.0.21 / 5.x |
| **UI Android** | Jetpack Compose + Material 3 | — |
| **UI Desktop** | Compose Multiplatform | 1.7.1 |
| **Web UI** | React + Vite | 19.x / 6.x |
| **Backend** | Ktor (Netty) | 2.3.12 |
| **HTTP Client** | Ktor Client (OkHttp / CIO) | 2.3.12 |
| **Serialización** | kotlinx.serialization | 1.7.3 |
| **Corrutinas** | kotlinx.coroutines | 1.8.1 |
| **Build** | Gradle + AGP | 8.9 / 8.5.2 |

## 🚀 Cómo Empezar

### Prerrequisitos

- **Java JDK 21+**
- **Android SDK** (para build Android)
- **Node.js 22+** (para web app)

### Clonar y Ejecutar

```bash
git clone https://github.com/thehackerman777/kmp-app.git
cd kmp-app

# Android
./gradlew :androidApp:assembleDebug

# Desktop
./gradlew :desktopApp:run

# Backend
./gradlew :backend:run

# Web
cd webApp
npm install
npm run dev
```

### 📱 Probar APK

Descarga el APK desde los **Actions** del repositorio o desde un **Release**:

1. Ve a [Actions → Build APK](https://github.com/thehackerman777/kmp-app/actions)
2. Selecciona el último workflow exitoso
3. Descarga el artefacto `android-app-debug`
4. Instala en tu dispositivo Android (permite orígenes desconocidos)

## 🏗️ Estructura del Proyecto

```
kmp-app/
├── shared/                    # Módulo KMP compartido
│   └── src/
│       ├── commonMain/        # Código común (modelos, lógica)
│       ├── androidMain/       # Implementaciones Android
│       └── jvmMain/           # Implementaciones JVM/Desktop
├── androidApp/                # App Android (Jetpack Compose)
│   └── src/main/
│       ├── kotlin/            # Código Kotlin
│       └── AndroidManifest.xml
├── desktopApp/                # App Desktop (Compose Multiplatform)
│   └── src/main/kotlin/       # Código Kotlin
├── backend/                   # Backend API (Ktor)
│   └── src/main/kotlin/       # Código Kotlin
├── webApp/                    # Frontend Web (React + Vite)
│   └── src/
│       ├── App.tsx            # Componente principal
│       ├── main.tsx           # Entry point
│       └── style.css          # Estilos
├── gradle/                    # Configuración Gradle
│   ├── libs.versions.toml     # Catálogo de versiones
│   └── wrapper/
└── .github/workflows/         # CI/CD (GitHub Actions)
```

## 🔄 CI/CD

Cada **push a main** dispara automáticamente:

1. ✅ Build de Android APK (debug + release)
2. ✅ Build de Desktop App (Linux)
3. ✅ Build de Backend JAR
4. ✅ Build de Web App
5. 🌐 Deploy a **GitHub Pages**
6. 📦 Publicación en **Release** (cuando se crea un tag)

### Releases

Para crear un release:

```bash
git tag v1.0.0
git push origin v1.0.0
```

Esto generará automáticamente:
- `android-app-debug.apk`
- `android-app-release.apk` (sin firmar)
- `desktop-app-linux.zip`
- `backend.jar`
- Web app desplegada en GitHub Pages

## 📡 API Endpoints

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/` | Health check |
| GET | `/api/greeting` | Saludo desde backend |
| GET | `/api/hello/{name}` | Saludo personalizado |

## 🛠️ Desarrollo en VPS

El proyecto se desarrolla y compila en una **VPS dedicada** (AWS t3.large):

```
IP: 18.213.174.229
SO: Ubuntu 24.04 LTS
CPU: 2 vCPU (t3.large)
RAM: 8 GB
Disco: 50 GB encriptado
```

Acceso SSH:
```bash
ssh -i ~/.ssh/openclaw-admin.pem ubuntu@18.213.174.229
```

## 📄 Licencia

**MIT** — Haz lo que quieras con este código, pero se agradece mencionar la fuente.

---

<p align="center">
  Hecho con ❤️ usando <a href="https://kotlinlang.org">Kotlin</a> y <a href="https://openclaw.ai">OpenClaw</a> 👾
</p>
