package yyl.springboot.dialect;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.expression.IExpressionObjectFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.standard.processor.AbstractStandardConditionalVisibilityTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;
import org.unbescape.html.HtmlEscape;

/**
 * 自定义_Thymeleaf_标签
 * @author YYL
 */
@Component
public class CustomThymeleafDialect extends AbstractProcessorDialect implements IDialect, IExpressionObjectDialect {

    private static class NAMES {
        static final String DIALECT_NAME = "CUSTOM";
        static final String DIALECT_PREFIX = "__";
        static final String IS_VISIBLE = "isVisible";
        static final String TEXT = "text";
    }

    private final CustomTools tools;
    private final ExpressionObjectFactory expressionObjectFactory;;

    public CustomThymeleafDialect() {
        super(NAMES.DIALECT_NAME, NAMES.DIALECT_PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
        this.tools = new CustomTools();
        this.expressionObjectFactory = new ExpressionObjectFactory(this.tools);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<>();
        processors.add(new TextModifierAttrProcessor());
        return processors;
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return expressionObjectFactory;
    }

    // <div __:isVisible="1000">
    public class IsVisibleElementProcessor extends AbstractStandardConditionalVisibilityTagProcessor {

        protected IsVisibleElementProcessor() {
            super(TemplateMode.HTML, NAMES.DIALECT_PREFIX, NAMES.IS_VISIBLE, 300);
        }

        @Override
        protected boolean isVisible(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName, String attributeValue) {
            return tools.isTree(attributeValue);
        }
    }

    // <div __:text="">
    private class TextModifierAttrProcessor extends AbstractAttributeTagProcessor {

        protected TextModifierAttrProcessor() {
            super(TemplateMode.HTML, // This processor will apply only to HTML mode
                    NAMES.DIALECT_PREFIX, // Prefix to be applied to name for matching
                    null, // No tag name: match any tag name
                    false, // No prefix to be applied to tag name
                    NAMES.TEXT, // Name of the attribute that will be matched
                    true, // Apply dialect prefix to attribute name
                    300, // Precedence (inside dialect's precedence)
                    true); // Remove the matched attribute afterwards
        }

        @Override
        protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName, String attributeValue,
                IElementTagStructureHandler structureHandler) {
            structureHandler.setBody(HtmlEscape.escapeHtml5(tools.text(attributeValue)), false);
        }
    }

    public static class ExpressionObjectFactory implements IExpressionObjectFactory {

        private static final Set<String> ALL_EXPRESSION_OBJECT_NAMES;
        static {
            final Set<String> allExpressionObjectNames = new LinkedHashSet<String>();
            allExpressionObjectNames.add(NAMES.DIALECT_PREFIX);
            ALL_EXPRESSION_OBJECT_NAMES = Collections.unmodifiableSet(allExpressionObjectNames);
        }
        private final CustomTools tools;

        public ExpressionObjectFactory(CustomTools tools) {
            this.tools = tools;
        }

        @Override
        public Set<String> getAllExpressionObjectNames() {
            return ALL_EXPRESSION_OBJECT_NAMES;
        }

        @Override
        public Object buildObject(IExpressionContext context, String expressionObjectName) {
            if (NAMES.DIALECT_PREFIX.equals(expressionObjectName)) {
                return tools;
            }
            return null;
        }

        @Override
        public boolean isCacheable(String expressionObjectName) {
            return false;
        }
    }

    public static class CustomTools {
        /** [[${#__.text('date')}]] */
        public String text(String value) {
            if ("date".equals(value)) {
                return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            }
            if ("time".equals(value)) {
                return new SimpleDateFormat("HH:mm:ss").format(new Date());
            }
            return "";
        }

        /** [[${#__.isTree(value)}]] */
        public boolean isTree(String value) {
            return "true".equals(value);
        }
    }
}
