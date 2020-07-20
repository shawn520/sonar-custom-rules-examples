package org.sonar.samples.java.checks.naming;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author Shawn
 * @date 2020/7/17
 */
public class PackageNameTest {
    @Test
    public void test() {
        JavaCheckVerifier.verify("src/test/files/naming/hello/PackageNaming.java", new PackageNaming());
    }
}
