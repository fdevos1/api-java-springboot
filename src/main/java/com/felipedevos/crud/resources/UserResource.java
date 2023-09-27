package com.felipedevos.crud.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipedevos.crud.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping	
		public ResponseEntity<User> findAll() {
			User u = new User(1L, "Maria,", "maria@fakemail.com", "999998888", "12345");
			
			return ResponseEntity.ok().body(u);
		}
}
