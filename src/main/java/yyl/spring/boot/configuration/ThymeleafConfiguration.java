package yyl.spring.boot.configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.Arguments;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Node;
import org.thymeleaf.dom.Text;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.processor.attr.AbstractTextChildModifierAttrProcessor;
import org.thymeleaf.processor.element.AbstractMarkupSubstitutionElementProcessor;

@Configuration
public class ThymeleafConfiguration {

	@Bean
	public CustomThymeleafDialect shiroDialect() {
		return new CustomThymeleafDialect();
	}

	// ~InnerClass
	public static class CustomThymeleafDialect extends AbstractDialect {

		private static final String PREFIX = "my";

		@Override
		public String getPrefix() {
			return PREFIX;
		}

		@Override
		public Set<IProcessor> getProcessors() {
			final Set<IProcessor> processors = new HashSet<>();
			processors.add(new HelloMarkupSubstitutionElementProcessor("hello"));
			processors.add(new HelloTextChildModifierAttrProcessor("hello"));
			return processors;
		}
	}

	// <X:hello>
	public static class HelloMarkupSubstitutionElementProcessor extends AbstractMarkupSubstitutionElementProcessor {
		protected HelloMarkupSubstitutionElementProcessor(String matcher) {
			super(matcher);
		}

		@Override
		protected List<Node> getMarkupSubstitutes(Arguments arguments, Element element) {
			List<Node> nodes = new ArrayList<>();
			Element container = new Element("div");
			container.addChild(new Text("Hello World!"));
			nodes.add(container);
			return nodes;
		}

		@Override
		public int getPrecedence() {
			return 0;
		}
	}

	// <div my:hello="" ></div>
	public static class HelloTextChildModifierAttrProcessor extends AbstractTextChildModifierAttrProcessor {
		protected HelloTextChildModifierAttrProcessor(String matcher) {
			super(matcher);
		}

		@Override
		protected String getText(Arguments arguments, Element element, String attributeName) {
			final String attributeValue = element.getAttributeValue(attributeName);
			return "hello " + attributeValue;
		}

		@Override
		public int getPrecedence() {
			return 0;
		}
	}
}
