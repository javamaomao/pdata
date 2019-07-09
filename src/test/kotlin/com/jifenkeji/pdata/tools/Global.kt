package com.jifenkeji.pdata.tools

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException
import com.baomidou.mybatisplus.core.toolkit.StringUtils
import java.security.MessageDigest
import java.util.*

// 转换为16进制字符串格式
fun List<Byte>.toHex() : String {
    return this.fold("",{acc,x->"$acc${x.toInt().and(0xff).toString(16).padStart(2, '0')}"})
}
fun ByteArray.toHex() : String {
    return this.fold("",{acc,x->"$acc${x.toInt().and(0xff).toString(16).padStart(2, '0')}"})
}
val String.md5: String
    get() {
        //确定计算方法
        val md5 = MessageDigest.getInstance("MD5")
        val info = md5.digest(this.toByteArray())
        return info.toHex()
    }


/**
 *
 *
 * 读取控制台内容
 *
 */
fun scanner(tip: String): String {
    val scanner = Scanner(System.`in`)
    val help = StringBuilder()
    help.append("请输入$tip：")
    println(help.toString())
    if (scanner.hasNext()) {
        val ipt = scanner.next()
        if (StringUtils.isNotEmpty(ipt)) {
            return ipt
        }
    }
    throw MybatisPlusException("请输入正确的$tip！") as Throwable
}