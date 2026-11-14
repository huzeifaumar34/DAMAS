package com.huzeifa.damas.core.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test

class GameModelsTest {
    @Test
    fun oppositeSideReturnsOtherPlayer() {
        assertEquals(PieceSide.DARK, PieceSide.LIGHT.opposite())
        assertEquals(PieceSide.LIGHT, PieceSide.DARK.opposite())
    }

    @Test
    fun playableSquaresFollowAlternatingPattern() {
        assertTrue(Square(0, 1).isPlayable)
        assertTrue(Square(7, 6).isPlayable)
        assertFalse(Square(0, 0).isPlayable)
        assertFalse(Square(3, 3).isPlayable)
    }

    @Test
    fun squareRejectsCoordinatesOutsideBoard() {
        assertThrows(IllegalArgumentException::class.java) { Square(8, 0) }
    }

    @Test
    fun sevenDifficultyLevelsAreOrdered() {
        assertEquals(7, AiDifficulty.entries.size)
        assertEquals((1..7).toList(), AiDifficulty.entries.map { it.level })
        assertEquals(AiDifficulty.IMPOSSIBLE, AiDifficulty.fromLevel(7))
    }

    @Test
    fun brazilianProfileEnablesCoreCaptureRules() {
        assertTrue(RuleOptions.BRAZILIAN.mandatoryCapture)
        assertTrue(RuleOptions.BRAZILIAN.majorityCapture)
        assertTrue(RuleOptions.BRAZILIAN.flyingKings)
        assertTrue(RuleOptions.BRAZILIAN.removeCapturedPiecesAfterSequence)
    }
}
