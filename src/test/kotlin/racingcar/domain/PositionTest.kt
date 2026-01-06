package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class PositionTest : FunSpec({

    test("위치가 0 미만인 경우 예외를 던진다") {
        // given
        val value = -1

        // when & then
        shouldThrowExactly<IllegalArgumentException> {
            Position(value)
        }.shouldHaveMessage("position $value must be greater than or equal to 0")
    }

    test("위치가 0 이상인 경우 정상 생성된다") {
        // given
        val value = 0

        // when
        val position = Position(value)

        // then
        position.value shouldBe 0
    }

    test("위치를 이동하면 1만큼 값이 커진다") {
        // given
        val position = Position(0)

        // when
        val movedPosition = position.move()

        // then
        movedPosition.value shouldBe 1
    }
})