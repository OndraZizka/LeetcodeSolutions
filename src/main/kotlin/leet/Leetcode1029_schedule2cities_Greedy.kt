package leet

class Leetcode1029_schedule2cities_Greedy {

    fun twoCitySchedCost(costs: Array<IntArray>): Int {

        val bonusForCityA = costs.map { it[1] - it[0] }.toIntArray()
        bonusForCityA.sort()

        return costs.asSequence().map { it[0] }.sum() +
            bonusForCityA.asSequence().take(bonusForCityA.size/2).sum()
    }

}
