package org.kata.bowling

class Game {

    val frames = mutableListOf<Frame>()

    fun roll(pins: Int) {
        if (frames.isEmpty() || frames.last().finished()) {
            frames.add(Frame())
        }
        val lastFrame = frames.last()
        frames[frames.lastIndexOf(lastFrame)] = lastFrame.roll(pins)
    }

    fun score(): Int {
        return frames.mapIndexed { index, frame ->
            val pins = frame.pins()
            val hasNext = frames.size > index + 1
            val bonus = if (frame.strike() && hasNext && index < 9) {
                val nextFrame = frames[index + 1]
                if (!nextFrame.strike()) {
                    nextFrame.pins()
                } else {
                    nextFrame.pins() + frames[index + 2].firstRoll()
                }
            } else if (frame.spare() && hasNext && index < 9) {
                val nextFrame = frames[index + 1]
                nextFrame.firstRoll()
            } else {
                0
            }
            pins + bonus
        }.reduce { acc, next -> acc + next }

    }

}