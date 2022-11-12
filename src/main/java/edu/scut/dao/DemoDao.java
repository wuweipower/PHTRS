package edu.scut.dao;

import edu.scut.model.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoDao extends JpaRepository<Demo,Integer> {
    Demo findByName(String name);
}
