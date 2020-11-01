package org.kata.bowling

data class Frame(
    private val firstThrow: Int? = null,
    private val secondThrow: Int? = null
) {

    fun roll(pins: Int): Frame {
        return if (firstThrow == null) {
            Frame(firstThrow = pins)
        } else {
            Frame(firstThrow, secondThrow = pins)
        }
    }

    fun finished(): Boolean {
        return if (!strike()) {
            firstThrow != null && secondThrow != null
        } else {
            firstThrow != null
        }
    }

    fun strike(): Boolean {
        return firstThrow != null && firstThrow == 10
    }

    fun spare(): Boolean {
        return (firstThrow != null && secondThrow != null) && pins() == 10
    }

    fun pins(): Int = (firstThrow ?: 0) + (secondThrow ?: 0)

    fun firstRoll() = firstThrow ?: 0

}