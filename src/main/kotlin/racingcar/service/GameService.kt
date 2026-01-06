package racingcar.service

import racingcar.domain.Car
import racingcar.domain.Game
import racingcar.domain.RandomNumberGenerator

class GameService {
    fun play(carNames: List<String>, count: Int): List<String> {
        val cars = carNames.map { it -> Car(it) }
        val game = Game(count)
        val numberGenerator = RandomNumberGenerator()
        for (i in 1..game.count) {
            for (car in cars) {
                if (numberGenerator.generate() >= 4) {
                    car.move()
                }
            }
            cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
        }

        return getWinners(cars)
    }

    private fun getWinners(cars: List<Car>): List<String> {
        var max = 0;
        for (car in cars) {
            if (car.position > max) {
                max = car.position
            }
        }

        return cars.filter { it.position == max }.map { it.name }
    }
}