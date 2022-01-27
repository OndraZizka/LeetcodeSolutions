

class Leet18 {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        var nums = nums.sortedDescending()
        nums = nums.filter { it <= target }

        //val freq: Map<Int, Int> = nums.groupingBy { it }.eachCount()

        val tree = java.util.TreeSet<Int>()
        tree.addAll(nums)

        val result = mutableListOf<List<Int>>()

        var remainingA = target
        for (a in tree) {
            val remainingB = remainingA - a;
            for (b in tree.headSet(remainingB+1)) {
                val remainingC = remainingB - b
                for (c in tree.headSet(remainingC)) {
                    val remainingD = remainingC - c
                    if (tree.contains(remainingD))
                        result.add( listOf(a, b, c, remainingD) )
                }
            }
        }

        return result
    }
}
