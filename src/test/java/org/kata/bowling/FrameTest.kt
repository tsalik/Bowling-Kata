package org.kata.bowling

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FrameTest {

    @Test
    fun `a frame finished in two rolls unless it's a strike`() {
        val frame = Frame()

        frame.roll(2)
        frame.roll(3)

        assertThat(frame.finished()).isTrue()
    }
}