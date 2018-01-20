package cryptoKotlin

import java.math.BigInteger
import java.util.*

fun main(vararg args: String) {
    println("Введите g: ")
    val g = readLine()!!.toInt()
    println("Введите a: ")
    val a = readLine()!!.toInt()
    println("Введите m: ")
    val m = readLine()!!.toInt()
    println("Дискретный логарифм в кольцах вычетов получаем...")
    for (i in 1 until m) {
        if (Math.pow(g.toDouble(), i.toDouble()).toInt() % m == a) {
            println("x = " + i)
        }
    }
    val N = 1 + Math.sqrt(m.toDouble()).toInt()
    val littleSteps = HashMap<Int, Int>()
    var littleStep = 1
    for (i in 0..N) {
        littleSteps.put(littleStep, i)
        littleStep = littleStep * g % m
    }
    val bigJump = BigInteger.valueOf(g.toLong()).modPow(BigInteger.valueOf(((m - 2) * N).toLong()), BigInteger.valueOf(m.toLong())).toInt()
    var bigStep = a
    for (i in 0..N) {
        if (littleSteps.containsKey(bigStep)) {
            println("В полях Галуа получаем...")
            println("x = " + (i * N + littleSteps[bigStep]!!))
            return
        } else {
            bigStep = bigStep * bigJump % m
        }
    }
}