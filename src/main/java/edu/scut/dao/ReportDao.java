package edu.scut.dao;

import edu.scut.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportDao extends JpaRepository<Report,Integer> {
}
