package cryptoKotlin

fun main(vararg args: String) {
    println("Введите целое число ")
    var a = readLine()!!.toBigInteger()
    var sub = a.testBit(0)
    for (i in 1 until a.bitLength()) {
        sub = sub xor a.testBit(i)
    }
    if (sub) {
        println("После ксора " + a.toString() + " -> 1")
    } else {
        println("После ксора " + a.toString() + " -> 0")
    }
}