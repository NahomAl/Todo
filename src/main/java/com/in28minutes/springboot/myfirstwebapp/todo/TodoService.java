package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService {
    private static List<Todo> todo = new ArrayList<>();
    private static int count = 0;
    static {
        todo.add(new Todo(++count,"Nahom","Go home", LocalDate.now().plusDays(1),false));
        todo.add(new Todo(++count,"Abel","Move out", LocalDate.now().plusDays(28),false));
        todo.add(new Todo(++count,"Bereketi","Work out", LocalDate.now().plusDays(8),false));
    }
    public void addTodo(String username,String description,LocalDate targetDate,boolean done){
        todo.add(new Todo(++count,username,description, targetDate,done));
    }
    public List<Todo> findByUser(String username){
        return todo;
    }
}
