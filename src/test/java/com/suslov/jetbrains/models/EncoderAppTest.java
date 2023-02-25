package com.suslov.jetbrains.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * @author Mikhail Suslov
 */
public class EncoderAppTest {
    private EncoderApp encoderApp;

    @Before
    public void setUp() {
        encoderApp = new EncoderApp(new Scanner("encode"));
    }

    @Test
    public void launchIncorrectOperationAndExit() {
        encoderApp = new EncoderApp(new Scanner("test\nencode\nHello\nexit"));
        encoderApp.launch();
        Assert.assertTrue(encoderApp.isEnd());
    }

    @Test
    public void launchEncodeOperationAndExit() {
        encoderApp = new EncoderApp(new Scanner("encode\nHello\nexit"));
        encoderApp.launch();
        Assert.assertTrue(encoderApp.isEnd());
    }

    @Test
    public void launchEncodeOperationInvalidInputAndExit() {
        encoderApp = new EncoderApp(new Scanner("encode\n\nexit"));
        encoderApp.launch();
        Assert.assertTrue(encoderApp.isEnd());
    }

    @Test
    public void launchDecodeOperationAndExit() {
        encoderApp = new EncoderApp(new Scanner("decode\n0 000 00 0000\nexit"));
        encoderApp.launch();
        Assert.assertTrue(encoderApp.isEnd());
    }

    @Test
    public void launchDecodeOperationInvalidInputAndExit() {
        encoderApp = new EncoderApp(new Scanner("decode\n0 000 00 000\nexit"));
        encoderApp.launch();
        Assert.assertTrue(encoderApp.isEnd());
    }

    @Test
    public void launchExitOperation() {
        encoderApp = new EncoderApp(new Scanner("exit"));
        encoderApp.launch();
        Assert.assertTrue(encoderApp.isEnd());
    }
}