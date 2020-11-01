package org.kata.bowling

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GameTest {

    @Test
    fun `the score is the sum of the rolled pins`() {
        val game = Game()

        game.roll(4)
        game.roll(3)

        assertThat(game.score()).isEqualTo(7)
    }

    @Test
    fun `the score of a spare is the sum of the rolled pins plus the next roll as a bonus`() {
        val game = Game()

        game.roll(6)
        game.roll(4)

        game.roll(8)
        game.roll(1)

        assertThat(game.bonus).isEqualTo(8)
        assertThat(game.score()).isEqualTo(27)
    }

    @Test
    fun `the score of a strike is the sum of the rolled pins plus the next two rolls as a bonus`() {
        val game = Game()

        game.roll(10)

        game.roll(7)
        game.roll(1)

        assertThat(game.bonus).isEqualTo(8)
        assertThat(game.score()).isEqualTo(26)
    }

    @Test
    fun `10 frames of 9 and miss has score 90`() {
        val game = Game()

        for (x in 0..9) {
            game.roll(9)
            game.roll(0)
        }

        assertThat(game.score()).isEqualTo(90)
    }

}