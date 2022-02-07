


fun parsePairs(s: String): Array<IntArray> {

    // E.g. [0,0],[2,2],[3,10],[5,2],[7,0]
    return s.removeSuffix("]")
        .splitToSequence("],[")
        .map { it.removePrefix("[") }
        .map { it.split(",").map { Integer.parseInt(it) }.toIntArray() }
        .toList()
        .toTypedArray()
}
