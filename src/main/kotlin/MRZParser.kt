package io.vladyslavv_ua

class MRZParser(var MRZ: String) {
    var format = ""

    init {
        MRZ = MRZ.replace("«", "<<")
        MRZ = MRZ.replace(" ", "")
    }

    constructor(MRZ: String, format: String) : this(MRZ) {
        this.format = format
    }


}

