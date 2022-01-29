class Leet7 {

    fun reverse(x: Int): Int {
        val abs = x.toString().reversed().removeSuffix("-")

        try {
            if (x <= 0) return -abs.toInt()
            else return abs.toInt()
        }
        catch (e: java.lang.NumberFormatException) {
            return 0
        }
    }

}
