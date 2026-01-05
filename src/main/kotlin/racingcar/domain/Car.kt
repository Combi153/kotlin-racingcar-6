package racingcar.domain

class Car(val name: String, var position: Int = 0) {
    init {
        require(name.length > 5) { "Name must be at least 5 characters" }
    }

    fun move() {
        position += 1
    }
}