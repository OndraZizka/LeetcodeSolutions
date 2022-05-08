package leet

class Leetcode920_playlists {

    fun numMusicPlaylists(N: Int, L: Int, K: Int): Int {

        val mod = 1000000007.toLong()
        val dp = Array(L + 1) { LongArray(N + 1) }

        dp[0][0] = 1
        for (i in 1..L)
            for (j in 1..N) {
                dp[i][j] += dp[i - 1][j - 1] * (N - j + 1)
                dp[i][j] += dp[i - 1][j] * Math.max(j - K, 0)
                dp[i][j] %= mod
            }

        return dp[L][N].toInt()
    }
}
