import java.util.*

class ValidParentheses {
    fun solution(s: String): Boolean {
        val parentheses = mapOf('[' to ']', '(' to ')', '{' to '}')
        val stack = Stack<Char>()

        s.forEach {
            if (stack.isNotEmpty() && it == parentheses[stack.last()])
                stack.pop()
            else {
                if (parentheses[it] == null)
                    return false
                stack.push(it)
            }
        }

        return stack.isEmpty()
    }
}