/**
 * @see https://leetcode.com/problems/valid-palindrome/
 */
class ValidPalindrome {
    fun solution(s: String): Boolean
    {
        val clear = clearString(s)
        if (clear.length <= 1) return true
        var left = 0
        var right = clear.length - 1

        while (left <= right) {
            if (clear[left] == clear[right]) {
                left ++
                right --
            } else
                return false
        }
        return true
    }

    private fun clearString(s: String): String = s.toLowerCase().filter { it in 'a'..'z' || it in '0' .. '9' }
}