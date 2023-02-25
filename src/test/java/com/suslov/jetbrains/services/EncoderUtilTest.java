package com.suslov.jetbrains.services;

import com.suslov.jetbrains.exceptions.EncoderException;
import com.suslov.jetbrains.models.EncoderApp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mikhail Suslov
 */
public class EncoderUtilTest {
    private String stringToEncode;
    private String encodedString;

    @Before
    public void setUp() {
        stringToEncode = "Hey!";
        encodedString = "0 0 00 00 0 0 00 000 0 00 00 00 0 0 00 0 0 00000 00 00 0 0 00 0 0 0 00 0000 0 0";
    }

    @Test
    public void convertIntoBinaryFormAnyWord() {
        Assert.assertEquals(encodedString, EncoderUtil.convertIntoBinaryForm(stringToEncode));
    }

    @Test(expected = EncoderException.class)
    public void convertIntoBinaryFormEmptyString() {
        EncoderUtil.convertIntoBinaryForm("");
    }

    @Test
    public void convertFromBinaryFormCorrectEncodedString() {
        Assert.assertEquals(stringToEncode, EncoderUtil.convertFromBinaryForm(encodedString));
    }

    @Test(expected = EncoderException.class)
    public void convertFromBinaryFormEmptyString() {
        EncoderUtil.convertFromBinaryForm("");
    }

    @Test(expected = EncoderException.class)
    public void convertFromBinaryFormOddSequence() {
        EncoderUtil.convertFromBinaryForm("0 00 0");
    }

    @Test(expected = EncoderException.class)
    public void convertFromBinaryFormIncorrectEvenSequence() {
        EncoderUtil.convertFromBinaryForm("0 00 00 000 1 0000");
    }

    @Test(expected = EncoderException.class)
    public void convertFromBinaryFormIncorrectLengthString() {
        EncoderUtil.convertFromBinaryForm("0 00 00 000 0 0000");
    }
}