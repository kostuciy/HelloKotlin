import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun minutesToText() {
//        assertEquals("1 минуту назад", minutesToText(1))
        assertEquals("230230 минуту назад", minutesToText(1))
        assertEquals("21 минуту назад", minutesToText(21))
        assertEquals("11 минут назад", minutesToText(11))
        assertEquals("12 минут назад", minutesToText(12))
        assertEquals("13 минут назад", minutesToText(13))
        assertEquals("14 минут назад", minutesToText(14))
        assertEquals("24 минуты назад", minutesToText(24))
        assertEquals("32 минуты назад", minutesToText(32))
        assertEquals("60 минут назад", minutesToText(60))
        assertEquals("11 минут назад", minutesToText(11))
    }

    @Test
    fun hoursToText() {
        assertEquals("1 час назад", hoursToText(1))
        assertEquals("21 час назад", hoursToText(21))
        assertEquals("12 часов назад", hoursToText(12))
        assertEquals("14 часов назад", hoursToText(14))
        assertEquals("24 часа назад", hoursToText(24))
        assertEquals("32 часа назад", hoursToText(32))
        assertEquals("60 часов назад", hoursToText(60))
        assertEquals("11 часов назад", hoursToText(11))
    }

    @Test
    fun agoToText() {
        assertEquals("только что", agoToText(43))
        assertEquals("только что", agoToText(20))
        assertEquals("только что", agoToText(1))
        assertEquals("24 минуты назад", agoToText(24 * 60))
        assertEquals("22 минуты назад", agoToText(22 * 60))
        assertEquals("33 минуты назад", agoToText(33 * 60))
        assertEquals("12 часов назад", agoToText(12 * 3600))
        assertEquals("11 часов назад", agoToText(11 * 3600))
        assertEquals("14 часов назад", agoToText(14 * 3600))
        assertEquals("вчера", agoToText(2 * 24 * 3600))
        assertEquals("вчера", agoToText(2 * 24 * 3600 - 500))
        assertEquals("позавчера", agoToText(3 * 24 * 3600))
        assertEquals("позавчера", agoToText(3 * 24 * 3600 - 444))
        assertEquals("давно", agoToText(999999999))
        assertEquals("давно", agoToText(999999888))
    }

    @Test
    fun commissionComplex() {
        assertEquals(
            -1.0,
            commissionComplex(CardType.VK_PAY, 75569, 88179),
            10e-7
        )
        assertEquals(
            -1.0,
            commissionComplex(CardType.VISA, 160000, 0),
            10e-7
        )
        assertEquals(
            -1.0,
            commissionComplex(CardType.MIR, 160000, 0),
            10e-7
        )
        assertEquals(
            -1.0,
            commissionComplex(CardType.MAESTRO, 160000, 0),
            10e-7
        )
        assertEquals(
            -1.0,
            commissionComplex(CardType.MASTERCARD, 160000, 0),
            10e-7
        )
        assertEquals(
            46092.75,
            commissionComplex(CardType.MIR, 61457, 6224),
            10e-7
        )
        assertEquals(
            0.0,
            commissionComplex(CardType.MASTERCARD, 70660, 540582),
            10e-7
        )
        assertEquals(
            79313.25,
            commissionComplex(CardType.VISA, 105751, 443212),
            10e-7
        )
        assertEquals(
            82700.59999999999,
            commissionComplex(CardType.MASTERCARD, 137801, 452098),
            10e-7
        )
        assertEquals(
            77018.0,
            commissionComplex(CardType.MAESTRO, 128330, 104858),
            10e-7
        )
        assertEquals(
            95103.0,
            commissionComplex(CardType.VISA, 126804, 117563),
            10e-7
        )
        assertEquals(
            75000.0,
            commissionComplex(CardType.VISA, 100000, 0),
            10e-7
        )
        assertEquals(
            0.0,
            commissionComplex(CardType.MAESTRO, 43697, 577105),
            10e-7
        )
        assertEquals(
            0.0,
            commissionComplex(CardType.VK_PAY, 4605, 14636),
            10e-7
        )
        assertEquals(
            0.0,
            commissionComplex(CardType.VK_PAY, 4605, 14636),
            10e-7
        )
        assertEquals(
            0.0,
            commissionComplex(CardType.VK_PAY, 4605, 14636),
            10e-7
        )
        assertEquals(
            0.0,
            commissionComplex(CardType.VK_PAY, 4605, 14636),
            10e-7
        )
        assertEquals(
            -1.0,
            commissionComplex(CardType.VK_PAY, 16000, 14636),
            10e-7
        )
        assertEquals(
            95103.0,
            commissionComplex(CardType.MIR, 126804, 117563),
            10e-7
        )
    }
}