package com.github.idrisaitmoulay.boxtool.toolwindow.screens

import com.github.idrisaitmoulay.boxtool.crypto.AbstractEncoding
import com.github.idrisaitmoulay.boxtool.crypto.URLEncoding

class URLEncodingView: AbstractEncodingView() {
    private var uRLEncoder = URLEncoding()
    override fun getEncoder(): AbstractEncoding {
        return uRLEncoder
    }
}