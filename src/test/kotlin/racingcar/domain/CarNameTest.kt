package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.throwable.shouldHaveMessage

class CarNameTest : FunSpec({
    test("자동차 이름이 5자 초과이면 예외를 던진다") {
        // given
        val carName = "a".repeat(6)

        // when & then
        shouldThrowExactly<IllegalArgumentException> {
            CarName(carName)
        }.shouldHaveMessage("Name must be at most 5 characters")
    }

    test("자동차 이름이 5자 미만이면 예외를 던진다") {
        // given
        val carName = "a".repeat(5)

        // when & then
        shouldNotThrow<IllegalArgumentException> {
            CarName(carName)
        }
    }
})