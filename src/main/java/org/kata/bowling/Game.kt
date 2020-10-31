package org.kata.bowling

class Game {

    private var pins = 0
    var bonus = 0
    private var frame = Frame()

    fun roll(pins: Int) {
        bonus += frame.bonus(pins)
        frame.roll(pins)
        this.pins += pins
    }

    fun score(): Int {
        return pins + bonus
    }

    inner class Frame {

        private var lastRoll = 0
        private var spare = false

        fun roll(pins: Int) {
            if (lastRoll + pins == 10) {
                spare = true
            }
            this.lastRoll = pins
        }

        fun bonus(pins: Int): Int {
            if (spare) {
                spare = false
                return pins
            }
            return 0
        }
    }
}