/**
 * 
 */
package com.scopeweaver.auth.model;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

/**
 * @author vineet
 *
 */
@Document(collection = "users")
@Data
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6215546109335369404L;

	private String name;
	private String username;
	private String password;
	private List<GrantedAuthority> authorities;

	public User(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public User() {
	}

	public User(String name, String username, String password, String[] grantedAuthorities) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.authorities = AuthorityUtils.createAuthorityList(grantedAuthorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
