package com.huzeifa.damas.core.model

/**
 * Configurable rule switches.
 * BRAZILIAN is the official default profile; the rules engine will enforce
 * the complete majority-capture rule in the gameplay phase.
 */
data class RuleOptions(
    val mandatoryCapture: Boolean = true,
    val majorityCapture: Boolean = true,
    val menCaptureBackward: Boolean = true,
    val flyingKings: Boolean = true,
    val removeCapturedPiecesAfterSequence: Boolean = true
) {
    companion object {
        val BRAZILIAN = RuleOptions()
    }
}
