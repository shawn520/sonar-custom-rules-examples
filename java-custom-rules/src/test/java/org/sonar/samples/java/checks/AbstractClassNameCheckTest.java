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
        JavaCheckVerifier.newVerifier()
            .onFile("src/test/files/AbstractClassNameCheck.java")
            .withCheck(new AbstractClassNameCheck())
            .verifyIssues();
    }
}
