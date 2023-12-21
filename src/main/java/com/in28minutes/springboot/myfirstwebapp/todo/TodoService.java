package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService {
    private static List<Todo> todo = new ArrayList<>();
    static {
        todo.add(new Todo(1,"Nahom","Go home", LocalDate.now().plusDays(1),false));
        todo.add(new Todo(2,"Abel","Move out", LocalDate.now().plusDays(28),false));
        todo.add(new Todo(3,"Bereketi","Work out", LocalDate.now().plusDays(8),false));
    }
    public List<Todo> findByUser(String username){
        return todo;
    }
}
