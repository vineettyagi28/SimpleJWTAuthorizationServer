/**
 * 
 */
package com.scopeweaver.auth.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.scopeweaver.auth.model.User;

/**
 * @author vineet
 *
 */
public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);

	List<User> findByName(String name);

}
