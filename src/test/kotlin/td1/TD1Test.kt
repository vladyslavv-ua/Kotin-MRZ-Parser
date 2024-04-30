package td1

import io.vladyslavv_ua.MRZParser
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TD1Test {
    private lateinit var mrzParser: MRZParser
    @BeforeTest
    fun initialize() {

    }

    @Test
    fun `dfdf sdf`() {
        val mrzParser = MRZParser(
            "IDUKR22558863512345678951254<<1105027M2607296UKR<<<<<<<<<<<1IMLE<ABOBA<<QMOLURM<QWERTY<<dd",

            )
        assertEquals("ID", mrzParser.doc)
    }

}