package com.awesome.kotlindemo.language.classes

import android.util.ArrayMap

/**
 *Created by Alice on 2021/5/16
 */
class Face {
    val FACE_MAP: ArrayMap<String, Bean> = ArrayMap<String, Bean>()

    class Bean {
        var key: String? = null

        constructor(key: String?) {
            this.key = key
        }
    }
}