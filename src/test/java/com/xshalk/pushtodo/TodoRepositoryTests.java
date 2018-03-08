package com.xshalk.pushtodo;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryTests {
    
    @Autowired
    EntityManager entityManager;
    
    
    @Autowired
    TodoRepository repo;
    
    @Test
    public void test_env() {
        assertThat(entityManager).isNotNull();
    }
    
    
    @Test
    public void test_find_by_tag() {
        Todo t1 = new Todo( "todo1", "des1", null, null);
        Todo t2 = new Todo( "todo2", "des2", null, null);
        Todo t3 = new Todo( "todo3", "des2", null, null);
        ArrayList<String> taglist1 = new ArrayList<>(Arrays.asList("tag1","tag2","tag3"));
        ArrayList<String> taglist2 = new ArrayList<>(Arrays.asList("tag1","tag2"));
        ArrayList<String> taglist3 = new ArrayList<>(Arrays.asList("tag1","tag3"));
        t1.setTags(taglist1);
        t2.setTags(taglist2);
        t3.setTags(taglist3);
        entityManager.persist(t1);
        entityManager.persist(t2);
        entityManager.persist(t3);
        
        List<Todo> todolist1 = repo.findByTag("tag1");
        assertThat(todolist1).isNotEmpty().contains(t1,t2,t3);

        List<Todo> todolist2 = repo.findByTag("tag3");
        assertThat(todolist2).isNotEmpty().contains(t1,t3);
    }

}
