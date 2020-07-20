package org.sonar.samples.java.checks.naming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.*;
import org.sonar.samples.java.checks.AbstractClassNameCheck;

import java.util.regex.Pattern;

/**
 * @author Shawn
 * @date 2020/7/20
 */
@Rule(
        key = "AvoidStartWithDollarAndUnderLineNamingRule",
        name = "AvoidStartWithDollarAndUnderLineNamingRule",
        description = "All names should not start or end with an underline or a dollar sign.",
        priority = Priority.CRITICAL,
        tags = {"bug"})
public class PackageNaming extends BaseTreeVisitor implements JavaFileScanner {
    private static final String PATTERN = "^[a-z0-9]+(\\\\.[a-z][a-z0-9]*)*$";
    private static final String UNDERSCORE = "_";
    private JavaFileScannerContext context;
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractClassNameCheck.class);
    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    public void visitPackage(PackageDeclarationTree tree) {
        String packageName = tree.packageName().toString();
        LOGGER.info("packageName = " + packageName );
//        packageName = "hello 1";
        boolean match = Pattern.matches(PATTERN, packageName);
        if(!match) {
            context.reportIssue(this, tree, "AvoidStartWithDollarAndUnderLineNamingRule");
        }
        super.visitPackage(tree);
    }

}
