package com.soda.common.bootstrap;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.util.ClassUtils;

import java.beans.Introspector;

/**
 * 注解型Bean命名器。
 *
 * 把Service、Dao层的Bean Name规定为以小写开头，并去除“Impl”字符；
 *
 * @author J
 */
public class AppAnnotationBeanNameGenerator implements BeanNameGenerator {

    /**
     * 忽略类名后缀存在此数组的类
     */
    private static final String[] SUFFIX_IGNORE_ARR = {"Controller"};
    private static final String IMPL_SUFFIX = "Impl";
    private static final int SERVICE_SUFFIX_IGNORE_LEN = IMPL_SUFFIX.length();

    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        return buildBeanName(definition);
    }

    private String buildBeanName(BeanDefinition definition) {
        String shortClassName = ClassUtils.getShortName(definition.getBeanClassName());
        for (String s : SUFFIX_IGNORE_ARR) {
            if (shortClassName.endsWith(s))
                return Introspector.decapitalize(shortClassName);
        }
        String firstChar = shortClassName.substring(0, 1);
        shortClassName = shortClassName.replace(firstChar, firstChar.toLowerCase());
        if (shortClassName.endsWith(IMPL_SUFFIX)) {
            shortClassName = shortClassName.substring(0, shortClassName.length() - SERVICE_SUFFIX_IGNORE_LEN);
        }
        return Introspector.decapitalize(shortClassName);
    }

}
