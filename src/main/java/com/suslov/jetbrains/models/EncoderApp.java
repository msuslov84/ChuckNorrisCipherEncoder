package com.suslov.jetbrains.models;

import com.suslov.jetbrains.exceptions.EncoderException;
import com.suslov.jetbrains.services.EncoderUtil;

import java.util.Scanner;

/**
 * @author Mikhail Suslov
 */
public class EncoderApp {
    private static final String INPUT_TO_ENCODE = "Input string:";
    private static final String OUTPUT_ENCODED = "Encoded string:";
    private static final String OPERATION_CHOICE = "Please input operation (encode/decode/exit):";
    private static final String CLOSE_APP = "Bye!";

    private final Scanner scanner;
    private boolean isEnd;

    public EncoderApp() {
        this(new Scanner(System.in));
    }

    public EncoderApp(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void launch() {
        do {
            System.out.println(OPERATION_CHOICE);

            String inputLine = scanner.nextLine();
            switch (inputLine) {
                case "encode":
                    convertIntoBinaryForm();
                    break;
                case "decode":
                    convertFromBinaryForm();
                    break;
                case "exit":
                    closeApplication();
                    break;
                default:
                    System.out.println("There is no '" + inputLine + "' operation");
            }
            System.out.println();
        } while (!isEnd);
    }

    protected void convertIntoBinaryForm() {
        try {
            System.out.println(INPUT_TO_ENCODE);
            System.out.println(EncoderUtil.convertIntoBinaryForm(scanner.nextLine()));
        } catch (EncoderException exp) {
            System.out.println(exp.getMessage());
        }
    }

    protected void convertFromBinaryForm() throws EncoderException {
        try {
            System.out.println(OUTPUT_ENCODED);
            System.out.println(EncoderUtil.convertFromBinaryForm(scanner.nextLine()));
        } catch (EncoderException exp) {
            System.out.println(exp.getMessage());
        }
    }

    protected void closeApplication() {
        scanner.close();
        isEnd = true;
        System.out.println(CLOSE_APP);
    }
}
