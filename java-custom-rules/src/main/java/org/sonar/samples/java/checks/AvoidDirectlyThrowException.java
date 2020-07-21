package org.sonar.samples.java.checks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.java.checks.helpers.Javadoc;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.*;

/**
 * @author Shawn
 * @date 2020/7/21
 */
@Rule(
        key = "AvoidDirectlyThrowException",
        name = "Avoid directly throwing instance of Exception class",
        description = "Avoid directly throwing instance of Exception class",
        priority = Priority.MAJOR,
        tags = {"bug"})
public class AvoidDirectlyThrowException extends BaseTreeVisitor implements JavaFileScanner {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractClassNameCheck.class);

    private JavaFileScannerContext context;
    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    public void visitCatch(CatchTree tree) {
        VariableTree para = tree.parameter();
        if("Exception".equals(para.type())) {
            context.reportIssue(this, tree, "Avoid directly throwing instance of Exception class");
        }

    }

    public void visitMethod(MethodTree tree) {
        ListTree<TypeTree> exceptions =  tree.throwsClauses();
        for(TypeTree exception: exceptions) {
            if("Exception".equals(exception.symbolType().toString())) {
                context.reportIssue(this, tree, "Avoid directly throwing instance of Exception class");
            }
        }
    }
}
