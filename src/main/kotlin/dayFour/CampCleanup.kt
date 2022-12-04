package dayFour

object CampCleanup {
    private val file = FileLoader.getFile("CampCleanupInput.txt")

    private fun getRanges(line: String): Pair<IntRange, IntRange> {
        val (first, second) = line.split(",")
        val (firstStart, firstEnd) = first.split("-").map { it.toInt() }
        val (secondStart, secondEnd) = second.split("-").map { it.toInt() }
        val firstRange = IntRange(firstStart, firstEnd)
        val secondRange = IntRange(secondStart, secondEnd)
        return Pair(firstRange, secondRange)
    }

    fun partOne() {
        var total = 0
        file.forEachLine { line ->
            val (firstRange, secondRange) = getRanges(line)
            val inFirstRange = firstRange.contains(secondRange.first) && firstRange.contains(secondRange.last)
            val inSecondRange = secondRange.contains(firstRange.first) && secondRange.contains(firstRange.last)
            if ( inFirstRange || inSecondRange ) {
                total++
            }
        }

        println(total)

    }

    fun partTwo() {
        var total = 0
        file.forEachLine { line ->
            val (firstRange, secondRange) = getRanges(line)
            val inFirstRange = firstRange.contains(secondRange.first) || firstRange.contains(secondRange.last)
            val inSecondRange = secondRange.contains(firstRange.first) || secondRange.contains(firstRange.last)
            if ( inFirstRange || inSecondRange ) {
                total++
            }
        }

        println(total)

    }

}