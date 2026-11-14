# DAMAS

Jogo de damas para Android, com foco nas regras brasileiras, partidas offline, dois jogadores locais e uma IA com sete níveis de dificuldade.

> **Estado do projeto:** Fase 1 — fundação Android e automação de build.

## Funcionalidades planeadas

- Partidas contra IA (7 níveis) e modo local para dois jogadores.
- Regras brasileiras oficiais e variantes personalizáveis.
- Dicas, análise pós-partida, histórico, conquistas e treinamento.
- Temas de tabuleiro e peças personalizáveis.
- Experiência offline.

## Tecnologia

- Kotlin, Jetpack Compose e Material 3.
- C++17 para o motor de regras e pesquisa da IA.
- Android NDK, CMake e JNI.
- Room e DataStore para persistência local.
- GitHub Actions para testes e geração dos APKs.

## Arquiteturas Android

- `armeabi-v7a` (32 bits)
- `arm64-v8a` (64 bits)

## Compilar

O workflow **Android CI** compila e testa o projeto em cada push/PR. Também pode ser executado manualmente em **Actions → Android CI → Run workflow**.

Os APKs serão publicados como artefatos de workflow, separados por arquitetura e em versão universal.

Para compilar localmente, com Android SDK, NDK e JDK 17 instalados:

```bash
./gradlew testDebugUnitTest assembleDebug
```

## Estrutura

- `app/`: aplicação Android.
- `core/`: modelo e regras de domínio.
- `engine/`: motor C++ nativo.
- `docs/`: decisões técnicas e plano do projeto.
- `.github/workflows/`: automação CI/CD.

## Estado

A Fase 1 estabelece uma aplicação executável mínima e o pipeline de compilação. O motor completo de damas e a IA serão implementados nas fases seguintes.
