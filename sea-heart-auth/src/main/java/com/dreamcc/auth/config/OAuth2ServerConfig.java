package com.dreamcc.auth.config;

import com.dreamcc.common.core.constant.SecurityConstants;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;


/**
 * @Title: sea-heart
 * @Package: com.dreamcc.auth.config
 * @Description: OAuth2服务器配置, 使用redis储存token
 * @Author: dreamcc
 * @Date: 2019/7/25 11:04
 * @Version: V1.0
 */
@Configuration
public class OAuth2ServerConfig {


	/**
	 * 配置授权服务器
	 */
	@Configuration
	@EnableAuthorizationServer
	protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

		@Autowired
		private AuthenticationManager authenticationManager;
		@Autowired
		private RedisConnectionFactory redisConnectionFactory;
		@Autowired
		private UserDetailsService userDetailsService;


		/**
		 * 配置密码认证
		 *
		 * @param endpoints
		 * @throws Exception
		 */
		@Override
		@SneakyThrows
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
			endpoints
					.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
					.tokenStore(tokenStore())
					.authenticationManager(authenticationManager)
					.userDetailsService(userDetailsService);
		}

		/**
		 * 表单认证
		 *
		 * @param oauthServer
		 */
		@Override
		@SneakyThrows
		public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
			oauthServer
					.allowFormAuthenticationForClients()
					.checkTokenAccess("permitAll()");
		}

		@Bean
		public TokenStore tokenStore() {
			RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
			tokenStore.setPrefix(SecurityConstants.PROJECT_PREFIX + SecurityConstants.OAUTH_PREFIX);
			return tokenStore;
		}
		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			//配置两个客户端,一个用于password认证一个用于client认证
			clients.inMemory().withClient("client_1")
					.resourceIds("order")
					.authorizedGrantTypes("client_credentials", "refresh_token")
					.scopes("select")
					.authorities("client")
					.secret("123456")
					.and().withClient("client_2")
					.resourceIds("order")
					.authorizedGrantTypes("password", "refresh_token")
					.scopes("select")
					.authorities("client")
					.secret("123456");
		}
	}

	/**
	 * 配置资源服务器
	 */
	@Configuration
	@EnableResourceServer
	protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	}
}
