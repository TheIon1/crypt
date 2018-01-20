package cryptoKotlin

import java.util.*

fun main(vararg args: String) {
    println("Введите число m для системы вычетов ")
    val m = readLine()!!.toInt()
    val incomparable = LinkedList<Int>()
    for (i in 2 until m) {
        if (m % i == 0) {
            incomparable.add(i)
        }
    }
    for (i in 1 until m) {
        var flag = false
        for (d in incomparable) {
            if (i % d == 0) {
                flag = true
            }
        }
        if (!flag) {
            println(i)
        }
    }
}