package com.github.idrisaitmoulay.boxtool.toolwindow.screens

import com.github.idrisaitmoulay.boxtool.crypto.AbstractEncoding
import com.github.idrisaitmoulay.boxtool.crypto.Base64Encoding


class Base64EncodingView: AbstractEncodingView() {
    private var base64Encoder = Base64Encoding()

    override fun getEncoder(): AbstractEncoding {
        return base64Encoder;
    }
}