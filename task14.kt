package cryptoKotlin

fun main(vararg args: String) {
    println("Введите целое число ")
    var a = readLine()!!.toBigInteger()
    val j = a.bitLength()
    if (j != 0) {
        println("Максимальная степень двойки..." + (j - 1).toString())
    } else {
        println("Вы ввели 0")
    }
}