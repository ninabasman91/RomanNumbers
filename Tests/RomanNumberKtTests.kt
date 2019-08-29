import org.junit.Ignore
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RomanNumberKtTests {

    val roman:RomanNumber = RomanNumber()

    @Test
    fun isRomanNumber() {

        assertTrue(roman.isRomanNumber(string="I"))
        assertTrue(roman.isRomanNumber(string="IV"))
        assertTrue(roman.isRomanNumber(string="VI"))
        assertTrue(roman.isRomanNumber(string="XXV"))
        assertTrue(roman.isRomanNumber(string="LXVI"))
        assertTrue(roman.isRomanNumber(string="LXXXVI"))
        assertTrue(roman.isRomanNumber(string="LXIV"))
        assertTrue(roman.isRomanNumber(string="XLIII"))
        assertTrue(roman.isRomanNumber(string="XXXVIII"))
        assertTrue(roman.isRomanNumber(string="C"))


        assertFalse(roman.isRomanNumber(string=""))
        assertFalse(roman.isRomanNumber(string=null))
        assertFalse(roman.isRomanNumber(string="hello there"))
        assertFalse(roman.isRomanNumber(string="X1C"))
        assertFalse(roman.isRomanNumber(string="XC!"))
        assertFalse(roman.isRomanNumber(string="IIII"))
        assertFalse(roman.isRomanNumber(string=""))
        assertFalse(roman.isRomanNumber(string="IXIX"))
        assertFalse(roman.isRomanNumber(string="IXX"))
        assertFalse(roman.isRomanNumber(string="XCIXC"))
        assertFalse(roman.isRomanNumber(string="IIIV"))


    }

    @Test
    fun areAllRomanChars(){

        assertTrue(roman.areAllRomanChars(string="XXLCI"))
        assertTrue(roman.areAllRomanChars(string="IIIII"))
        assertTrue(roman.areAllRomanChars(string="VV"))
        assertTrue(roman.areAllRomanChars(string="C"))
        assertTrue(roman.areAllRomanChars(string="LIVXIVC"))

        assertFalse(roman.areAllRomanChars(string=""))
        assertFalse(roman.areAllRomanChars(string="aX"))
        assertFalse(roman.areAllRomanChars(string="XIV!"))
        assertFalse(roman.areAllRomanChars(string="123"))
        assertFalse(roman.areAllRomanChars(string="XX+II"))

    }


    @Test
    fun moreThanThreeInARow() {


        assertTrue(roman.moreThanThreeInARow(string="ABBBBC",c='B'))
        assertTrue(roman.moreThanThreeInARow(string="XXXIIII",c='I'))
        assertTrue(roman.moreThanThreeInARow(string="CCCC",c='C'))


        assertFalse(roman.moreThanThreeInARow(string="XIXI",c='X'))
        assertFalse(roman.moreThanThreeInARow(string="",c='X'))
        assertFalse(roman.moreThanThreeInARow(string="IIIC",c='I'))

    }



    @Test
    fun moreThanOnce() {

        assertTrue(roman.moreThanOnce(string="ABBC",c='B'))
        assertTrue(roman.moreThanOnce(string="abcda",c='a'))
        assertTrue(roman.moreThanOnce(string="XVVLL",c='V'))


        assertFalse(roman.moreThanOnce(string="XVVLL",c='X'))
        assertFalse(roman.moreThanOnce(string="",c='X'))
        assertFalse(roman.moreThanOnce(string="abc",c='a'))

    }


    @Test
    fun getCharCount() {

        assertEquals(1,roman.getCharCount(string="abcd",c='a'))
        assertEquals(3,roman.getCharCount(string="aaa",c='a'))
        assertEquals(1,roman.getCharCount(string="hello world",c=' '))
        assertEquals(0,roman.getCharCount(string="",c='a'))
        assertEquals(0,roman.getCharCount(string="ABC",c='a'))

    }



    @Test
    fun checkCorrectSequence(){


        assertTrue(roman.checkCorrectSequence(string="X"))
        assertTrue(roman.checkCorrectSequence(string="XI"))
        assertTrue(roman.checkCorrectSequence(string="XIV"))
        assertTrue(roman.checkCorrectSequence(string="XIV"))
        assertTrue(roman.checkCorrectSequence(string="XCIX"))
        assertTrue(roman.checkCorrectSequence(string="XXII"))
        assertTrue(roman.checkCorrectSequence(string="XXXIX"))

        assertFalse(roman.checkCorrectSequence(string="IXIX"))
        assertFalse(roman.checkCorrectSequence(string="XXXIIX"))
        assertFalse(roman.checkCorrectSequence(string="XXVC"))
        assertFalse(roman.checkCorrectSequence(string="LC"))
        assertFalse(roman.checkCorrectSequence(string="XXXC"))
        assertFalse(roman.checkCorrectSequence(string="XCX"))
        assertFalse(roman.checkCorrectSequence(string="IXX"))

    }


}