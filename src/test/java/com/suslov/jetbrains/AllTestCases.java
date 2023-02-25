package com.suslov.jetbrains;

import com.suslov.jetbrains.models.EncoderAppTest;
import com.suslov.jetbrains.services.EncoderUtilTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Mikhail Suslov
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({EncoderAppTest.class, EncoderUtilTest.class})
public class AllTestCases {
}
