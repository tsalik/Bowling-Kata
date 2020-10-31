package org.kata.bowling

class Game {

    private var pins = 0
    var bonus = 0
    private var frame = Frame()

    fun roll(pins: Int) {
        if (frame.spare()) {
            bonus += pins
            frame.bonusGiven()
        }
        frame.roll(pins)
        this.pins += pins
    }

    fun score(): Int {
        return pins + bonus
    }

    inner class Frame {

        private var lastRoll = 0
        private var spare = false
        private var bonusGiven = false

        fun roll(pins: Int) {
            if (lastRoll + pins == 10) {
                spare = true
            }
            this.lastRoll = pins
        }

        fun spare() = spare && !bonusGiven

        fun bonusGiven() {
            this.bonusGiven = true
        }
    }
}