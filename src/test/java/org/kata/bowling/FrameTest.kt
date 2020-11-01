package org.kata.bowling

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FrameTest {

    private val frame = Frame()

    @Test
    fun `a frame finishes in two rolls`() {
        val twoRollsFrame = frame.roll(2).roll(3)

        assertThat(twoRollsFrame.finished()).isTrue()
    }

    @Test
    fun `a spare finishes in two rolls`() {
        val spareFrame = frame.roll(4).roll(6)

        assertThat(spareFrame.finished()).isTrue()
    }

    @Test
    fun `a strike finished in one roll`() {
        val strike = frame.roll(10)

        assertThat(strike.finished()).isTrue()
    }

}