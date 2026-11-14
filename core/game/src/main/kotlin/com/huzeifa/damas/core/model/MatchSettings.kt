package com.huzeifa.damas.core.model

data class MatchSettings(
    val mode: GameMode,
    val humanSide: PieceSide = PieceSide.LIGHT,
    val aiDifficulty: AiDifficulty = AiDifficulty.AMATEUR,
    val rules: RuleOptions = RuleOptions.BRAZILIAN
)
