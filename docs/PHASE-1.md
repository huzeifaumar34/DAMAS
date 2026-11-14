# Fase 1 — Fundação Android

## Entregas

- Projeto Gradle multi-módulo com app e core:game.
- Aplicação Android mínima com Kotlin e Jetpack Compose.
- Tema visual inicial escuro, dourado e verde.
- Ecrã inicial e pré-visualização estática do tabuleiro 8×8.
- Biblioteca C++17 compilada por CMake/NDK.
- Ponte JNI de diagnóstico entre Kotlin e C++.
- ABI filters para armeabi-v7a e arm64-v8a.
- Geração de APK por ABI e APK universal.
- Modelos de domínio iniciais e testes unitários.
- GitHub Actions para build, testes e publicação de APKs como artefactos.

## Critérios de aceitação

1. O Gradle configura os módulos sem erros.
2. Os testes de core:game passam.
3. O Android Gradle Plugin compila o app e a biblioteca C++.
4. Os APKs debug são gerados para armeabi-v7a, arm64-v8a e universal.
5. A aplicação inicia e reporta a versão do motor nativo.
6. O workflow fica disponível em Actions e pode ser iniciado manualmente.

## Fora do escopo desta fase

- Regras completas e geração de movimentos.
- Partidas funcionais e captura.
- IA Minimax e os sete perfis de força.
- Histórico real, conquistas e persistência ligada à UI.

Estas funções serão desenvolvidas nas fases seguintes e não serão apresentadas como concluídas nesta fase.
