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
        val match = Regex("^(\\d+)-(\\d+) (\\w): (\\w+)$")
        return lines.mapNotNull {  match.find(it)?.destructured }
            .count { (firstChar, secondChar, char, password) ->
                isValid2(password, char.first(), firstChar.toInt(), secondChar.toInt())}
    }

    private fun isValid2(password: String, char: Char, firstChar: Int, secondChar: Int): Boolean {
        if (password[firstChar - 1] != char) {
            if (password[secondChar - 1] != char) {
                return false
            }
        } else if(password[firstChar-1] == password[secondChar-1]) {
            return false
        }

        return true
    }
}