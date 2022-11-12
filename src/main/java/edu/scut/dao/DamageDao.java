package edu.scut.dao;

import edu.scut.model.Damage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamageDao extends JpaRepository<Damage,Integer> {

}
