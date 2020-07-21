package org.sonar.samples.java.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author Shawn
 * @date 2020/7/21
 */
public class ClassCommentCheckTest {
    @Test
    public void test() {
        JavaCheckVerifier.verify("src/test/files/ClassCommentCheck.java", new ClassCommentCheck());
    }
}
