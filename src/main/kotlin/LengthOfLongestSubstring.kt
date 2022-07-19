/**
 * @see https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
 */
class LengthOfLongestSubstring {
    fun solution(s: String): Int {
        val chars = mutableSetOf<Char>()
        var counter = 1
        var maxLength = 0
        var p = 0

        while (p < s.length) {
            val ch = s[p]
            if (ch in chars) {
                counter = 1
                chars.clear()
                chars.add(ch)
                var bp = p - 1
                while (bp >= 0) {
                    if(s[bp] in chars){
                        p = bp + 1
                        chars.clear()
                        break
                    }
                    bp--
                }
                continue
            } else {
                chars.add(ch)
                if (counter > maxLength)
                    maxLength = counter
                counter++
            }

            p++
        }

        return maxLength
    }


    fun solution2(s: String): Int {
        var lp = 0
        var rp = s.length - 1
        var ldp = 0
        var lPrevChar: Char? = null
        var rPrevChar: Char? = null
        var rdp = rp
        var size = rp

        while (lp < rp) {
            while (lp < rp) {
                lp++
                if (s[lp] == lPrevChar) {
                    ldp = lp
                    break
                }
            }

            while (lp < rp) {
                rp--
                if (s[rp] == rPrevChar) {
                    rdp = rp
                    break
                }
            }

        }

        TODO()
    }
}