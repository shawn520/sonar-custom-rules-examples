package org.sonar.samples.java.checks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;

/**
 * 规则：
 * 抽象类命名使用 Abstract 或 Base 开头
 * @author Shawn
 * @date 2020/7/17
 */
@Rule(key = "AbstractClassNameCheck")
public class AbstractClassNameCheck extends BaseTreeVisitor implements JavaFileScanner {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractClassNameCheck.class);

    private JavaFileScannerContext context;
    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    public void visitClass(ClassTree tree) {
        String className = tree.simpleName().name();
        LOGGER.info(className +"<<>>" + tree.symbol().isAbstract());

        if(tree.symbol().isAbstract()) {
            String abName = "Abstract";
            String baseName = "Base";
            if(className.indexOf(abName) !=0 && className.indexOf(baseName) !=0) {
                context.reportIssue(this, tree, "The Name Of Abstract Class should use Abstract or Base first");
            }

        }
        super.visitClass(tree);
    }
}
