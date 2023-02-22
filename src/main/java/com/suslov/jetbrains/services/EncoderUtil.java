package com.suslov.jetbrains.services;

import com.suslov.jetbrains.exceptions.EncoderException;

/**
 * @author Mikhail Suslov
 */
public class EncoderUtil {
    private static final String NOT_VALID_ENCODED_STRING = "Encoded string is not valid.";

    private EncoderUtil() {
    }

    public static String convertIntoBinaryForm(String line) throws EncoderException {
        char[] symbols = line.toCharArray();

        StringBuilder str = new StringBuilder();
        char prevChar = ' ';
        for (char symbol : symbols) {
            try {
                String binaryStr = String.format("%07d", Integer.parseInt(Integer.toBinaryString(symbol)));

                char[] binary = binaryStr.toCharArray();
                for (char c : binary) {
                    if (c == '0' && prevChar != '0') {
                        str.append(" 00 0");
                        prevChar = '0';
                    } else if (c == '1' && prevChar != '1') {
                        str.append(" 0 0");
                        prevChar = '1';
                    } else {
                        str.append('0');
                    }
                }
            } catch (NumberFormatException exp) {
                throw new EncoderException(NOT_VALID_ENCODED_STRING, exp);
            }
        }
        return str.toString().trim();
    }

    public static String convertFromBinaryForm(String line) throws EncoderException {
        StringBuilder str = new StringBuilder();

        String[] binaryElements = line.trim().split(" ");
        if (binaryElements.length % 2 != 0) {
            throw new EncoderException(NOT_VALID_ENCODED_STRING);
        }

        for (int i = 0; i < binaryElements.length - 1; i += 2) {
            if (binaryElements[i].equals("0")) {
                str.append("1".repeat(binaryElements[i + 1].length()));
            } else if (binaryElements[i].equals("00")) {
                str.append(binaryElements[i + 1]);
            } else {
                throw new EncoderException(NOT_VALID_ENCODED_STRING);
            }
        }

        if (str.length() % 7 != 0) {
            throw new EncoderException(NOT_VALID_ENCODED_STRING);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i += 7) {
            try {
                result.append((char) Integer.parseInt(str.substring(i, i + 7), 2));
            } catch (NumberFormatException exp) {
                throw new EncoderException(NOT_VALID_ENCODED_STRING, exp);
            }
        }

        return result.toString();
    }
}
