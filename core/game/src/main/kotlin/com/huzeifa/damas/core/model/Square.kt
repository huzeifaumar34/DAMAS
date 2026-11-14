package com.huzeifa.damas.core.model

/**
 * Zero-based square coordinates on the 8x8 Brazilian draughts board.
 */
data class Square(
    val row: Int,
    val column: Int
) {
    init {
        require(row in 0..7) { "Row must be between 0 and 7." }
        require(column in 0..7) { "Column must be between 0 and 7." }
    }

    val isPlayable: Boolean
        get() = (row + column) % 2 == 1
}
