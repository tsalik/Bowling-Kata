package org.kata.bowling

class Game {

    private var pins = 0

    fun roll(pins: Int) {
        this.pins += pins
    }

    fun score(): Int {
        return pins
    }

}