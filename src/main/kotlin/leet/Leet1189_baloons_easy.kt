package leet

public class Leet1189_baloons_easy
{
    fun maxNumberOfBalloons(text: String): Int {
    var b = 0
    var a = 0
    var l = 0
    var o = 0
    var n = 0

    for (c in text) {
        when (c) {
            'b' -> b+=2
            'a' -> a+=2
            'l' -> l++
            'o' -> o++
            'n' -> n+=2
        }
    }
    //println("" + listOf(b,a,l,o,n))
    return Math.min(Math.min(Math.min(Math.min(b,a),l),o),n) / 2
}
}
