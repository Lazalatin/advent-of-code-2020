package de.bitfroest.aoc2020

object Day02 {

    data class PasswordPolicy(var range: IntRange, var char: Char)

    fun solve(lines: List<String>): Int {
        val match = Regex("^(\\d+)-(\\d+) (\\w): (\\w+)$")
        return lines.mapNotNull {  match.find(it)?.destructured }
            .count { (rangeStart, rangeEnd, char, password) ->
                isValid(password, char, rangeStart.toInt()..rangeEnd.toInt())}
    }

    private fun isValid(password: String, char: String, range: IntRange): Boolean {
        return password.count { char.contains(it) } in range
    }

    fun solve2(lines: List<String>): Int {
        return lines.count()
    }

    private fun isValid2(password: String, char: String, firstChar: Int, secondChar: Int): Boolean {

        return
    }
}