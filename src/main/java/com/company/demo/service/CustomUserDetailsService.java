package com.company.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.demo.entity.CustomUserDetails;
import com.company.demo.entity.User;
import com.company.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
		User user = userRepository.findByPhone(phone).orElse(null);

		if (user == null) {
			String msg = "Phone number " + phone + " not found";
			System.out.println("----- " + msg + " -----");
			throw new UsernameNotFoundException(msg);
		}

		return new CustomUserDetails(user);
	}

}
