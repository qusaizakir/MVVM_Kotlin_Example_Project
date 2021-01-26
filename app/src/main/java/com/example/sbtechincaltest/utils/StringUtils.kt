package com.example.sbtechincaltest.utils

import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders

//API needs user-agent
fun String.toGlideUrlWithAgent(): GlideUrl {
    return GlideUrl(
        this, LazyHeaders.Builder()
            .addHeader("User-Agent", "your-user-agent")
            .build()
    )
}