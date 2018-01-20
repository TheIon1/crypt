package cryptoKotlin

import java.math.BigInteger

fun main(vararg args: String) {
    println("Введите число в двоичной системе ")
    val a = readLine()!!.toBigInteger(2)
    val len = a.bitLength()
    //a
    print("Введите сколько первых битов со сколькими последними битами склеить(одно число) ")
    val i = readLine()!!.toInt()
    val tmp = BigInteger.ZERO
    //берём остаток от деления
    val left = a.remainder(tmp.setBit(i))
    val right = a.shiftRight(len - i).shiftLeft(i)
    println("В результате склейки получим..." + left.or(right).toString(2))
    //b
    val between = a.remainder(tmp.flipBit(len - i))
    println("Между первыми и последними i битами получилось...")
    //т.к. лидирующие нули удалятся, получившееся число может быть только меньше, нужно дописать 0
    if (between.shiftRight(i).bitLength() != len - (i * 2)) {
        for (j in 1..len - (i * 2) - between.shiftRight(i).bitLength()) {
            print("0")
        }
    }
    print(between.shiftRight(i).toString(2))
}