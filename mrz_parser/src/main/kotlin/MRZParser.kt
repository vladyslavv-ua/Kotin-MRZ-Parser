package io.vladyslavv_ua

import io.vladyslavv_ua.format.MRZFormat
import io.vladyslavv_ua.format.TD1
import io.vladyslavv_ua.model.MRZData
import io.vladyslavv_ua.model.MrzSex
import java.time.LocalDate
import kotlin.properties.Delegates

class MRZParser(var mrz: String, var format: MRZFormat? = null) {
    private var mrzData: MRZData? by Delegates.observable(null) { _, _, newValue ->
        if (newValue != null) {
            doc = newValue.doc
            country = newValue.country
            docNumber = newValue.docNumber
            optionalData1 = newValue.optionalData1
            birthDate = newValue.birthDate
            sex = newValue.sex
            expiryDate = newValue.expiryDate
            nationality = newValue.nationality
            optionalData2 = newValue.optionalData2
            surname = newValue.surname
            givenNames = newValue.givenNames
        }
    }

    var doc: String = ""
        private set
    var country: String = ""
        private set
    var docNumber: String = ""
        private set
    var optionalData1: String = ""
        private set
    var birthDate: LocalDate = LocalDate.now()
        private set
    var sex: MrzSex = MrzSex.Male
        private set
    var expiryDate: LocalDate = LocalDate.now()
        private set
    var nationality: String = ""
        private set
    var optionalData2: String = ""
        private set
    var surname: String = ""
        private set
    var givenNames: List<String> = emptyList()
        private set


    private val formats = listOf<MRZFormat>(TD1())

    init {
        mrz = prepare(mrz)
        if (format == null) {
            format = detectType(mrz)
        }
        if (format!!.validate(mrz)) {
            this.mrzData = format!!.parse(mrz)
        }
    }


    private fun detectType(mrz: String): MRZFormat {
        return formats.first {
            it.validate(mrz)
        }
    }


    companion object {
        fun prepare(mrz: String): String {
            var newMrz = mrz.replace("«", "<<")
            newMrz = newMrz.replace(" ", "")
            newMrz = newMrz.replace("\n", "")
            return newMrz
        }

        fun parse(mrz: String, format: MRZFormat): MRZData {
            val preparedMrz = this.prepare(mrz)
            if (format.validate(preparedMrz)) {
                return format.parse(preparedMrz)
            }
            throw IllegalArgumentException()
        }
    }

}

