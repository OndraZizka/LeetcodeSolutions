class Leet15_3Sum {


    data class Triplet(val items: List<Int>)

    fun threeSum(nums: IntArray): List<List<Int>> {
        val resSet = mutableSetOf<Triplet>()
        val freq = nums.asList().groupingBy { it }.eachCount()

        fun findCouplesThatSumToTarget(target: Int): List<IntArray> {

            println("Targetting $target...")
            val res = mutableListOf<IntArray>()

            @Suppress("NAME_SHADOWING")
            val freq = HashMap<Int, Int>(freq)
            freq.compute(-target) { key, count -> count?.minus(1) ?: 0 }

            for (entry in freq) {
                val b = entry.key
                val complement = target - b
                var complCount = freq.get(complement) ?: 0
                if (b == complement) complCount--

                println("   Considering: [${b.toString().padStart(2)} (${entry.value}x), ${complement} (${complCount}x)]  ($target - $b)")
                if (entry.value != 0 && complCount > 0)
                    res.add(intArrayOf(b, complement))
            }
            println("    For $target --> added ${res.map { it.joinToString("+") }  }")
            return res
        }

        for (a in nums) {
            // Must find b + c = -a
            val pairs: List<IntArray> = findCouplesThatSumToTarget(-a)

            resSet.addAll(pairs.map { Triplet(listOf(a, it[0], it[1]).sorted()) })
        }

        val res2 = mutableListOf<List<Int>>()
        res2.addAll(resSet.map { it.items } )

        return resSet.asSequence().map { it -> it.items }.toList()
    }

}

fun main() {
    val res = Leet15_3Sum().threeSum(intArrayOf(-1,0,1,2,-1,-4))
    println("$res")
}
