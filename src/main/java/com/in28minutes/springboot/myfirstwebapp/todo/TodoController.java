package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value = "list-todos", method = RequestMethod.GET)
    public String listAllTodos(ModelMap model){
        List<Todo> todos = todoService.findByUser("Nahom");
        model.addAttribute("todos",todos);
        return "listTodo";
    }
    @RequestMapping(value = "addTodo", method = RequestMethod.GET)
    public String showNewTodos(){
        return "todo";
    }
    @RequestMapping(value = "addTodo", method = RequestMethod.POST)
    public String AddNewTodos(ModelMap model, @RequestParam String description){
        String username = (String)model.get("name");
        todoService.addTodo(username,description, LocalDate.now().plusMonths(1),false);
        return "redirect:list-todos";
    }
}
