package com.xshalk.pushtodo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.lang.String;
import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Integer>{

    
    List<Todo> findByCategoryLevel1(String categoryLevel1);
    
    List<Todo> findByCategoryLevel1AndCategoryLevel2(String categoryLevel1, String categoryLevel2);
    
    
    @Query("SELECT DISTINCT t from Todo t, IN(t.tags) tag where tag like CONCAT('%', :tag, '%') ")
    List<Todo> findByTag(@Param("tag") String tag);
    
}
