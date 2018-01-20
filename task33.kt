package cryptoKotlin

fun main(vararg args: String) {
    println("Введите первое значение ")
    val number1 = readLine()!!.toInt()
    println("Введите второе значение ")
    val number2 = readLine()!!.toInt()
    val bin1 = IntArray(8)
    val bin2 = IntArray(8)
    for (i in 0..7) {
        bin1[7 - i] = (number1 shr i) % 2
        bin2[7 - i] = (number2 shr i) % 2
    }
    val mult = IntArray(64)
    for (i in 0..7) {
        for (j in 0..7) {
            mult[i * 8 + j] = bin1[i] * bin2[j]
        }
    }
    val res = IntArray(15)
    for (i in 0..7) {
        for (j in 0..7) {
            res[i + j] += mult[i * 8 + j]
            res[i + j] %= 2
        }
    }
    var builder = StringBuilder()
    for (i in 0..14) {
        builder.append(res[i].toString())
    }
    var toreduce = Integer.valueOf(builder.toString(), 2)

    if (toreduce > 255) {
        var length = 8
        while (toreduce shr length != 0) {
            length++
        }
        while (length != 8) {
            if (toreduce and (256 shl length - 9) > 0) {
                toreduce = toreduce xor (0x11b shl length - 9)
            }
            length--
        }
    }
    val afterReduce = IntArray(8)
    for (i in 0..7) {
        afterReduce[7 - i] = (toreduce shr i) % 2
    }
    builder = StringBuilder()
    for (i in 0..7) {
        if (afterReduce[i] != 0) {
            builder.append(" + x^").append((7 - i).toString())
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