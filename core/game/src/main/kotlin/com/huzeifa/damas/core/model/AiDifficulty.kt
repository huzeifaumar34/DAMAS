package com.huzeifa.damas.core.model

enum class AiDifficulty(
    val level: Int,
    val displayName: String
) {
    NOVICE(1, "Novato"),
    APPRENTICE(2, "Aprendiz"),
    AMATEUR(3, "Amador"),
    STRATEGIST(4, "Estrategista"),
    SPECIALIST(5, "Especialista"),
    MASTER(6, "Mestre"),
    IMPOSSIBLE(7, "Impossível");

    companion object {
        fun fromLevel(level: Int): AiDifficulty =
            entries.firstOrNull { it.level == level }
                ?: throw IllegalArgumentException("Unknown AI difficulty level: $level")
    }
}
