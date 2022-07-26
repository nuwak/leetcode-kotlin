import kotlin.math.absoluteValue

/**
 * @see https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
 */
class LengthOfLongestSubstring {
    fun solution(s: String): Int {
        val chars = mutableSetOf<Char>()
        var maxLength = 0
        var p = 0

        while (p < s.length) {
            val ch = s[p]
            if (ch in chars) {
                chars.clear()
                chars.add(ch)
                var bp = p - 1
                while (bp >= 0) {
                    if (s[bp] in chars) {
                        p = bp + 1
                        chars.clear()
                        break
                    }
                    bp--
                }
                continue
            } else {
                chars.add(ch)
                if (maxLength < chars.size)
                    maxLength = chars.size
            }

            p++
        }

        return maxLength
    }

    fun solution3(s: String): Int {
        if (s.length < 2) return s.length
        var (start, shift, max) = arrayOf(0, 2, 1)

        while (s.length >= start + shift)
            if (shift == s.substring(start, start + shift).toSet().size) {
                max = shift
                shift++
            } else
                start++

        return max
    }

    fun solution4(s: String): Int {
        if (s.length <= 1) return s.length

        val seen = mutableMapOf<Char, Int>()
        var left = 0
        var longest = 0

        for ((right, char) in s.withIndex()) {
            val prevSeenChar = seen[char]
            if (prevSeenChar != null && prevSeenChar >= left)
                left = prevSeenChar + 1

            seen[char] = right
            longest = maxOf(longest, right - left + 1)
        }

        return longest
    }
}