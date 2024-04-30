package io.vladyslavv_ua.format

import io.vladyslavv_ua.model.MRZData

abstract class MRZFormat {
    abstract fun validate(mrz: String): Boolean
    abstract fun parse(mrz: String): MRZData

    protected fun String.removeArrow(): String {
        return this.replace("<", "")
    }
}