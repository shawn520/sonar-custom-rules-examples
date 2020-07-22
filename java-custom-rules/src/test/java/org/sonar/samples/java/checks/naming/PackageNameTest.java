package org.sonar.samples.java.checks.naming;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;
import org.sonar.samples.java.checks.AbstractClassNameCheck;

/**
 * @author Shawn
 * @date 2020/7/17
 */
public class PackageNameTest {
    @Test
    public void test() {
        JavaCheckVerifier.newVerifier()
            .onFile("src/test/files/naming/PackageNaming.java")
            .withCheck(new PackageNaming())
            .verifyIssues();
    }
}
