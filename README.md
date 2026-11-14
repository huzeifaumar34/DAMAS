# DAMAS

Jogo de damas para Android, focado nas regras brasileiras, partidas offline, dois jogadores locais e uma IA com sete níveis de dificuldade.

**Estado:** Fase 1 — fundação Android, motor nativo inicial e automação de compilação.

## Funcionalidades do produto

- Partidas contra IA (7 níveis) e modo local para dois jogadores.
- Regras brasileiras oficiais e variantes personalizáveis.
- Dicas, análise pós-partida, histórico, conquistas e treinamento.
- Temas de tabuleiro, peças, sons e animações personalizáveis.
- Experiência offline.

## Stack técnica

- Kotlin, Jetpack Compose e Material 3.
- C++17 para o motor nativo de jogo e pesquisa da IA.
- Android NDK, CMake e JNI.
- Room e Preferences DataStore para dados locais.
- GitHub Actions para testes e geração dos APKs.

## Arquiteturas Android

- armeabi-v7a — ARM de 32 bits.
- arm64-v8a — ARM de 64 bits.

O Gradle está fixado em 8.13 no workflow e o Android Gradle Plugin em 8.13.2. O CI instala JDK 17 e o Android SDK/NDK necessários.

## Compilar e obter APKs

1. Abre a aba Actions do repositório.
2. Seleciona Android CI.
3. Executa Run workflow ou aguarda a compilação após um push.
4. Abre a execução concluída e descarrega o artefacto damas-debug-apks.

O artefacto inclui os APKs separados por arquitetura e o APK universal. São builds de depuração (debug), adequados para testes.

Para compilar localmente, abre o projeto no Android Studio com JDK 17 e Gradle 8.13 instalados.

## Estrutura principal

- app/ — aplicação Android e interface Compose.
- app/src/main/cpp/ — biblioteca nativa C++ e JNI.
- core/game/ — modelos e configuração do domínio.
- docs/ — arquitetura e critérios de conclusão das fases.
- .github/workflows/ — pipeline de CI e APKs.

A Fase 1 entrega a fundação executável e a automação. O motor completo de regras brasileiras, a pesquisa da IA e as funcionalidades de partida serão desenvolvidos nas fases seguintes.
