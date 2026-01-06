package racingcar.domain

data class CarName(val value: String) {
    init {
        require(value.length <= MAX_LENGTH) {
            "Name must be at most $MAX_LENGTH characters"
        }
    }

    companion object {
        const val MAX_LENGTH = 5
    }
}
