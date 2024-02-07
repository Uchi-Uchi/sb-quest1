package com.udemy.spring_try.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.udemy.spring_try.model.Todo;

@Service
public class TodoService {
	
	DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	private List<Todo> allTodos = new ArrayList<>(Arrays.asList(
			new Todo("1","買い物","着手","野菜を買う"),
			new Todo("2","洗濯","完了","タオルを洗う"),
			new Todo("3","料理","未着手","肉じゃがを作る"),
			new Todo("4","掃除","未着手","お風呂を掃除する"),
			new Todo("5","勉強","未着手","Javaを勉強する")));
	
	public List<Todo> getAllTodos(){
		return allTodos;
	}
	
	
	public Todo getTodo(String id) {
		for(int i = 0; i < allTodos.size(); i++) {
			if(allTodos.get(i).getId().equals(id)){
				return allTodos.get(i);
			}
		}
		return null;
	} 
	
	public void addTodo(Todo todo) {
		todo.setCreatedAt(dtformat.format(LocalDateTime.now()));
		todo.setUpdatedAt(dtformat.format(LocalDateTime.now()));
		allTodos.add(todo);
	}
	
	public void updateTodo(String id, Todo todo) {
		for(int i = 0; i < allTodos.size(); i++) {
			if(allTodos.get(i).getId().equals(id)){
				todo.setUpdatedAt(dtformat.format(LocalDateTime.now()));
//				String testCr = todo.getCreatedAt();
//				String testUp = todo.getUpdatedAt();
//				System.out.println(testCr);
//				System.out.println(testUp);
				allTodos.set(i, todo);
//				String testCr1 = allTodos.get(5).getCreatedAt();
//				String testUp1 = allTodos.get(5).getUpdatedAt();
//				System.out.println(testCr1);
//				System.out.println(testUp1);
			}
		}
	}
	
	public void deleteTodo(String id) {
		allTodos.removeIf(i -> i.getId().equals(id));
	}
	
	public List<Todo> getTodoByTitle(String title){
		return allTodos.stream().filter(todo -> todo.getTitle().equals(title))
			.collect(Collectors.toList());
	}
	
	public List<Todo> getTodoByStatus(String status){
		return allTodos.stream().filter(todo -> todo.getStatus().equals(status))
			.collect(Collectors.toList());
	}
	
	public List<Todo> getTodosortById(){
		return allTodos.stream().sorted(Comparator.comparing(Todo::getId))
			.collect(Collectors.toList()); 
	}
	
	public List<Todo> getTodosortByStatus(){
		return allTodos.stream().sorted(Comparator.comparing(Todo::getStatus))
			.collect(Collectors.toList());
	}
}
