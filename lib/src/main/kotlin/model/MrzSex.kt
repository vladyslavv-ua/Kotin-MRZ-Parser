package io.vladyslavv_ua.model

enum class MrzSex {
    Male,
    Female,
    Unknown;

    companion object {
        fun fromMrz(c: Char): MrzSex = when (c) {
            'M' -> Male
            'F' -> Female
            else -> Unknown
        }
    }
}