package com.scopeweaver.auth.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scopeweaver.auth.model.User;
import com.scopeweaver.auth.service.UserService;

/**
 * @author vineet
 *
 */
@RequestMapping("/users/**")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasAuthority('FOO_READ')")
	@GetMapping("{username}")
	public User getUser(@PathVariable String username) {
		return userService.getByUsername(username);
	}
}
