package org.kata.bowling

class Game {

    private var pins = 0
    var bonus = 0
    private var lastRoll = 0
    private var spare = false

    fun roll(pins: Int) {
        if (spare) {
            bonus += pins
            spare = false
        }
        if (lastRoll + pins == 10) {
            spare = true
        }
        this.lastRoll = pins
        this.pins += pins
    }

    fun score(): Int {
        return pins + bonus
    }

}