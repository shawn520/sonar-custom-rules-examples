package org.sonar.samples.java.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author Shawn
 * @date 2020/7/17
 */
public class AbstractClassNameCheckTest {
    @Test
    public void test() {
        JavaCheckVerifier.verify("src/test/files/HiClass.java", new AbstractClassNameCheck());
    }
}
