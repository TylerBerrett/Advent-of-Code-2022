package dayOne

object CalorieCounting {
    private val file = FileLoader.getFile("CalorieCountingInput.txt")

    fun partOne() {
        var currentSum = 0
        var max = 0

        file.forEachLine { line ->
            if (line.isNotEmpty()) {
                currentSum += line.toInt()
            } else {
                if (currentSum > max) {
                    max = currentSum
                }
                currentSum = 0
            }
        }
        println(max)
    }

    fun partTwo() {

        var currentSum = 0

        val totals = ArrayList<Int>()

        file.forEachLine { line ->
            if (line.isEmpty()) {
                totals.add(currentSum)
                currentSum = 0
            } else {
                currentSum += line.toInt()
            }

        }

        totals.sortDescending()

        println(totals[0] + totals[1] + totals[2])
    }

}