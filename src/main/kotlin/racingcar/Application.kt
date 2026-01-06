package racingcar

import racingcar.controller.GameController
import racingcar.service.GameService

fun main() {
    // TODO: 프로그램 구현
    GameController(GameService()).play()
}
