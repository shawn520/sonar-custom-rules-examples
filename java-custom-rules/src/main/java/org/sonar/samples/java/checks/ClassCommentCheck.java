package org.sonar.samples.java.checks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.java.checks.helpers.Javadoc;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.MethodTree;

/**
 * Rule 69： Classes and Interfaces must have JavaDoc Comments
 * @author Shawn
 * @date 2020/7/21
 */
@Rule(
        key = "ClassCommentCheck",
        name = "Classes and Interfaces must have JavaDoc Comments",
        description = "Classes and Interfaces must have JavaDoc Comments",
        priority = Priority.MAJOR,
        tags = {"bug"})
public class ClassCommentCheck extends BaseTreeVisitor implements JavaFileScanner {

    private JavaFileScannerContext context;
    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    public void visitClass(ClassTree tree) {
        Javadoc javadoc = new Javadoc(tree);
        if(javadoc.noMainDescription()) {
            context.reportIssue(this, tree, "Classes and Interfaces must have JavaDoc Comments");
        }
        super.visitClass(tree);
    }
}
