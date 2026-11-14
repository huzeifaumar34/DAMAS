# Arquitetura do DAMAS

## Princípios

1. Offline-first: partidas, preferências e estatísticas funcionam sem conta ou internet.
2. Separação de responsabilidades: interface, domínio, persistência e motor nativo têm contratos explícitos.
3. Regras determinísticas: o motor de regras é a autoridade sobre movimentos legais e fim de partida.
4. IA isolada: a pesquisa recebe uma posição e devolve uma jogada; não altera diretamente o estado apresentado pela UI.
5. Testabilidade: regras e modelos de domínio devem ser testáveis sem Android.

## Módulos

### app

Aplicação Android, navegação, Jetpack Compose, temas, integração JNI e armazenamento Room/DataStore.

### core:game

Modelos Kotlin puros, configurações de partida, opções de regras e contratos do domínio. Não depende de Android.

### Motor C++ (app/src/main/cpp)

Biblioteca nativa C++17 compilada por CMake e Android NDK. A integração ocorre exclusivamente através de JNI. A primeira entrega contém uma função de identificação para validar carregamento e empacotamento nativo.

## Pesquisa da IA

A implementação planeada inclui Minimax, Alpha-Beta pruning, iterative deepening, ordenação de movimentos, tabela de transposição, hashing Zobrist e avaliação posicional. A profundidade e o tempo por nível serão calibrados por benchmarks nos dispositivos de referência.

O nível 7 representa a maior força prática estável no dispositivo, não uma promessa de invencibilidade matemática.

## Regras

O perfil padrão será Damas Brasileiras em tabuleiro 8×8. O modo personalizado terá opções explícitas. O motor deverá rejeitar configurações incompatíveis e as regras oficiais não serão alteradas silenciosamente.

## Persistência local

- Room: partidas, movimentos, estatísticas e progresso/conquistas.
- Preferences DataStore: tema, sons, animações e preferências.
- Nenhuma função essencial dependerá de serviços remotos.

## Configuração Android

- Namespace/applicationId: com.huzeifa.damas
- minSdk: 24
- compileSdk/targetSdk: 36
- JDK: 17
- Android Gradle Plugin: 8.13.2
- Gradle CI: 8.13
- Kotlin: 2.3.21
- NDK: 27.0.12077973
- CMake: 3.22.1
- ABIs: armeabi-v7a e arm64-v8a

As versões fixam uma combinação conservadora entre AGP 8.13, Gradle 8.13 e Kotlin 2.3. A atualização deve ser feita em conjunto e validada no CI.
