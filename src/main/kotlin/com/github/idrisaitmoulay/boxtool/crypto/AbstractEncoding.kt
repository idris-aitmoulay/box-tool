package com.github.idrisaitmoulay.boxtool.crypto

interface AbstractEncoding {
    public fun encode(originalString : String): String
    public fun decode(encodedString: String): String
}