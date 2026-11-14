package com.huzeifa.damas.core.model

enum class PieceSide {
    LIGHT,
    DARK;

    fun opposite(): PieceSide = when (this) {
        LIGHT -> DARK
        DARK -> LIGHT
    }
}
