package cryptoKotlin

import java.math.BigInteger

fun main(vararg args: String) {
    println("Введите целое число ")
    var a = readLine()!!.toBigInteger()
    println("Введите количество бит для сдвига влево и вправо ")
    var n = readLine()!!.toInt()
    var right = BigInteger.ZERO
    for (i in 0 until a.bitLength()) {
        if (a.testBit(i)) {
            right = right.setBit((i - n % a.bitLength() + a.bitLength()) % a.bitLength())
        }
    }
    println("Циклически сдвигая вправо получим... " + right.toString())

    var left = BigInteger.ZERO
    for (i in 0 until a.bitLength()) {
        if (a.testBit(i)) {
            left = left.setBit((i + n % a.bitLength()) % a.bitLength())
        }
    }
    println("Циклически сдвигая влево получим..."  + left.toString())
}