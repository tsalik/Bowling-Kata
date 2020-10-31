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

}