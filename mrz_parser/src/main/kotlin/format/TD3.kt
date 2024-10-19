package io.vladyslavv_ua.format

import io.vladyslavv_ua.model.MRZData

class TD3 : MRZFormat() {
    override fun validate(mrz: String): Boolean {
        return mrz.length == 88 && mrz.last().digitToIntOrNull() != null
    }

    override fun parse(mrz: String): MRZData {
        TODO("Not yet implemented")
    }
}