class Leet15_3Sum {


    data class Triplet(val items: List<Int>)

    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableSetOf<Triplet>()

        fun findCouplesThatSumToTarget(target: Int): List<IntArray> {

            println("Targetting $target...")
            val res = mutableListOf<IntArray>()
            var targetSkippedOnce = false
            var sameSkippedOnce = false
            val filtered = nums
                .filter {
                    // Skip duplicate numbers
                    if (-target == it && !targetSkippedOnce ) {
                        targetSkippedOnce = true; false
                    }
                    else if (it == target - it && !sameSkippedOnce) {
                        sameSkippedOnce = true; false
                    }
                    //    Adding: [ 2, -4]  (-2 - 2)  --- to tam byt nema
                    else true
                }
            val complements = filtered.map { target - it }.toSet()

            for (b in nums) {
                //if (b == -target) continue
                //if (target - b == -target) continue
                if (complements.contains(b)) {
                    println("   Adding: [${b.toString().padStart(2)}, ${target-b}]  ($target - $b)")
                    res.add(intArrayOf(b, target - b))
                }
            }
            return res
        }

        for (a in nums) {
            // Must find b + c = -a
            val pairs: List<IntArray> = findCouplesThatSumToTarget(-a)
            res.addAll(pairs.map { Triplet(listOf(a, it[0], it[1])) })
        }

        val res2 = mutableListOf<List<Int>>()
        res2.addAll(res.map { it.items } )

        return res.asSequence().map { it -> it.items }.toList()
    }

}

fun main() {
    val res = Leet15_3Sum().threeSum(intArrayOf(-1,0,1,2,-1,-4))
    println("$res")
}
