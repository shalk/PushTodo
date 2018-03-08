package com.xshalk.pushtodo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/todo/api")
public class TodoApiController {
    
    @Autowired
    private TodoRepository repo;
    
    
    @RequestMapping(method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@RequestBody Todo todo){
        return this.repo.save(todo);
    }
    
    @RequestMapping(path="/{id}",method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
       this.repo.delete(id); 
    }
    
    @RequestMapping(path="/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Todo modify(@PathVariable("id") Integer id, @RequestBody Todo todo) {
       if(this.repo.exists(id)) {
          return this.repo.save(todo);
       }
       return null;
    }
    
    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Todo get(@PathVariable("id") Integer id) {
      return this.repo.findOne(id);
    }
    
    @RequestMapping(method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> findAll() {
       return (List<Todo>) this.repo.findAll(); 
    }


}
