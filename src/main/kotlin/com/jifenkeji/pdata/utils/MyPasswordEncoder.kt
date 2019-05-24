package com.gloyray.mgr.utils

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.util.DigestUtils

class MyPasswordEncoder : PasswordEncoder {

    override fun encode(rawPassword: CharSequence): String {
        return DigestUtils.md5DigestAsHex(rawPassword.toString().toByteArray())
    }

    override fun matches(rawPassword: CharSequence, encodedPassword: String): Boolean {
        val rawPasswordTemp = DigestUtils.md5DigestAsHex(rawPassword.toString().toByteArray())
        return encodedPassword == rawPasswordTemp
    }

}