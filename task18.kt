package cryptoKotlin

import java.math.BigInteger

fun main(vararg args: String) {
    println("Введите целое число ")
    var a = readLine()!!.toBigInteger(2)

    println("Ввести перестановку без разделителей ")
    var permut = readLine()!!.toBigInteger()

    var out = BigInteger.ZERO

    for (i in 0 until a.bitLength()) {
        val index = permut.remainder(BigInteger.TEN)
        permut = permut.divide(BigInteger.TEN)
        if (a.testBit(index.toInt())) {
            out = out.setBit(i)
        }
    }

    println("Получаем биты переставленные в соответствии с перестановкой... " + out.toString(2))
}