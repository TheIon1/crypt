package cryptoKotlin

internal fun gcd(p: Int, q: Int): IntArray {
    if (q == 0)
        return intArrayOf(p, 1, 0)
    val vals = gcd(q, p % q)
    val d = vals[0]
    val a = vals[2]
    val b = vals[1] - p / q * vals[2]
    return intArrayOf(d, a, b)
}

internal fun convert(number: Int): String {
    val bin = IntArray(8)
    for (i in 0..7) {
        bin[7 - i] = (number shr i) % 2
    }

    val builder = StringBuilder()
    for (i in 0..7) {
        if (bin[i] != 0) {
            builder.append(" + x^").append((7 - i).toString())
        }
    }
    var polynom = builder.toString()
    if (number != 0) {
        polynom = polynom.substring(3, polynom.length)
    } else {
        polynom = "0"
    }
    return polynom
}

fun main(vararg args: String) {
    println("Введите первое значение ")
    val number1 = readLine()!!.toInt()
    println("Введите второе значение ")
    val number2 = readLine()!!.toInt()

    val res = gcd(number1, number2)

    println("Первый полином " + convert(number1))
    println("Второй полином " + convert(number2))
    println("НОД для них " + convert(res[0]))
}