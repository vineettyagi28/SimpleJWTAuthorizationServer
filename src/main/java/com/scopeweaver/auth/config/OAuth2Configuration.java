/**
 * 
 */
package com.scopeweaver.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

/**
 * @author vineet
 *
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

	@Value(value = "classpath:jwt.jks")
	private Resource jwtFile;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("web_app").autoApprove(true).scopes("foo").authorities("FOO_READ", "FOO_WRITE")
				.authorizedGrantTypes("implicit", "refresh_token", "password", "authorization_code");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenConverter())
				.authenticationManager(this.authenticationManager);
	}

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(tokenConverter());
	}

	@Bean
	protected JwtAccessTokenConverter tokenConverter() {
		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(jwtFile, "mySecretKey".toCharArray());
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setKeyPair(keyStoreKeyFactory.getKeyPair("jwt"));
		return converter;
	}
}