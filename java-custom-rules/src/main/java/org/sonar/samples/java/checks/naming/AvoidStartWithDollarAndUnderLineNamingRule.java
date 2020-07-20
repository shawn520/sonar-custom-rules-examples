package org.sonar.samples.java.checks.naming;

import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.*;
import org.sonar.samples.java.checks.AbstractClassNameCheck;


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
public class AvoidStartWithDollarAndUnderLineNamingRule extends BaseTreeVisitor implements JavaFileScanner {
    private static final String DOLLAR = "$";
    private static final String UNDERSCORE = "_";
    private JavaFileScannerContext context;
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractClassNameCheck.class);
    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    public void visitClass(ClassTree tree) {
        String className = tree.simpleName().name();
        LOGGER.info("className = " + className );
        if(className.startsWith(DOLLAR) || className.startsWith(UNDERSCORE)) {
            context.reportIssue(this, tree, "AvoidStartWithDollarAndUnderLineNamingRule");
        }
        super.visitClass(tree);
    }

    public void visitMethod(MethodTree tree) {
        String mthodName = tree.simpleName().name();
        LOGGER.info("mthodName = " + mthodName );
        if(mthodName.startsWith(DOLLAR) || mthodName.startsWith(UNDERSCORE)) {
            context.reportIssue(this, tree, "AvoidStartWithDollarAndUnderLineNamingRule");
        }
        super.visitMethod(tree);
    }

    public void visitVariable(VariableTree tree) {
        String variableName = tree.simpleName().name();
        LOGGER.info("variableName = " + variableName );
        if(variableName.startsWith(DOLLAR) || variableName.startsWith(UNDERSCORE)) {
            context.reportIssue(this, tree, "AvoidStartWithDollarAndUnderLineNamingRule");
        }
        super.visitVariable(tree);
    }
}
