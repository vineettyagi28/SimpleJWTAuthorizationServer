/**
 * 
 */
package com.scopeweaver.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scopeweaver.auth.model.User;
import com.scopeweaver.auth.repository.UserRepository;

/**
 * @author vineet
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User save(User u) {
		return userRepository.save(u);
	}
}
