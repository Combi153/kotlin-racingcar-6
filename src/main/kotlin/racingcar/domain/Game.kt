package racingcar.domain

class Game(val count: Int) {
    init {
        require(count > 0) { "count must be > 0" }
    }
}