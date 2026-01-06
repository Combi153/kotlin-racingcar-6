package racingcar.domain

data class Position(val value: Int) {
    init {
        require(value >= DEFAULT_POSITION) {
            "position $value must be greater than or equal to $DEFAULT_POSITION"
        }
    }

    fun move(): Position {
        return Position(this.value + UNIT)
    }

    companion object {
        const val UNIT = 1
        const val DEFAULT_POSITION = 0
    }
}
