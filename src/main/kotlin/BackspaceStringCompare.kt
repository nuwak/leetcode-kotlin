class BackspaceStringCompare {
    fun backspaceCompare(s: String, t: String): Boolean {
//        return getString(s) == getString(t)
        return getStringOpt(s) == getStringOpt(t)
    }

    fun backspaceCompareOpt(S: String, T: String): Boolean {
        var i: Int = S.length - 1
        var j: Int = T.length - 1
        var skipS = 0
        var skipT = 0

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S[i] == '#') {
                    skipS++
                    i--
                } else if (skipS > 0) {
                    skipS--
                    i--
                } else break
            }
            while (j >= 0) {
                if (T[j] == '#') {
                    skipT++
                    j--
                } else if (skipT > 0) {
                    skipT--
                    j--
                } else break
            }
            if (i >= 0 && j >= 0 && S[i] != T[j]) return false
            if (i >= 0 != j >= 0) return false
            i--
            j--
        }
        return true
    }

    fun getString(s: String): String {
        var bs = 0
        var res = ""
        s.toCharArray().reversed().forEach {
            if (it == '#')
                bs++
            else if (bs > 0)
                bs--
            else
                res += it
        }

        return res.reversed()
    }


    fun getStringOpt(s: String): String {
        var bs = 0
        val res = java.lang.StringBuilder()
        for (p in (s.length - 1) downTo 0) {
            if (s[p] == '#')
                bs++
            else if (bs > 0)
                bs--
            else
                res.append(s[p])
        }
        res.drop(1)
        return res.reversed().toString()
    }

}