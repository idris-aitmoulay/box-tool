package com.github.idrisaitmoulay.boxtool.crypto

import java.util.Base64

class Base64Encoding {

    public fun encode(originalString : String): String {
        return Base64.getEncoder().encodeToString(originalString.toByteArray())
    }


    public fun decode(encodedString: String): String {
        return String(Base64.getDecoder().decode(encodedString))
    }
}
