package racingcar.domain

class Car private constructor(val name: CarName, val position: Position) {

    fun move(): Car {
        return Car(name, position.move())
    }

    companion object {
        fun of(name: String, position: Int = 0): Car {
            return Car(CarName(name), Position(position))
        }
    }
}