package cryptoKotlin

fun mult(number1: Int, number2: Int): Int {
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

    val builder = StringBuilder()
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

    return toreduce
}

fun main(vararg args: String) {
    println("Введите значение ")
    val number = readLine()!!.toInt()

    var polynom = convert(number)
    println("В полиномиальной форме получаем... " + polynom)

    var res = number

    for (i in 0..252) {
        res = mult(number, res)
    }

    polynom = convert(res)

    println("В обратной полиномиальной форме получаем... " + polynom)
}
