package com.anywhere.wechat.uitis

import java.security.MessageDigest

object CalculateString {
    fun getMD5(input: ByteArray): String? {
        val hexChars = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')

        return try {
            val digest = MessageDigest.getInstance("MD5")
            digest.update(input)
            val hashBytes = digest.digest()

            val hexArray = CharArray(hashBytes.size * 2)
            var index = 0

            for (byte in hashBytes) {
                hexArray[index++] = hexChars[(byte.toInt() ushr 4) and 15]
                hexArray[index++] = hexChars[byte.toInt() and 15]
            }

            String(hexArray)
        } catch (e: Exception) {
            null
        }
    }
}