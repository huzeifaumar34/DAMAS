package com.huzeifa.damas.core.model

enum class PieceRank {
    MAN,
    KING
}

data class Piece(
    val side: PieceSide,
    val rank: PieceRank = PieceRank.MAN
)
