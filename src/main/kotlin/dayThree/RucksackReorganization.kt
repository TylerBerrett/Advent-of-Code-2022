package dayThree

object RucksackReorganization {
    private val file = FileLoader.getFile("RucksackReorganizationInput.txt")

    private val letterToPoint = mutableMapOf<Char, Int>()

    init {
        "abcdefghijklmnopqrstuvwxyz".forEachIndexed { i, letter ->
            val lPoint = i + 1
            val uPoint = i + 27
            letterToPoint[letter] = lPoint
            letterToPoint[letter.uppercaseChar()] = uPoint
        }
    }

    fun partOne() {

        var total = 0
        file.forEachLine { line ->
            val length = line.length - 1

            val firstHalf = line.substring(0..length / 2).toSet()
            val secondHalf = line.substring((length / 2) + 1..length).toSet()

            secondHalf.forEach { letter ->
                if (firstHalf.contains(letter)) {
                   total += letterToPoint[letter]!!
                }
            }
        }

        println(total)

    }

    fun partTwo() {
        var total = 0
        val currentGroup = ArrayList<Set<Char>>()
        var count = 0
        file.forEachLine { line ->
            count++
            currentGroup.add(line.toSet())
            if (count % 3 == 0) {
                val rucksacks = currentGroup.joinToString(separator = "") { it.joinToString(separator = "") }
                val letterToCount = mutableMapOf<Char, Int>()
                rucksacks.forEach { item ->
                    letterToCount[item] = (letterToCount[item] ?: 0) + 1
                }
                letterToCount.forEach { (letter, count) ->
                    if (count == 3) {
                        total += letterToPoint[letter]!!
                    }
                }
                currentGroup.clear()
            }
        }
        println(total)
    }

}