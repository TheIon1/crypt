package cryptoKotlin

fun main(vararg args: String) {
    println("Введите число в двоичной системе ")
    val a = readLine()!!.toBigInteger(2)
    //a,b
    println("Введите номер бита для вывода: ")
    val k = readLine()!!.toInt()
    if (a.testBit(k)) {
        println("Выбран установленый бит = 1. Снимаем его. Получим..." + a.flipBit(k).toString(2))
    } else {
        println("Выбран бит = 0, установим ему значение 1. Получим..." + a.flipBit(k).toString(2))
    }
    //c
    println("Введите через enter номера битов для замены местами")
    //Если сплитать, то неудобно потом привести к Int
    val i = readLine()!!.toInt()
    val j = readLine()!!.toInt()
    if (a.testBit(i) && a.testBit(j)) {
        println("Введены одинаковые i и j. Поменяв местами получили..." + a.toString(2))
    } else if (!a.testBit(i) && !a.testBit(j)) {
        println("Введены несуществующие i и j.")
    } else if (a.testBit(i)) {
        println("Поменяв местами получили..." + a.flipBit(i).setBit(j).toString(2))
    } else {
        println("Поменяв местами получили..." + a.setBit(i).flipBit(j).toString(2))
    }
    //d
    println("Введите сколько младших бит вы хотите обнулить")
    val m = readLine()!!.toInt()
    println("Обнулив m младших битов получили..." + a.shiftRight(m).shiftLeft(m).toString(2))
}