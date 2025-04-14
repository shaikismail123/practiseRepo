package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.entity.ToDoEntity;


public interface ToDoRepository  extends JpaRepository<ToDoEntity, Long>{

}
