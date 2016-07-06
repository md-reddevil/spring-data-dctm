package com.emc.documentum.springdata.core;

import com.emc.documentum.springdata.entitymanager.mapping.DctmMappingContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.mapping.model.FieldNamingStrategy;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by waliar on 7/5/16.
 */
@Configuration
public class DctmAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DctmMappingContext mongoMappingContext(BeanFactory beanFactory)
            throws ClassNotFoundException {
        DctmMappingContext context = new DctmMappingContext();
//        context.setInitialEntitySet(getInitialEntitySet(beanFactory));
        return context;
    }

//    private Set<Class<?>> getInitialEntitySet(BeanFactory beanFactory)
//            throws ClassNotFoundException {
//        Set<Class<?>> entitySet = new HashSet<Class<?>>();
//        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(
//                false);
//`        scanner.setResourceLoader(this.resourceLoader);
//        scanner.addIncludeFilter(new AnnotationTypeFilter(Document.class));
//        scanner.addIncludeFilter(new AnnotationTypeFilter(Persistent.class));
//        for (String basePackage : getMappingBasePackages(beanFactory)) {
//            if (StringUtils.hasText(basePackage)) {
//                for (BeanDefinition candidate : scanner
//                        .findCandidateComponents(basePackage)) {
//                    entitySet.add(ClassUtils.forName(candidate.getBeanClassName(),
//                            this.classLoader));
//                }
//            }
//        }
//        return entitySet;
//    }
}
