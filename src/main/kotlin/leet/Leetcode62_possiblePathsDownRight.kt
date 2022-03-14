package leet

import java.math.BigDecimal
import java.math.BigInteger

class Leetcode62_possiblePathsDownRight {
    fun uniquePaths(m: Int, n: Int): Int {
        val a = m -1
        val b = n-1

        val up = fact(a + b)
        val fA = fact(a)
        val fB = fact(b)
        //val down = fact(a) * fact(b)
        println("$up / $fA / $fB")

        return ( up /  fA / fB ).toInt()
    }
}


fun fact(num: Int): BigInteger {
    var factorial = 1.toBigInteger()
    for (i in num downTo 2) {
        factorial = factorial.multiply(i.toBigInteger())
    }
    return factorial
}
