package com.dreamcc.common.security.component;

import com.dreamcc.common.core.constant.SecurityConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.security.component
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/7/30 16:51
 * @Version: V1.0
 */
@Slf4j
public class SeaSecurityBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

	/**
	 * 根据注解值动态注入资源服务器的相关属性
	 * @param importingClassMetadata
	 * @param registry
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		if(registry.isBeanNameInUse(SecurityConstants.RESOURCE_SERVER_CONFIGURER)){
			log.warn("本地存在资源服务器配置，覆盖默认配置:" + SecurityConstants.RESOURCE_SERVER_CONFIGURER);
			GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
			beanDefinition.setBeanClass(SeaResourceServerConfigurerAdapter.class);
			registry.registerBeanDefinition(SecurityConstants.RESOURCE_SERVER_CONFIGURER, beanDefinition);

		}
	}
}
