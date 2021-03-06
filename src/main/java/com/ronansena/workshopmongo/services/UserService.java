package com.ronansena.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronansena.workshopmongo.domain.User;
import com.ronansena.workshopmongo.dto.UserDTO;
import com.ronansena.workshopmongo.repository.UserRepository;
import com.ronansena.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public User insert(User obj){
		return repo.insert(obj);
	}	

	public User fromDTO(UserDTO objDTO){
		return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
	}	
}
