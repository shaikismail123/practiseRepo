package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hcl.entity.ToDoEntity;
import com.hcl.service.ToDoServiceImpl;

@Controller
public class ToDoController {

	@Autowired
	ToDoServiceImpl toDoServiceImpl;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listOfTodos", toDoServiceImpl.getAllToDoLists());
		return "index";
	}

	@GetMapping("/showNewTodoForm")
	public String showNewEmployeeForm(Model model) {
		System.out.println("Cursor enter in to this show New Todo Form ");
		model.addAttribute("todoList", new ToDoEntity());
		return "newtodolist";
	}

	@PostMapping("/saveTodoList")
	public String saveEmployee(@ModelAttribute("todoList") ToDoEntity toDoEntity) {
		System.out.println("Save method is called ");
		toDoServiceImpl.saveToDoList(toDoEntity);
		return "redirect:/";
	}

	@GetMapping("/showTodoListForUpdate/{id}")
	public String showTodoListForUpdate(@PathVariable(value = "id") long id, Model model) {
		System.out.println("Custor Enter in to show Todo List For Update");
		ToDoEntity todoList = toDoServiceImpl.getToDoListById(id);
		model.addAttribute("todoList", todoList);
		return "updateTodoList";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {
		this.toDoServiceImpl.deleteToDoList(id);
		return "redirect:/";
	}

	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") long id) {
		this.toDoServiceImpl.deleteToDoList(id);
		return "redirect:/";
	}
}
