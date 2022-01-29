import java.util.*

class Leet71 {

    enum class TokenType { SLASH, NAME }

    fun simplifyPath(path: String): String {
        val parts = Stack<String>()
        var curToken = mutableListOf<Char>()
        var lastTokenType = TokenType.SLASH

        for (c in path + "/") {
            when (c) {
                '/' -> {
                    when (lastTokenType) {
                        TokenType.SLASH -> {} // Ignore
                        TokenType.NAME -> {
                            val name = curToken.joinToString("")
                            if (name == "." ) {} // Ignore
                            else if (name == "..") {
                                if (parts.isNotEmpty())
                                    parts.pop()
                            }
                            else
                                parts.push(name)

                            curToken = mutableListOf()
                            lastTokenType = TokenType.SLASH
                        }
                    }
                }
                else -> {
                    curToken.add(c)
                    lastTokenType =  TokenType.NAME
                }
            }
        }
        return "/" + parts.joinToString("/")
    }

}

fun main() {
    val res = Leet71().simplifyPath("/a//b////c/d//././/..")
    println("$res")
}
