package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.entity.ToDoEntity;
import com.hcl.repository.ToDoRepository;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	ToDoRepository toDoRepository;

	@Override
	public List<ToDoEntity> getAllToDoLists() {
		return toDoRepository.findAll();
	}

	@Override
	public ToDoEntity getToDoListById(Long id) {
		return toDoRepository.findById(id).get();
	}

	@Override
	public void saveToDoList(ToDoEntity entity) {
		toDoRepository.save(entity);
	}

	@Override
	public void deleteToDoList(Long id) {
		toDoRepository.deleteById(id);
	}

}
