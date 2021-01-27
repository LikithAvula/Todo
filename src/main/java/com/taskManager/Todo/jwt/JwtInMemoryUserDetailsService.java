package com.taskManager.Todo.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taskManager.Todo.Dao.UserDao;
import com.taskManager.Todo.entitiy.User;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	@Autowired
	public UserDao userDao;
	
	/*
	 * static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
	 * 
	 * static { inMemoryUserList.add(new JwtUserDetails(1L, "likith",
	 * "$2y$12$J4HKz932QqYeLLImauPjVOOS4mz/kYl8/uCMtgBmEGoObptHHSyNC",
	 * "ROLE_USER_2")); }
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUserDetails(username);
		JwtUserDetails userDetails;
		if( user !=null) {
			userDetails = new JwtUserDetails(1L, user.getUserName(), user.getPassword(),user.getRole());
		}else {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}
		
	
		return userDetails;
	}

	/*
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException { Optional<JwtUserDetails> findFirst =
	 * inMemoryUserList.stream() .filter(user ->
	 * user.getUsername().equals(username)).findFirst();
	 * 
	 * if (!findFirst.isPresent()) { throw new
	 * UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username)); }
	 * 
	 * return findFirst.get(); }
	 */

}
