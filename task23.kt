package cryptoKotlin

fun main(vararg args: String) {
    println("Введите число m для ф-ции Эйлера ")
    var m = readLine()!!.toInt()
    var result = m
    var i = 2
    while (i * i <= m) {
        if (m % i == 0) {
            while (m % i == 0) {
                m /= i
            }
            result -= result / i
        }
        i++
    }
    if (m > 1) {
        result -= result / m
    }
    println(result)
}