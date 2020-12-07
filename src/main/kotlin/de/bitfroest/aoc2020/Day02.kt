package de.bitfroest.aoc2020

object Day02 {

    data class PasswordPolicy(var range: IntRange, var char: Char)

    fun solve(lines: List<String>): Int {
        return lines.map {
            val match = Regex("(\\d)-(\\d) (\\w): (\\w+)").find(it)
            if (match != null) {
                val (rangeStart, rangeEnd, char, password) = match.destructured

                isValid(password, char, rangeStart.toInt()..rangeEnd.toInt())
            } else false
        }.filter { isValid -> isValid }.size
    }

    private fun isValid(password: String, char: String, range: IntRange): Boolean {
        return password.count { char.contains(it) } in range
    }

    fun solve2(lines: List<String>): Int {
        return lines.count()
    }

}