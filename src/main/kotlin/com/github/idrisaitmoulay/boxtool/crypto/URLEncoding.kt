package com.github.idrisaitmoulay.boxtool.crypto

class URLEncoding: AbstractEncoding {

    public override fun encode(originalString : String): String {
        return originalString;
    }


    public override fun decode(encodedString: String): String {
        return encodedString
    }
}
