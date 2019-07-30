package com.dreamcc.common.security.annotation;

import com.dreamcc.common.security.component.SeaResourceServerAutoConfiguration;
import com.dreamcc.common.security.component.SeaSecurityBeanDefinitionRegister;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.security.annotation
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/7/30 16:48
 * @Version: V1.0
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({SeaResourceServerAutoConfiguration.class, SeaSecurityBeanDefinitionRegister.class})
public @interface EnableSeaResourceServer {
}
