package racingcar.service

import racingcar.domain.Car
import racingcar.domain.Game
import racingcar.domain.RandomNumberGenerator

class GameService {
    fun play(carNames: List<String>, count: Int): List<String> {
        val cars = carNames.map { it -> Car.of(it) }.toMutableList()
        val game = Game(count)
        val numberGenerator = RandomNumberGenerator()
        for (i in 1..game.count) {
            for (car in cars) {
                if (numberGenerator.generate() >= 4) {
                    cars[cars.indexOf(car)] = car.move()
                }
            }
            cars.forEach { println("${it.name.value} : ${"-".repeat(it.position.value)}") }
            println()
        }

        return getWinners(cars)
    }

    private fun getWinners(cars: List<Car>): List<String> {
        var max = 0;
        for (car in cars) {
            if (car.position.value > max) {
                max = car.position.value
            }
        }

        return cars.filter { it.position.value == max }.map { it.name.value }
    }
}
