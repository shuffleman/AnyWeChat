package com.anywhere.wechat.uitis

object CalculateByte {
    fun getBytes(sdkVersion: Int, packageName: String): ByteArray? {
        val buffer = StringBuilder()
        buffer.append(sdkVersion)
        buffer.append(packageName)
        buffer.append("mMcShCsTr")

        val substring = buffer.toString().substring(1, 9)
        val md5Hash = CalculateString.getMD5(substring.toByteArray())

        return md5Hash?.toByteArray()
    }
}