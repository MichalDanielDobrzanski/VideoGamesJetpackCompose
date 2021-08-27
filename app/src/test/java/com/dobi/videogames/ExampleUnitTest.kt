package com.dobi.videogames

import kotlin.math.max
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun main() {
        // This problem was asked by Amazon.
        // Given an integer k and a string s,
        // find the length of the longest substring
        // that contains at most k distinct characters.
        var input = "abcba"
        println("BruteForce t: O(n^2), s: O(1): ${solveBruteForce(input)}")
        println("Linear t: O(n), s: O(n): ${solveLinear(input)}")
        input = "aaaacba"
        println("BruteForce t: O(n^2), s: O(1): ${solveBruteForce(input)}")
        println("Linear t: O(n), s: O(n): ${solveLinear(input)}")
        input = "aacbaxd"
        println("BruteForce t: O(n^2), s: O(1): ${solveBruteForce(input)}")
        println("Linear t: O(n), s: O(n): ${solveLinear(input)}")
    }

    fun solveBruteForce(input: String): Int {
        if (input.length < 2) {
            return input.length
        }
        var longest = 0

        for (i in input.indices) {
            val seen: MutableSet<Char> = HashSet()
            for (j in i until input.length) {
                if (seen.contains(input[j])) {
                    break
                } else {
                    seen.add(input[j])
                }
            }
            longest = max(longest, seen.size)
        }
        return longest
    }

    fun solveLinear(input: String): Int {
        if (input.length < 2) {
            return input.length
        }

        val seenAt: MutableMap<Char, Int> = HashMap()
        var longest = 0
        var i = 0
        var l = 0
        while (i < input.length) {
            if (seenAt.containsKey(input[i])) {
                l = max(l, seenAt[input[i]]!! + 1)
            }
            longest = max(longest, i - l + 1)
            seenAt[input[i]] = i
            i++
        }

        return longest
    }
}