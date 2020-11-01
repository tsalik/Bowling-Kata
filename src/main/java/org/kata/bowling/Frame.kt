package org.kata.bowling

data class Frame(
    private val firstThrow: Int? = null,
    private val secondThrow: Int? = null
) {

    private var lastRoll = 0
    private var spare = false
    private var strike = false
    private var strikeBonusAdded = 0

    fun roll(pins: Int): Frame {
        if (pins == 10) {
            strike = true
        } else if (lastRoll + pins == 10) {
            spare = true
        }
        this.lastRoll = pins

        return if (firstThrow == null) {
            Frame(firstThrow = pins)
        } else {
            Frame(firstThrow, secondThrow = pins)
        }
    }

    fun bonus(pins: Int): Int {
        if (strike && strikeBonusAdded <= 2) {
            ++strikeBonusAdded
            resetStrike()
            return pins
        } else if (spare) {
            spare = false
            return pins
        }
        return 0
    }

    private fun resetStrike() {
        if (strikeBonusAdded == 2) {
            strike = false
            strikeBonusAdded = 0
        }
    }

    fun finished(): Boolean {
        return if (!strike()) {
            firstThrow != null && secondThrow != null
        } else {
            firstThrow != null
        }
    }

    private fun strike(): Boolean {
        return firstThrow != null && firstThrow == 10
    }

}