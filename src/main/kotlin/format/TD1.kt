package io.vladyslavv_ua.format

import io.vladyslavv_ua.model.MRZData
import io.vladyslavv_ua.model.MrzSex
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class TD1 : MRZFormat() {


    override fun validate(mrz: String): Boolean {
        return mrz.length == 90
    }

    override fun parse(mrz: String): MRZData {
        val (firstRow, secondRow, thirdRow) = mrz.chunked(30)
        val id = firstRow.slice(0..1).removeArrow()
        val country = firstRow.slice(2..4)
        val documentNumber = firstRow.slice(5..13)
        val optionalData1 = firstRow.slice(14..<30).removeArrow()
        val birthDate = LocalDate.parse(secondRow.slice(0..<6), DateTimeFormatter.ofPattern("yyMMdd"))
        val sex = MrzSex.fromMrz(secondRow[7])
        val expiryDate = LocalDate.parse(secondRow.slice(8..<14), DateTimeFormatter.ofPattern("yyMMdd"))
        val nationality = secondRow.slice(15..17)
        val optionalData2 = secondRow.slice(18..<29).removeArrow()
        val (surname, names) = thirdRow.split("<<")
        return MRZData(
            id, country, documentNumber, optionalData1, birthDate,
            sex, expiryDate, nationality, optionalData2, surname.replace("<", " "), names.split("<")
        )
    }
}