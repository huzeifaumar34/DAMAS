# Contribuir para o DAMAS

## Requisitos

- JDK 17.
- Android SDK Platform 36.
- Android NDK 27.0.12077973.
- CMake 3.22.1.
- Gradle 8.13.
- Android Studio compatível com AGP 8.13.2.

## Convenções

- Kotlin: classes em PascalCase e funções em camelCase.
- C++: C++17, warnings ativados e JNI limitado à camada de integração.
- Regras: cada regra nova deve ter testes unitários para casos válidos e inválidos.
- UI: o estado do jogo permanece fora do motor de regras; a UI apenas apresenta o estado.
- Dependências: fixar versões no catálogo gradle/libs.versions.toml.

## Verificações antes de integrar

Executar os testes do módulo de domínio e compilar as variantes Android. O workflow Android CI executa essas verificações automaticamente.
