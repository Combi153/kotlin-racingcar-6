package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class CarTest : BehaviorSpec({
    given("a car name") {
        `when`("is greater than 5") {
            val carName = "a".repeat(6)

            then("throws an exception") {
                shouldThrowExactly<IllegalArgumentException> {
                    Car(carName)
                }.shouldHaveMessage("Name must be at most 5 characters")
            }
        }

        `when`("is less than or equal 5") {
            val carName = "a".repeat(5)

            then("not throws an exception") {
                shouldNotThrow<IllegalArgumentException> { Car(carName) }
            }
        }
    }

    given("a car") {
        val position = 0
        val car = Car("car", position)

        `when`("moves") {
            car.move()

            then("position of the car goes up") {
                car.position shouldBe 1
            }
        }
    }
})