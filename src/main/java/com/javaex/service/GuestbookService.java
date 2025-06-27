package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.UserRepository;

@Service
public class GuestbookService {

	@Autowired
	private UserRepository userRepository;
}
