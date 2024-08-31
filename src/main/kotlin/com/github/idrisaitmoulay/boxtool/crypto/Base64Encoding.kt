package com.github.idrisaitmoulay.boxtool.crypto

import java.util.Base64

class Base64Encoding: AbstractEncoding {

    public override fun encode(originalString : String): String {
        return Base64.getEncoder().encodeToString(originalString.toByteArray())
    }


    public override fun decode(encodedString: String): String {
        return String(Base64.getDecoder().decode(encodedString))
    }
}
