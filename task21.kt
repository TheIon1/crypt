package cryptoKotlin

fun main(vararg args: String) {
    println("Введите ограничение, меньше какого числа должны быть простые числа ")
    val m = readLine()!!.toInt()
    val sieve = arrayOfNulls<Boolean>(m + 1)
    for (i in 0..m) {
        sieve[i] = false
    }
    for (x in 1..Math.sqrt(m.toDouble()).toInt()) {
        for (y in 1..Math.sqrt(m.toDouble()).toInt()) {
            var n = 4 * x * x + y * y
            if (n <= m && (n % 12 == 1 || n % 12 == 5)) {
                sieve[n] = !sieve[n]!!
            }
            n = 3 * x * x + y * y
            if (n <= m && n % 12 == 7) {
                sieve[n] = !sieve[n]!!
            }
            n = 3 * x * x - y * y
            if (x > y && n <= m && n % 12 == 11) {
                sieve[n] = !sieve[n]!!
            }
        }
    }
    for (x in 5 until Math.sqrt(m.toDouble()).toInt()) {
        if (sieve[x]!!) {
            var y = x * x
            while (y <= m) {
                sieve[y] = false
                y += x * x
            }
        }
    }
    //В настоящее время принято не относить 1 к простым числам
    println(2)
    println(3)
    println(5)
    for (p in 6..m) {
        if (sieve[p]!! && p % 3 != 0 && p % 5 != 0) {
            println(p)
        }
    }
}