package org.sonar.samples.java.checks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.java.checks.helpers.Javadoc;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.MethodTree;

/**
 * Rule 70： Methods must have JavaDoc comments
 * @author Shawn
 * @date 2020/7/21
 */
@Rule(
        key = "MethodCommentCheck",
        name = "Methods must have JavaDoc Comments",
        description = "Methods must have JavaDoc Comments",
        priority = Priority.MAJOR,
        tags = {"bug"})
public class MethodCommentCheck extends BaseTreeVisitor implements JavaFileScanner {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractClassNameCheck.class);

    private JavaFileScannerContext context;
    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    public void visitMethod(MethodTree tree) {
        Javadoc javadoc = new Javadoc(tree);
        if(javadoc.noMainDescription()) {
            context.reportIssue(this, tree, "Methods must have JavaDoc Comments");
        }
        super.visitMethod(tree);
    }
}
