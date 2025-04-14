package com.hcl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.entity.ToDoEntity;

@Service
public interface ToDoService {

	public abstract List<ToDoEntity> getAllToDoLists();

	public abstract ToDoEntity getToDoListById(Long id);

	public abstract void saveToDoList(ToDoEntity entity);

	public abstract void deleteToDoList(Long id);
	
	public abstract void deleteToDoList();

}
