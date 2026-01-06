package racingcar.controller

import racingcar.service.GameService

class GameController(private val gameService: GameService) {
    fun play(): Unit {
        val carNames = println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으록 구분)").run { readln().split(',') }
        val count = println("시도할 회수는 몇 회인가요?").run { readln() }.run { Integer.parseInt(this) }
        println("실행 결과")
        val winnerNames = gameService.play(carNames, count)
        print("최종 우승자 : ${winnerNames.joinToString(", ")}")
    }
}