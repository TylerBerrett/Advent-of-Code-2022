package dayTwo

import kotlin.math.min

object RockPaperScissors {
    private val file = FileLoader.getFile("RockPaperScissorsInput.txt")

    private val mineToPoint = mapOf(
        "X" to 1,
        "Y" to 2,
        "Z" to 3
    )

    private val opponentToWinner = mapOf(
        "A" to "Y",
        "B" to "Z",
        "C" to "X"
    )

    private val opponentToDraw = mapOf(
        "A" to "X",
        "B" to "Y",
        "C" to "Z"
    )

    fun partOne() {

        var total = 0
        file.forEachLine { line ->
            val (opponent, mine) = line.split(" ")

            if (opponentToWinner[opponent] == mine) {
                total += 6
            }

            if (opponentToDraw[opponent] == mine) {
                total += 3
            }

            total += mineToPoint[mine]!!
        }

        println(total)
    }

    fun partTwo() {

        val opponentToLoose = mapOf(
            "A" to "Z",
            "B" to "X",
            "C" to "Y"
        )

        var total = 0
        file.forEachLine { line ->
            val (opponent, result) = line.split(" ")

            when(result) {
                "X" -> {
                    total += mineToPoint[opponentToLoose[opponent]]!!
                }
                "Y" -> {
                    total += mineToPoint[opponentToDraw[opponent]]!! + 3
                }
                "Z" -> {
                    total += mineToPoint[opponentToWinner[opponent]]!! + 6
                }
            }
        }
        println(total)
    }

}