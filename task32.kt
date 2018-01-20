package cryptoKotlin

fun main(vararg args: String) {
    println("Введите первое значение ")
    val number1 = readLine()!!.toInt()
    println("Введите второе значение ")
    val number2 = readLine()!!.toInt()
    val bin1 = IntArray(32)
    val bin2 = IntArray(32)
    for (i in 0..31) {
        bin1[31 - i] = (number1 shr i) % 2
        bin2[31 - i] = (number2 shr i) % 2
    }
    val mult = IntArray(1024)
    for (i in 0..31) {
        for (j in 0..31) {
            mult[i * 32 + j] = bin1[i] * bin2[j]
        }
    }
    val res = IntArray(63)
    for (i in 0..31) {
        for (j in 0..31) {
            res[i + j] += mult[i * 32 + j]
            res[i + j] %= 2
        }
    }
    val builder = StringBuilder()
    for (i in 0..62) {
        if (res[i] != 0) {
            builder.append(" + x^").append((62 - i).toString())
        }
    }
    var polynom = builder.toString()
    if (number1 != 0 && number2 != 0) {
        polynom = polynom.substring(3, polynom.length)
    } else {
        polynom = "0"
    }
    println("Результатом умножения получается..." + polynom)
}
