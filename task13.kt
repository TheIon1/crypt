package cryptoKotlin

import java.math.BigInteger
import java.nio.charset.Charset

fun main(vararg args: String) {
    println("Введите число в двоичной системе ")
    var a = readLine()!!.toBigInteger(2)
    println("Введите через enter номера байтов для замены местами")
    val i = readLine()!!.toInt()
    val j = readLine()!!.toInt()
    if (a.bitLength() >= (i - 1 * 8) && a.bitLength() >= (j - 1 * 8)) {
        var tmp = a.toByteArray()
        tmp.set(i - 1, a.toByteArray()[j - 1])
        tmp.set(j - 1, a.toByteArray()[i - 1])
        println("Получим..." + BigInteger(tmp).toString(2))
    } else if (a.bitLength() < (i * 4) && a.bitLength() < (j * 4)) {
        println("Нет таких байтов")
    }
}