package io.vladyslavv_ua.model

import java.time.LocalDate

data class MRZData(
    val doc: String,
    val country: String,
    val docNumber: String,
    val optionalData1: String,
    val birthDate: LocalDate,
    val sex: MrzSex = MrzSex.Male,
    val expiryDate: LocalDate,
    val nationality: String,
    val optionalData2: String,
    val surname: String,
    val givenNames: List<String>
)
