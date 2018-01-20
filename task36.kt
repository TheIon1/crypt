package cryptoKotlin

import java.math.BigInteger

fun main(vararg args: String) {
    println("Введите p, не меньше 126 бит, простое, q<p<2q ")
    val p = readLine()!!.toBigInteger()
    println("Введите q, не меньше 126 бит, простое, q<p<2q ")
    val q = readLine()!!.toBigInteger()
    val phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE))
    val n = p.multiply(q)
    val publicKey = "65537".toBigInteger()
    println("Пусть будет такой публичный ключ... " + publicKey)
    val privateKey = publicKey.modInverse(phi)
    println("Получили приватный ключ... " + privateKey)
    println("Введите сообщение для кодировки, числовое ")
    val message = readLine()!!.toBigInteger()
    val encrypt = message.modPow(publicKey, n)
    val decrypt = encrypt.modPow(privateKey, n)
    println("Получили зашифрованное сообщение... " + encrypt)
    println("А если дешифровать..." + decrypt)
}