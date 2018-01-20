package cryptoKotlin

fun main(vararg args: String) {
    println("Введите элемент ")
    val number = readLine()!!.toInt()
    if (number in 0..256) {
        val bin = IntArray(8)
        for (i in 0..7) {
            bin[7 - i] = (number shr i) % 2
        }
        var builder = StringBuilder()
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
        builder = StringBuilder()
        for (i in 0..7) {
            builder.append(bin[i].toString())
        }
        val checkNumber = Integer.valueOf(builder.toString(), 2)
        println("В полиномиальной форме получаем... " + polynom
                + " и проверочный " + checkNumber)
    } else {
        println("Вы вышли за границы")
    }
}